package controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.main.LoginService;

@Controller
public class MainController {
	@Autowired
	LoginService loginService;
	@RequestMapping(value = "/main", method = RequestMethod.GET)	// main으로 날아왔을 때 get형태로 받
	public String aaaa() {
		return "main";	// tomcat에게 전송
						// 원래는 주소와 jsp포함되어야 하지만, spring-context.xml에서 없어도 되게 설정해놓음
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value="loginId") String loginId, @RequestParam(value="loginPw") String loginPw,
						HttpServletRequest request) {	// -> section을 위해 request
														// model : 현재 페이지에서만 적용 -> 다른 페이지에서는 전달 불가
														// section : 다른 페이지에서도 전달 가능
		loginService.login(loginId, loginPw, request);
		return "redirect:main";
	}
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:main";
	}
	
}
