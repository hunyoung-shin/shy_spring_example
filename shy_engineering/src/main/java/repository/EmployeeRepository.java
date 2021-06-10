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
}
