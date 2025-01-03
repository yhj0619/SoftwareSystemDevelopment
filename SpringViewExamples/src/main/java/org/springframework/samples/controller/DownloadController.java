package org.springframework.samples.controller;

import java.io.File;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
public class DownloadController implements ApplicationContextAware {

	private WebApplicationContext context = null;

	@RequestMapping("/download/{fileName}")
	public String download(@PathVariable String fileName, Model model) throws Exception {
		String baseDir = context.getServletContext().getRealPath(
			"/WEB-INF/download");		
		File downloadFile = new File(baseDir, fileName);
		model.addAttribute("downloadFile", downloadFile); 
		return "download";	// view name (custom view)
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}

}
