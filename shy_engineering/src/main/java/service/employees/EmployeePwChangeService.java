package service.employees;

import org.springframework.beans.factory.annotation.Autowired;

import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeePwChangeService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void pwOk(String userNo, String newPw) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpNo(Long.parseLong(userNo));
		dto.setEmpPw(newPw);
		employeeRepository.empPwChange(dto);
	}
}
