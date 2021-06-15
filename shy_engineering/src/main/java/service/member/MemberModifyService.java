package service.member;

import org.springframework.beans.factory.annotation.Autowired;

import command.MemberCommand;
import model.MemberDTO;
import repository.MemberRepository;

public class MemberModifyService {
	@Autowired
	MemberRepository memberRepository;
	public void memUpdate(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setDetailAddr(memberCommand.getDetailAddr());
		dto.setMembAddr(memberCommand.getMembAddr());
		dto.setMembConfirm(memberCommand.getMembConfirm());
		dto.setMembEmail(memberCommand.getMembEmail());
		dto.setMembPhoneNumber(memberCommand.getMembPhoneNumber());
		dto.setPostNumber(memberCommand.getPostNumber());
		dto.setMembId(memberCommand.getMembId());	// -> 얘는 업데이트하기 위해서 필요한 거
		memberRepository.memUpdate(dto);
	}
}
