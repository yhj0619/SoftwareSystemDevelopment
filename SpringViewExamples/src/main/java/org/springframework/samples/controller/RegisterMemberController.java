package org.springframework.samples.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.samples.model.Job;
import org.springframework.samples.model.MemberInfo;
import org.springframework.samples.validator.MemberInfoValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/register")
public class RegisterMemberController {

	private String formViewName = "registerMemberForm";

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}

	@ModelAttribute("jobCodes")
	public List<Job> referenceData1() {
		List<Job> jobCodes = new ArrayList<Job>();
		jobCodes.add(new Job("1", "컴포넌트 개발자"));
		jobCodes.add(new Job("2", "UI 개발자"));
		jobCodes.add(new Job("3", "웹 디자이너"));
		jobCodes.add(new Job("4", "기획자"));
		return jobCodes;
	}
	@ModelAttribute("favoritesOsNames")
	public String[] referenceData2() {
		return new String[] { "Windows", "Linux", "MacOS" };
	}
	
	@ModelAttribute("tools")
	public String[] referenceData3() {
		return new String[] { "Eclipse", "IntelliJ", "NetBeans" };
	}

	@ModelAttribute
	protected Object formBackingObject() throws Exception {
		return new MemberInfo();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute MemberInfo memberInfo,
			BindingResult result, Model model) {
		new MemberInfoValidator().validate(memberInfo, result);
		checkDuplicateId(memberInfo.getUserId(), result);
		if (result.hasErrors()) {
			return formViewName;
		}
		System.out.println(memberInfo.getJobCode());
		for (String s : memberInfo.getFavorites()) {
			System.out.print(s + " ");
		} 
		System.out.println();
		System.out.println(memberInfo.getTool());
		return "registerMember";
	}

	private void checkDuplicateId(String userId, BindingResult errors) {
		if (userId.equals("madvirus")) {
			errors.rejectValue("userId", "duplicate");
		}
	}

}
