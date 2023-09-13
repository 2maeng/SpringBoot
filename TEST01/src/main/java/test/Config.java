package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정 클래스
// Configuration : 프로그램의 설정을 저장해두고 환경을 구성하는 데에 사용하는 파일
@Configuration
public class Config {
	
	@Bean // 스프링이 IoC 컨테이너로 관리하는 객체
	public PhoneA phoneA() {
		return new PhoneA();
	}
	
	@Bean
	public PhoneB phoneB() {
		return new PhoneB();
	}
	
	@Bean // 이름 설정을 별도로 하지 않으면 teemo1 << 메서드명이 등록됨
	public Teemo teemo1() {
		// 생성자 주입
		return new Teemo("작은 티모", new PhoneA());
	}
	
	@Bean(name = "apple")
	public Teemo teemo2() {
		// setter 주입
		Teemo teemo = new Teemo();
		teemo.setName("큰 티모");
		teemo.setPhone(new PhoneA());
		
		return teemo;
	}
}
