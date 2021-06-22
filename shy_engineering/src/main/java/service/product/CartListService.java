package service.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfo;
import model.CartDTO;
import model.ProductCartDTO;
import repository.ProductRepository;

public class CartListService {
	@Autowired
	ProductRepository productRepository;
	public void cartList(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String membId = authInfo.getUserId();
		// 현 접속자의 prod_no 리스트만 필요
		List<String> list = productRepository.memCart(membId);
		List<ProductCartDTO> pcList = new ArrayList<ProductCartDTO>();
		// 한번에 다 받아오지 못해서 한개 씩 받아야 함, 방법 알아둘 것
		for(String prodNo : list) {
			CartDTO dto = new CartDTO();
			dto.setProdNo(prodNo);
			dto.setMembId(membId);
			// 현 접속자 상품번호 하나에 해당되는 데이터를 하나씩 받아와서 list에 저장
			ProductCartDTO productCartDTO = productRepository.cartList(dto);
			pcList.add(productCartDTO);
		}
		model.addAttribute("list", pcList);
	}
}
