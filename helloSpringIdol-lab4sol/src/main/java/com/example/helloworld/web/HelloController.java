package com.example.helloworld.web;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.helloworld.service.HelloService;
import com.example.springidol.SpringIdol;

@Controller
public class HelloController {
	
	@Autowired
	private HelloService helloSvc;

	@Autowired
	public HelloController(SpringIdol springIdol) {
		springIdol.run();
	}
	
	@RequestMapping("/hello.do")		// request handler method
	public ModelAndView hello(			
		@RequestParam(value="name", required=false) String name) {
		
		String greeting = getGreeting();
		if (name != null) greeting = greeting + name;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("greeting", greeting);
		return mav;
	}

	public String getGreeting() {		
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour >= 6 && hour <= 10) {
			return "Good morning! ";
		} else if (hour >= 12 && hour <= 15) {
			return "Did you have lunch? ";
		} else if (hour >= 18 && hour <= 24) {
			return "Good evening! ";
		}
		return "Hello! ";
	}
	
	@RequestMapping("/perform")			// request handler method
	public ModelAndView helloAndPerform1(			
		@RequestParam("id") String id,
		@RequestParam("requester") String requester) {
		
		String greeting = helloSvc.getGreeting() 
						+ requester + "!" + " I'm " + id + '.';

		String result = helloSvc.makePerformance(id); 
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("perform");
		mav.addObject("greeting", greeting);
		mav.addObject("performance", result);
		return mav;
	}
	
	@RequestMapping("/performUsingComm")		// request handler method
	public String helloAndPerformUsingComm(PerformRequest req, Model model) {	// command class 이용		

		String greeting = helloSvc.getGreeting() 
				+ req.getRequester() + "!" + " I'm " + req.getId() + '.';

		String result = null;		
		if (req.getId() != null) {
			result = helloSvc.makePerformance(req.getId()); 
		}
		
		model.addAttribute("greeting", greeting);
		model.addAttribute("performance", result);
		return "perform";
	}
}
