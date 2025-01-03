package com.example.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.member.model.MemberInfo;
import com.example.member.service.MemberService;

@Controller
@RequestMapping("/member/modify")
public class MemberModificationController {

	private static final String MEMBER_MODIFICATION_FORM = "member/modificationForm";
	private static final String MEMBER_NOT_FOUND_VIEW = "member/memberNotFound";
	
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping
	public String form(@ModelAttribute("modReq") MemberModRequest modReq,
						@RequestParam("mid") String memberId) {
		MemberInfo mi = memberService.getMemberInfo(memberId);
		if (mi == null)
			return MEMBER_NOT_FOUND_VIEW;

		modReq.setId(mi.getId());
		modReq.setName(mi.getName());
		modReq.setAddress(mi.getAddress());
		modReq.setEmail(mi.getEmail());
		modReq.setAllowNoti(mi.isAllowNoti());

		return MEMBER_MODIFICATION_FORM;
	}

	@PostMapping
	public String modify(@ModelAttribute("modReq") MemberModRequest modReq, Errors errors) {
		if (errors.hasErrors()) {
			return MEMBER_MODIFICATION_FORM;
		}
		try {
			memberService.modifyMemberInfo(modReq);
			return "member/modified";
		} catch (NotMatchPasswordException ex) {
			errors.rejectValue("currentPassword", "invalidPassword");
			return MEMBER_MODIFICATION_FORM;
		} catch (MemberNotFoundException ex) {
			return MEMBER_NOT_FOUND_VIEW;
		}
	}
}
