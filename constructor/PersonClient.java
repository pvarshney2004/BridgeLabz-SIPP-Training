package constructor;

public class PersonClient {
	public static void main(String[] args) {
		Person p = new Person("pv",21);
		System.out.println(p.name);
		System.out.println(p.age);
		
		Person p1 = new Person(p);
		System.out.println(p1.name);
		System.out.println(p1.age);
		
	}
}
