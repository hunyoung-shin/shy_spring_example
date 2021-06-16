package service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.MemberDTO;
import repository.MemberRepository;

public class MemberInfoService {
	@Autowired
	MemberRepository memberRepository;
	public void memInfo(String membId, Model model) {
		MemberDTO dto = memberRepository.memInfo(membId);
		model.addAttribute("dto", dto);	// 'dto'라는 이름으로 jsp파일에 dto를 전달
										// -> jsp파일에도 이 이름으로 써줘야 함
	}
}
