package com.kim.app;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class VOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// 유효성 검서할 객체의 클래스 정보를 반환
		return VO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) { // Errors errors도 커맨드 객체, 컨테이너가 관리하는 객체, 참조 변수
		// target : 유효성 검사할 객체
		// errors : 검증이 통과되지 못한 경우, 왜 통과가 안 되었는지를 반환
		VO vo = (VO)target; // 내가 검사할 객체 다운 캐스팅
		
		String id = vo.getId();
		
		if(id.length() <= 5) {
			errors.rejectValue("id", "id는 5자 이하일 수 없습니다!");
		}
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id값 없음");
//		if(id == null || id.isEmpty() || id.isBlank() || id.trim().isEmpty() || id.trim().isBlank()) {
//			System.out.println("로그 : id값이 올바르지 않습니다.");
//			
//			errors.rejectValue("id", "id값 없음");
//		}
		
//		String password = vo.getPassword();
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password값 없음");
//		if(password == null || password.isEmpty() || password.isBlank() || password.trim().isEmpty() || password.trim().isBlank()) {
//			System.out.println("로그 : password값이 올바르지 않습니다.");
//			
//			errors.rejectValue("password", "password값 없음");
//		}
	}

}
