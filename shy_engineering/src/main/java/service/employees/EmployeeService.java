package service.employees;

import command.EmployeeCommand;
import model.EmployeeDTO;

public class EmployeeService {
	public void insertEmp(EmployeeCommand employeeCommand) {
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpDeptNumber(employeeCommand.getEmpDeptNumber());
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpId(employeeCommand.getEmpId());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpNo(employeeCommand.getEmpNo());
		dto.setEmpPhoneNumber(employeeCommand.getEmpPhoneNumber());
		dto.setEmpPw(employeeCommand.getEmpPw());
		dto.setHire_date(employeeCommand.getHireDate());
		dto.setSalary(employeeCommand.getSalary());
	}
}
