package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfo;
import model.MemberDTO;
import repository.MemberRepository;

public class MemberDetailService {
	@Autowired
	MemberRepository memberRepository;
	public void memInfo(HttpSession session, Model model) {
		// 쿼리스트링 없이 저장해야되므로 authInfo에서 가져와야함
		// -> authInfo는 session에 있으므로 session을 받아와서 아래처럼
		// 하지만 다른 위치에서도 보이면 안되므로 최종적으로 저장은 model에
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		// session은 object타입이라 형변환 시켜줘야 사용가능
		String membId = authInfo.getUserId();
		MemberDTO dto = memberRepository.memInfo(membId);
		model.addAttribute("dto", dto);
	}
}
