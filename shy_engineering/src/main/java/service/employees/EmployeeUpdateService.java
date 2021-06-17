package service.employees;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import command.EmployeeCommand;
import model.AuthInfo;
import model.EmployeeDTO;

public class EmployeeUpdateService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public int empUpdate(EmployeeCommand employeeCommand, HttpSession session) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpDeptNumber(employeeCommand.getEmpDeptNumber());
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpPhoneNumber(employeeCommand.getEmpPhoneNumber());
		dto.setSalary(employeeCommand.getSalary());
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		dto.setEmpNo(Long.parseLong(authInfo.getGrade()));
		if(bcryptPasswordEncoder.matches(employeeCommand.getEmpPw(), authInfo.getUserPw())) {
			// 여기부터...
		}
		
		return 1;
	}
}
