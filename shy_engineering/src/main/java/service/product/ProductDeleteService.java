package service.product;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import model.ProductDTO;
import repository.ProductRepository;

public class ProductDeleteService {
	@Autowired
	ProductRepository productRepository;
	public void prodDel(String prodNo, HttpSession session) {
		// 이미지 파일 삭제
		ProductDTO dto = productRepository.prodInfo(prodNo);
		String files[] = dto.getProdImage().split(",");
		// 파일 경로 입력
		String path = "WEB-INF/view/product/upload";
		String realPath = session.getServletContext().getRealPath(path);
		// 파일 존재할 경우
		if(files.length > 0) {
			for(String fileName : files) {
				String filePath = realPath + "/" + fileName;
				// 파일 정보 객체 생성
				File f = new File(filePath);
				// 파일 삭제
				if(f.exists()) {
					f.delete();
				}
			}
		}
		//db의 데이터 삭제
		productRepository.prodDelete(prodNo);
	}
}
