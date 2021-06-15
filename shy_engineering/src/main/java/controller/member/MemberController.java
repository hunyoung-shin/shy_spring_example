package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemberDeleteService;
import service.member.MemberInfoService;
import service.member.MemberJoinService;
import service.member.MemberListService;
import service.member.MemberModifyService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired	// 이거로 객체 받아오려면 xml context에 등록해야 함 -> 안그러면 list시 문제발생
	MemberJoinService memberJoinService;
	@Autowired	// -> 객체 생성은 Dispatcher가 자동으로 함
	MemberListService memberListService;
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	MemberModifyService memberModifyService;
	@Autowired
	MemberDeleteService memberDeleteService;
	
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
	public String memInfo(@RequestParam(value = "memId") String memId, Model model) {
		memberInfoService.memInfo(memId, model);
		return "member/memberInfo";
	}
	@RequestMapping("memModify")
	public String memModify(@RequestParam(value = "memId") String memId, Model model) {// 하나만 받으면 이렇게
		memberInfoService.memInfo(memId, model);
		return "member/memberModify";
	}
	@RequestMapping("memModifyOk")
	public String memModifyOk(MemberCommand memberCommand) {
		memberModifyService.memUpdate(memberCommand);
		return "redirect:memInfo?memId=" + memberCommand.getMembId();
	}
	@RequestMapping("memDel")
	public String memDel(@RequestParam(value = "memId") String memId) {
		memberDeleteService.memDel(memId);
		return "redirect:memList";
	}
	
}
