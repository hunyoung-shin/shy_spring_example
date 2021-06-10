package controller.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.EmployeeCommand;
import service.employees.EmployeeService;

@Controller
@RequestMapping("emp")	// 받은 데이터중 emp 따로
public class EmployeeController {
	@Autowired	//xml에서 가져와서 사용할수 있도록
	EmployeeService employeeService;
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
		
		
		
		return "redirect:empList";
	}
}
