package service.product;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import command.ProductCommand;
import model.AuthInfo;
import model.ProductDTO;

public class ProductJoinService {
	public void prodJoin(ProductCommand productCommand, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empNo = authInfo.getGrade();
		ProductDTO dto = new ProductDTO();
		dto.setCatNum(productCommand.getCatNum());
		dto.setEmpNo(empNo);
		dto.setProdInfo(productCommand.getProdInfo());
		dto.setProdName(productCommand.getProdName());
		dto.setProdNo(productCommand.getProdNo());
		dto.setProdPrice(productCommand.getProdPrice());
		
		// file 처리
			// db에는 파일 이름만 저장될 예정, 이미지 저장은 upload 폴더에
			// -> 이미지나 동영상은 이미 압축되어 있는 상태로 저장되어있음
			// -> db에는 압축파일을 넣을 수 없는데, 이런 파일들을 압축해제하면 너무 용량이 커서 좋지 않음 + 속도도 저하
		String path = "WEB-INF/view/product/upload";	// upload 폴더 위치(web-inf에서 부터)
		String filePath = session.getServletContext().getRealPath(path); // path 전체경로
																		 // 여기에 파일명만 추가해도 쉽게 찾을 수 있음
		System.out.println(filePath);	// 확인을 위한 출력
		String goodsImage = "";
		if(productCommand.getProdImage() != null) {
			for(MultipartFile mf : productCommand.getProdImage()) {
				String original = mf.getOriginalFilename();	// 파일명
				// 파일명에서 확장자 가져오기
				String originalExt = original.substring(original.lastIndexOf("."));
				// 저장할 파일명 만들기	// -> uuid : 고유번호 만들기용
				String store = UUID.randomUUID().toString().replace("-", "") + originalExt;
				goodsImage += store + ",";
				// 파일 저장
				File file = new File(filePath + "/" + store);
				try {
					mf.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			dto.setProdImage(goodsImage);
		}
		
		
	}
}
