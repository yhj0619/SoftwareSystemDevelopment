package com.example.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ReportSubmissionController implements ApplicationContextAware {
	@Value("/upload/")
	private String uploadDirLocal;
	
	private WebApplicationContext context;	
	private String uploadDir;

	@Override					// life-cycle callback method
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath(this.uploadDirLocal);
		System.out.println(this.uploadDir);
	}
	
	@GetMapping("/report/submission.do")
	public String form() {
		return "report/submissionForm";
	}

	@PostMapping("/report/submitReport1.do")
	public String submitReport1(
			@RequestParam("studentNumber") String studentNumber,
			@RequestParam("report") MultipartFile report,
			Model model) {
		String filename = uploadFile(studentNumber, report);
		model.addAttribute("fileUrl", this.uploadDirLocal + filename);
		return "report/submissionComplete";
	}
	
	@PostMapping("/report/submitReport2.do")
	public String submitReport2(ReportCommand reportCommand,
			Model model) {
		String studentNumber = reportCommand.getStudentNumber();
		MultipartFile report = reportCommand.getReport();
		String filename = uploadFile(studentNumber, report);
		model.addAttribute("fileUrl", this.uploadDirLocal + filename);
		return "report/submissionComplete";
	}
	
	@PostMapping("/report/submitReport3.do")
	public String submitReport3(MultipartHttpServletRequest request, 
			Model model) {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		String filename = uploadFile(studentNumber, report);
		model.addAttribute("fileUrl", this.uploadDirLocal + filename);
		return "report/submissionComplete";
	}

	private String uploadFile(String studentNumber, MultipartFile report) {
			String filename = UUID.randomUUID().toString() 
							+ "_" + report.getOriginalFilename();
		System.out.println(studentNumber + "가 업로드 한 파일: "	+ filename);
		File file = new File(this.uploadDir + filename);
		try {
			report.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return filename;
	}
}
