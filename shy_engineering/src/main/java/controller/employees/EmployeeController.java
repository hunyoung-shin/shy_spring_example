package controller.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.EmployeeCommand;
import service.employees.EmployeeListService;
import service.employees.EmployeeNoService;
import service.employees.EmployeeService;

@Controller
@RequestMapping("emp")	// 받은 데이터중 emp 따로
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EmployeeNoService employeeNoService;
	@Autowired
	EmployeeListService employeeListService;
	@RequestMapping("empList")	// empList 따로받
	public String empList(Model model) {
		employeeListService.empList(model);
		return "employee/empList";
	}
	@RequestMapping("empReget")
	public String empReget(Model model) {
		employeeNoService.getEmpNo(model);
		return "employee/employeeForm";
	}
	@RequestMapping(value="empJoin", method = RequestMethod.POST)
	public String empJoin(EmployeeCommand employeeCommand) {
		employeeService.insertEmp(employeeCommand);
		return "redirect:empList";
	}
	
}
