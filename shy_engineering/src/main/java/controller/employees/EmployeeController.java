package controller.employees;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.EmployeeCommand;
import service.employees.EmployeeDeleteService;
import service.employees.EmployeeDetailService;
import service.employees.EmployeeInfoService;
import service.employees.EmployeeListService;
import service.employees.EmployeeModifyService;
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
	@Autowired
	EmployeeInfoService employeeInfoService;
	@Autowired
	EmployeeModifyService employeeModifyService;
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	@Autowired
	EmployeeDetailService employeeDetailService;
	
	@RequestMapping("empList")	// empList 따로받
	public String empList(Model model) {	// Model : db로부터 받아와서 서비스로 보내는 역할
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
	@RequestMapping("empInfo")
	public String empInfo(@RequestParam(value="empNo") String empNo, Model model) {	//empNo를 요청해서 String empNo에 저장 + Model 이용
		employeeInfoService.empInfo(empNo, model);
		return "employee/employeeInfo";	// /empInfo를 통해 요청받은 자료를 여기페이지에 적용
	}
	@RequestMapping("empModify")
	public String empModify(@RequestParam(value="empNo") String empNo, Model model) {
		employeeInfoService.empInfo(empNo, model);
		return "employee/employeeModify";
	}
	@RequestMapping("empModifyOk")
	public String empModifyOk(EmployeeCommand employeeCommand) {
		employeeModifyService.empModify(employeeCommand);
		return "redirect:empInfo?empNo=" + employeeCommand.getEmpNo();
	}
	@RequestMapping("empDelete")
	public String empDelete(@RequestParam(value="empNo") String empNo) {
		employeeDeleteService.empDelete(empNo);
		return "redirect:empList";
	}
	@RequestMapping("empMyPage")
	public String empMyPage() {
		return "employee/empMyPage";
	}
	@RequestMapping("empMyInfo")
	public String empMyInfo(HttpSession session, Model model) {
		employeeDetailService.empInfo(session, model);
		return "";
	}
}
