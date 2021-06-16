package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemberDeleteService;
import service.member.MemberDetailService;
import service.member.MemberInfoService;
import service.member.MemberJoinService;
import service.member.MemberListService;
import service.member.MemberModifyService;
import service.member.MemberUpdateService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired	// 이거로 객체 받아오려면 spring-member.xml의 context에 등록해야 함 -> 안그러면 list시 문제발생
	MemberJoinService memberJoinService;
	@Autowired	// -> 객체 생성은 Dispatcher가 자동으로 함
	MemberListService memberListService;
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	MemberModifyService memberModifyService;
	@Autowired
	MemberDeleteService memberDeleteService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberUpdateService memberUpdateService;
	
	@RequestMapping("agree")
	public String agree() {
		return "member/agree";
	}
	@RequestMapping("memReget")
	public String memReget() {
		return "member/memberForm";
	}
	@RequestMapping(value = "memJoin", method = RequestMethod.POST)
	public String memJoin(MemberCommand memberCommand) {
		memberJoinService.memberInsert(memberCommand); //ctrl누른상태로 눌러보면 잘 연결됨을 확인
		return "redirect:../main";// '../': 한단계 상위 폴더로
	}
	@RequestMapping("memList")
	public String memList(Model model) {
		memberListService.memList(model);
		return "member/memberList";	// model에 저장된 값을 list로
	}
	@RequestMapping("memInfo")
	public String memInfo(@RequestParam(value = "membId") String membId, Model model) {
		memberInfoService.memInfo(membId, model);
		return "member/memberInfo";
	}
	@RequestMapping("memModify")
	public String memModify(@RequestParam(value = "membId") String membId, Model model) {// 하나만 받으면 이렇게
		memberInfoService.memInfo(membId, model);
		// jsp파일과 함께있어야 model을 쓸수 있음
		return "member/memberModify";
	}
	@RequestMapping("memModifyOk")
	public String memModifyOk(MemberCommand memberCommand) {
		memberModifyService.memUpdate(memberCommand);
		return "redirect:memInfo?memId=" + memberCommand.getMembId();
		// 이처럼 link로 걸려있으면 session으로 저장
		// link는 한단계 거쳐서 전달하므로 model으로는 전달되지 않음
	}
	@RequestMapping("memDel")
	public String memDel(@RequestParam(value = "membId") String membId) {
		memberDeleteService.memDel(membId);
		return "redirect:memList";
	}
	@RequestMapping("memMyPage")
	public String myPage() {
		return "member/memberMyPage";
	}
	@RequestMapping("myInfo")
	public String myInfo(HttpSession session, Model model) {
		memberDetailService.memInfo(session, model);
		return "member/memberDetail";
	}
	@RequestMapping("memUpdate")
	public String memUpdate(HttpSession session, Model model) {
		memberDetailService.memInfo(session, model);
		return "member/memberUpdate";
	}
	@RequestMapping("memUpdateOk")
	public String updateOk(MemberCommand memberCommand, HttpSession session) {
		int i = memberUpdateService.memUpdate(memberCommand, session);
		if(i == 1) {
			return "redirect:myInfo";		// 정상적인 경우 회원정보 페이지로
		}else {
			return "redirect:memUpdate";	// pw틀렸으니 다시
		}
		
	}
}
