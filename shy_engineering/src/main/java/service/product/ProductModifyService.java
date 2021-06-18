package service.product;

import org.springframework.beans.factory.annotation.Autowired;

import command.ProductCommand;
import model.ProductDTO;
import repository.ProductRepository;

public class ProductModifyService {
	@Autowired
	ProductRepository productRepository;
	public void prodUpdate(ProductCommand productCommand) {
		ProductDTO dto = new ProductDTO();
		dto.setProdName(productCommand.getProdName());
		dto.setProdPrice(productCommand.getProdPrice());
		dto.setProdInfo(productCommand.getProdInfo());
		dto.setProdNo(productCommand.getProdNo());
		productRepository.prodUpdate(dto);		
	}
}
