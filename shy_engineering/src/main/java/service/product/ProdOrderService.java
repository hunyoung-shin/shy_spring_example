package service.product;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import command.ProdOrderCommand;
import model.AuthInfo;
import model.CartDTO;
import model.PurchaseDTO;
import repository.ProductRepository;

public class ProdOrderService {
	@Autowired
	ProductRepository productRepository;
	public String prodOrder(ProdOrderCommand prodOrderCommand, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String membId = authInfo.getUserId();
		PurchaseDTO dto = new PurchaseDTO();
		dto.setMembId(membId);
		dto.setPurchAddr(prodOrderCommand.getPurchAddr());
		dto.setPurchMsg(prodOrderCommand.getPurchMsg());
		dto.setPurchPhoneNumber(prodOrderCommand.getPurchPhoneNumber());
		dto.setPurchReceiver(prodOrderCommand.getPurchReceiver());
		dto.setPurchTotal(prodOrderCommand.getPurchTotal());
		// purchNo : 구매번호를 날짜로 사용
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");	// 날짜 형식 설정용
		String purchNo = df.format(new Date());
		dto.setPurchNo(purchNo);
		productRepository.purchInsert(dto);
		
		String prodNums[] = prodOrderCommand.getProdNums().split(",");
		for(String prodNum : prodNums) {
			// 카트에 있는 제품정보를 구매리스트에 복사하기 위해
			CartDTO d = new CartDTO();	// 아래 두개를 저장하기위해 임시로 불러옴
			d.setPurchNo(purchNo);
			d.setMembId(membId);
			d.setProdNo(prodNum);
			productRepository.purchListInsert(d);
			productRepository.cartProdDel(d);
		}
		return purchNo;
	}
}
