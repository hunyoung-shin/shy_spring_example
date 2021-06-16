package service.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import model.AuthInfo;
import repository.LoginRepository;

public class LoginService {
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public void login(String loginId, String loginPw, HttpServletRequest request) {
		AuthInfo authInfo = loginRepository.login(loginId);	//비밀번호는 암호화 되어있어서 여기서는 비교 무리..
		HttpSession session = request.getSession();
		session.removeAttribute("pwFail");
		if(authInfo == null) {
			session.setAttribute("userFail", "아이디가 존재하지 않습니다.");	// 나중에 다른 것으로 대체할 예정...(아래의 비번도)
		}else {
			if(bcryptPasswordEncoder.matches(loginPw, authInfo.getUserPw())){
				session.removeAttribute("pwFail");
				session.removeAttribute("userFail");
				// 로그인 정보를 가진 session
				session.setAttribute("authInfo", authInfo);
				//
			}
			else {
				session.removeAttribute("userFail");	// 비밀번호만 틀렸을 경우 아이디 문제는 제거해줘야 -> 하나밖에 보이지 않음
				session.setAttribute("pwFail", "비밀번호가 일치하지 않습니다.");
			}
		}
	}
	
}
