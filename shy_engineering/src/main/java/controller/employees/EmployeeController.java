package controller.employees;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("emp")	// 받은 데이터중 emp 따로
public class EmployeeController {
	@RequestMapping("empList")	// empList 따로받
	public String empList() {
		return "employee/empList";
	}
}
