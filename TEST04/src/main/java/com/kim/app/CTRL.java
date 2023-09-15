package com.kim.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
public class CTRL {

	@RequestMapping("/")
	public String root() {
		return "test";
	}

//	@RequestMapping("/test")
//	public String test(VO vo, BindingResult br, Model model) {
//		/////
//		VOValidator voV = new VOValidator();  
//		
//		voV.validate(vo, br); // bindingResult는 커맨드 객체로써(참조 변수) 여러개 값을 반환해야 함
//		
//		if(br.hasErrors()) {
//			System.out.println("발생한 에러목록");
//			System.out.println(br.getAllErrors()); // 리스트라 for문 이랑도 잘 어울림
//			
//			if(br.getFieldError("id") != null) { // id에서 Error가 발생했다는 의미
//				System.out.println(br.getFieldError("id").getCode());
//			}
//			if(br.getFieldError("password") != null) { // id에서 Error가 발생했다는 의미
//				System.out.println(br.getFieldError("password").getCode());
//			}
//		}
//		/////
//		model.addAttribute("apple", vo.getId());
//		
//		return "test";
//	}
	
	@RequestMapping("/test")
	public String test(@Valid VO vo, BindingResult br, Model model) {
		/////
		if(br.hasErrors()) {
			System.out.println("발생한 에러목록");
			System.out.println(br.getAllErrors()); // 리스트라 for문 이랑도 잘 어울림
			
			if(br.getFieldError("id") != null) { // id에서 Error가 발생했다는 의미
//				System.out.println(br.getFieldError("id").getCode());
				System.out.println(br.getFieldError("id").getDefaultMessage());
			}
			if(br.getFieldError("password") != null) { // id에서 Error가 발생했다는 의미
//				System.out.println(br.getFieldError("password").getCode());
				System.out.println(br.getFieldError("password").getDefaultMessage());
			}
		}
		/////
		model.addAttribute("apple", vo.getId());

		return "test";
	}
	
//	@InitBinder
//	protected void initBinder(WebDataBinder wdb) {
//		wdb.setValidator(new VOValidator());
//	}

}
