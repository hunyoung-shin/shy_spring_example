package service.employees;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import command.EmployeeCommand;
import model.AuthInfo;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeUpdateService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	EmployeeRepository employeeRepository;
	
	public int empUpdate(EmployeeCommand employeeCommand, HttpSession session) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpDeptNumber(employeeCommand.getEmpDeptNumber());
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpPhoneNumber(employeeCommand.getEmpPhoneNumber());
		dto.setSalary(employeeCommand.getSalary());
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		dto.setEmpNo(Long.parseLong(authInfo.getGrade()));
		if(bcryptPasswordEncoder.matches(employeeCommand.getEmpPw(), authInfo.getUserPw())) {
			employeeRepository.empUpdate(dto);
			session.removeAttribute("pwFail");
			return 1;
		}
		else {
			session.setAttribute("pwFail", "비밀번호가 틀렸습니다.");
			return 2;
		}
		
	}
}
