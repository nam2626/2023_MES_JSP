package obj;

import java.io.Serializable;
//직렬화를 위해 Serializable 사용
public class Person implements Serializable{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
