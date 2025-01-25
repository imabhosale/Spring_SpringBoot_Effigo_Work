package com.abhi.MyfirstWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SyaHelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello what are you learning today?";
	}

	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		//as writing this pages by appending is very very  bad
		//we use jsp
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<body>");
		sb.append("<h1>\"Hello what are you learning today?\"</h1>");
		sb.append("<body>");
		sb.append("<html>");	
		return sb.toString();
	}
	//    src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp 
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}

}
