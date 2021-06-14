package service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.MemberDTO;
import repository.MemberRepository;

public class MemberListService {
	@Autowired
	MemberRepository memberRepository;
	public void memList(Model model) {	// dto를 context에 지정하게 되면 여기서 문제가 생김
										// 여러 객체를 반복해서 생성할 수 없기 때문
										// -> 최종 하나의 값만 계속해서 나오게 됨
		List<MemberDTO> list = memberRepository.memList();
		model.addAttribute("lists", list);	// model에 repository에서 받아온 값 저장
											// lists를 통해 memberList.jsp에서 반복문으로 출력
	}
}
