package com.example.scheduler.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.scheduler.service.SchedulerService;

@Controller
public class TestSchedulerController { 

	private SchedulerService service;

	@Autowired
	public void setService(SchedulerService service) {
		this.service = service;
	}

	@RequestMapping("/testScheduler")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("closeTime")
			@DateTimeFormat(pattern="yyyy-MM-dd HH:mm") Date closeTime) throws Exception {
		System.out.println(closeTime);
		service.testScheduler(closeTime);
		return new ModelAndView("Scheduled", "closeTime", closeTime);	
	}
}
