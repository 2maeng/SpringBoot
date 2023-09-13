package test;

public class Teemo {
	private String name;
	private Phone phone;
	
	public Teemo() {
		System.out.println("Teemo 기본 생성자 호출됨");
	}
	
	// 생성자 오버로딩
	public Teemo(String name, Phone phone) {
		this.name = name; // this == 자기자신 객체
		this.phone = phone;
		
		System.out.println("Teemo 생성자 호출됨");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Phone getPhone() {
		return phone;
	}
	
	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Teemo [name = " + name + ", phone = " + phone + "]";
	}
	
	public void print() {
		phone.call(name); // this 키워드는 생략가능!
	}
	
}
