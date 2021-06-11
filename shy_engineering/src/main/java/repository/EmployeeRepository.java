package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.EmployeeDTO;

public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	private final String namespace = "mappers.employeeMapper";
	private String statement;
	public void insertEmployee(EmployeeDTO dto) {
		statement = namespace + ".employeeInsert";
		sqlSession.insert(statement, dto);
	}
	public int getEmpNo() {
		statement = namespace + ".empNo";
		return sqlSession.selectOne(statement);
	}
	public List<EmployeeDTO> empAllList() {
		statement = namespace + ".empAllList";
		return sqlSession.selectList(statement);
	}
	public EmployeeDTO empInfo(String empNo) {
		statement = namespace + ".empInfo";
		return sqlSession.selectOne(statement, empNo);	// 해당 statement와 일치한는 empNo를 가지는 dto의 줄 반환
	}
	public void empUpdate(EmployeeDTO dto) {
		statement = namespace + ".employeeUpdate";
		sqlSession.update(statement, dto);
	}
	public void empDelete(String empNo) {
		statement = namespace + ".employeeDelete";
		sqlSession.delete(statement, empNo);
	}
}
