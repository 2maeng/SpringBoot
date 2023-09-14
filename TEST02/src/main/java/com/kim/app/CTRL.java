package com.kim.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 개발자 가독성 상 Controller @을 사용한다
@Controller
public class CTRL {
	
	@RequestMapping("/") // 루트 요청
	public @ResponseBody String root() {
		
		return "롬복 예제입니다! :D";
		// ViewResolver X
		// 문자열 "값"
	}
	
	@RequestMapping("/test") // 루트 요청
	public String test(VO vo, Model model) {
						// 커맨드 객체
		System.out.println("vo : " + vo);
		
		model.addAttribute("apple", vo.getId());
		
		return "test";
		// WEB-INF/views/test.jsp
	}
}
