package controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value = "/main", method = RequestMethod.GET)	// main으로 날아왔을 때
	public String main() {
		return "main";	// tomcat에게 전송
						// 원래는 주소와 jsp포함되어야 하지만, spring-context.xml에서 없어도 되게 설정해놓음
	}
}
