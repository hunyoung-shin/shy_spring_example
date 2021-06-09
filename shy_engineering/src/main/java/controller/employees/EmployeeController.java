package controller.employees;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.EmployeeCommand;

@Controller
@RequestMapping("emp")	// 받은 데이터중 emp 따로
public class EmployeeController {
	@RequestMapping("empList")	// empList 따로받
	public String empList() {
		return "employee/empList";
	}
	@RequestMapping("empReget")
	public String empReget() {
		return "employee/employeeForm";
	}
	@RequestMapping(value="empJoin", method = RequestMethod.POST)
	public String empJoin(EmployeeCommand employeeCommand) {
		System.out.println(employeeCommand.getEmpId());
		
		return "redirect:empList";
	}
}
