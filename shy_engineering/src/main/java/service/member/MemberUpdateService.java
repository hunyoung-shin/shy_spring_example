package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import command.MemberCommand;
import model.AuthInfo;
import model.MemberDTO;
import repository.MemberRepository;

public class MemberUpdateService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public int memUpdate(MemberCommand memberCommand, HttpSession session) {
		MemberDTO dto = new MemberDTO();
		dto.setDetailAddr(memberCommand.getDetailAddr());
		dto.setMembAddr(memberCommand.getMembAddr());
		dto.setMembConfirm(memberCommand.getMembConfirm());
		dto.setMembEmail(memberCommand.getMembEmail());
		dto.setMembPhoneNumber(memberCommand.getMembPhoneNumber());
		dto.setPostNumber(memberCommand.getPostNumber());
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		dto.setMembId(authInfo.getUserId());
		if(bcryptPasswordEncoder.matches(memberCommand.getMembPw(), authInfo.getUserPw())) {
			memberRepository.memUpdate(dto);
			session.removeAttribute("pwFail");
			return 1;
		}else {
			session.setAttribute("pwFail", "비밀번호가 틀렸습니다.");
			return 2;
		}
		// 이렇게 할 수도 있구나.. 라고 생각
	}
}
