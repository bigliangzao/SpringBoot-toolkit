package com.winxuan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winxuan.vo.ExampleBeanWithSpel;

@Controller
public class TestController {
	@Autowired
	private ExampleBeanWithSpel exampleBeanWithSpel;
	
	@RequestMapping("/get")
	@ResponseBody
	public String get() {
		return exampleBeanWithSpel.getStringProperty();
	}
}
