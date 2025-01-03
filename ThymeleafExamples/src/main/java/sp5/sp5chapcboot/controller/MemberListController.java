package sp5.sp5chapcboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sp5.sp5chapcboot.domain.Member;
import sp5.sp5chapcboot.service.MemberService;

@Controller
public class MemberListController {

	private MemberService memberService;

	@Autowired
	public void setMemberRegisterService(
			MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/members")
	public String list(
			@ModelAttribute("cmd") ListCommand listCommand,
			Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "member/memberList";
		}		
		if (listCommand.getFrom() != null && listCommand.getTo() != null) {
			List<Member> members = memberService.getMemberList(listCommand.getFrom(), listCommand.getTo()); 
			model.addAttribute("members", members);
		}
		return "member/memberList";
	}

}