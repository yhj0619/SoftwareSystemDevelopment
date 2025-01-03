package sp5.sp5chapcboot.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sp5.sp5chapcboot.domain.Member;
import sp5.sp5chapcboot.service.MemberNotFoundException;
import sp5.sp5chapcboot.service.MemberService;

@Controller
public class MemberDetailController {

	private MemberService memberService;

	@Autowired
	public void setMemberRegisterService(
			MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/members/{id}")
	public String detail(@PathVariable("id") Long memId, Model model) {
		Member member = memberService.getMember(memId);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		model.addAttribute("member", member);
		return "member/memberDetail";
	}

	@ExceptionHandler(TypeMismatchException.class)
	public String handleTypeMismatchException() {
		return "member/invalidId";
	}

	@ExceptionHandler(MemberNotFoundException.class)
	public String handleNotFoundException() {
		return "member/noMember";
	}

}
