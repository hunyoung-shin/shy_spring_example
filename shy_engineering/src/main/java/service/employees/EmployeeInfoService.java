package service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeInfoService {
	@Autowired
	EmployeeRepository employeeRepository;	// repository로 보낼거기 때문에 객체생성
	public void empInfo(String empNo, Model model) {
		EmployeeDTO dto = employeeRepository.empInfo(empNo);	// DB에 저장된 한 행의 데이터는 하나의 DTO와 같다할 수 있음
																// -> 따라서 db의 한 행을 가져오려면 dto객체가 필요함
		model.addAttribute("emp", dto);	// 모델에 repository로부터 받아온 dto값 입력
										// 
	}
}
