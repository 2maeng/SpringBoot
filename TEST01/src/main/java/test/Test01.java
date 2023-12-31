package test;

class A{
	
	// private
	public A() {
		System.out.println("기본 생성자 호출됨");
	}
	
}

public class Test01 {
	
	public static void useA() {
		A apple = new A(); // 결합도가 높으면 외부 다른 코드 변화에 반응이 생김
		// 개발자가 집접 new
		// 결합이 강함
	}
	
	public static void useA(A a) { // 오버로딩 : 메서드 시그니처가 달라서 가능!
		A apple = a;
		// 외부에서 객체를 받아옴 == 객체를 주입 받는다.
		// 결합이 약함
	}
	
	public static void main(String[] args) {
		
		// 결론)
		// 코드의 결합도가 높을수록
		// 안정성이 떨어짐
		// 유연성이 떨어짐
		// 외부 코드 변화에 에러가 발생할 확률이 높아짐 == 유지보수가 불리
		
	}
	
}

