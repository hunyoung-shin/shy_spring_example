package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.CartDTO;
import model.CategoryDTO;
import model.PaymentDTO;
import model.ProdReviewDTO;
import model.ProductCartDTO;
import model.ProductDTO;
import model.PurchListDTO;
import model.PurchaseDTO;
import model.ReviewDTO;

public class ProductRepository {
	@Autowired
	SqlSession sqlSession;
	private final String namespace = "mappers.productMapper";
	private String statement;
	
	public String autoNum() {
		statement = namespace + ".autoNum";
		return sqlSession.selectOne(statement);
	}
	public List<CategoryDTO> catList() {
		statement = namespace + ".catList";
		return sqlSession.selectList(statement);
	}
	public void prodInsert(ProductDTO dto) {
		statement = namespace + ".prodInsert";
		sqlSession.insert(statement, dto);
	}
	public List<ProductDTO> prodList(){
		statement = namespace + ".prodList";
		return sqlSession.selectList(statement);
	}
	public ProductDTO prodInfo(String prodNo) {
		statement = namespace + ".prodInfo";
		return sqlSession.selectOne(statement, prodNo);
	}
	public void prodUpdate(ProductDTO dto) {
		statement = namespace + ".prodUpdate";
		sqlSession.update(statement, dto);
	}
	public void prodDelete(String prodNo) {
		statement = namespace + ".prodDelete";
		sqlSession.delete(statement, prodNo);
	}
	public void cartAdd(CartDTO dto) {
		statement = namespace + ".cartInsert";
		sqlSession.insert(statement, dto);
	}	// mapper 부분 잘 볼것 -> 자주 쓰이는 구문
	public List<String> memCart(String membId){
		statement = namespace + ".memCart";
		return sqlSession.selectList(statement, membId);
	}
	public ProductCartDTO cartList(CartDTO dto) {
		statement = namespace + ".cartList";
		return sqlSession.selectOne(statement, dto);
	}	// mapper에 resultMap 잘 보기
		// 미리 참고) association : 1대1 대응일때 사용
	public void cartQtyDown(CartDTO dto) {
		statement = namespace + ".cartQtyDown";
		sqlSession.update(statement, dto);
	}
	public void purchInsert(PurchaseDTO dto) {
		statement = namespace + ".purchInsert";
		sqlSession.insert(statement, dto);
	}
	public void purchListInsert(CartDTO dto) {
		statement = namespace + ".purchListInsert";
		sqlSession.insert(statement, dto);
	}	// mapper에서 잘 확인
	public void cartProdDel(CartDTO dto) {
		statement = namespace + ".cartProdDel";
		sqlSession.delete(statement, dto);
	}
	public List<PurchListDTO> purchList(String membId) {
		statement = namespace + ".purchList";
		return sqlSession.selectList(statement, membId);
	}
	public void payInsert(PaymentDTO dto) {
		statement = namespace + ".payInsert";
		sqlSession.insert(statement, dto);
	}// 여기 payNo 잘써먹는 형태이므로 잘 알아둘 것
	public void reviewWrite(ReviewDTO dto) {
		statement = namespace + ".reviewInsert";
		sqlSession.insert(statement, dto);
	}
	public ReviewDTO reviewSelect(ReviewDTO dto) {
		statement = namespace + ".reviewSelect";
		return sqlSession.selectOne(statement, dto);
	}
	public void reviewUpdate(ReviewDTO dto) {
		statement = namespace + ".reviewUpdate";
		sqlSession.update(statement, dto);
	}
	public List<ProdReviewDTO> prodReview(String prodNo) {
		statement = namespace + ".prodReviewSelect";
		return sqlSession.selectOne(statement, prodNo);
	}
	
}
