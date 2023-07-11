package obj;

import java.io.Serializable;
//직렬화를 위해 Serializable 사용
public class Person implements Serializable{
	private String name;
	//transient 직렬화 대상에서 제외
	private transient int age;
	
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
