package test;

public class PhoneA implements Phone {

	@Override
	public void call(String name) { // 메서드를 강제하는데 이걸 오버라이딩
		System.out.println("PhoneA : " + name + "이(가) 전화 거는중...");
	}

}
