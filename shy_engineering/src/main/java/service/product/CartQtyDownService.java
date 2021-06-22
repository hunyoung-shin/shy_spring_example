package service.product;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import model.AuthInfo;
import model.CartDTO;
import repository.ProductRepository;

public class CartQtyDownService {
	@Autowired
	ProductRepository productRepository;
	public void CartQtyDown(String prodNo, String prodPrice, HttpSession session) {
		CartDTO dto = new CartDTO();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String membId = authInfo.getUserId();
		dto.setMembId(membId);
		dto.setCartPrice(prodPrice);
		dto.setProdNo(prodNo);
		productRepository.cartQtyDown(dto);
	}
}
