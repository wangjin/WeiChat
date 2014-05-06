package tk.wangjinzone.weichat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	
	@RequestMapping(value = "/jquerymobile",method = RequestMethod.GET)
	public String testjquerymobile(){
		return "jquerymobile";
	}
}
