package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.MemberDTO;

public class MemberRepository {
	@Autowired
	SqlSession sqlSession;	// 데이터를 받아오기 위해
	private final String namespace="mappers.memberMapper";	// mybatis에 넘겨주기 위해
	private String statement;								// 이 두개 사용
	public void memberInsert(MemberDTO dto) {
		statement = namespace + ".memberInsert";
		sqlSession.insert(statement, dto);
	}
	public List<MemberDTO> memList() {
		statement = namespace + ".memberList";
		return sqlSession.selectList(statement);
	}
}
