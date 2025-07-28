package Workshop;

import java.util.*;

class StudentObj {
	int id;
	String name;
	int age;
	char grade;
	List<String> subjects;

	StudentObj(int id, String name, int age, char grade, List<String> sub) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.grade = grade;
		this.subjects = sub;
	}
	@Override
	public String toString() {
		return this.name + "-" + this.age + "-" + this.grade + "-" + this.subjects;
	}
}

public class StudentManagementSystem {
	Map<Integer, StudentObj> students;

	public StudentManagementSystem() {
		// TODO Auto-generated constructor stub
		students = new HashMap<>();
	}

	public void addStudent(int id, StudentObj s) {
//		if(!students.containsKey(id)) {
//			System.out.println("Id Already exist");
//			return;
//		}
		students.put(id, s);
	}

	public void removeStudent(int id) {
		if (students.containsKey(id)) {
			students.remove(id);
		} else {
			System.out.println("Id not present");
		}
	}

	public boolean searchStudentbyID(int id) {
		return students.containsKey(id);
	}

	public void findStudentbySubject(String subject) {
		List<String> ans = new ArrayList<>();
		for (int id : students.keySet()) {
			StudentObj s = students.get(id);
			if (s.subjects.contains(subject)) {
				ans.add(s.name);
			}
		}
		System.out.println("Students that enrolled in " + subject);
		System.out.println(ans);
	}

	public void display() {
		for (int id : students.keySet()) {
			System.out.println(id + " -> " + students.get(id));
		}
	}

	public static void main(String[] args) {
		StudentObj s1 = new StudentObj(1, "Sandeep", 20, 'A', Arrays.asList("Math", "English", "Science"));
		StudentObj s2 = new StudentObj(2, "Abishek", 21, 'B', Arrays.asList("Math", "English"));
		StudentObj s3 = new StudentObj(3, "Nikhil", 23, 'A', Arrays.asList("English", "Science"));
		
		PriorityQueue<StudentObj> pq = new PriorityQueue<>(new Comparator<>() {
			public int compare(StudentObj s1, StudentObj s2) {
				return s1.name.compareTo(s2.name);
			}
		});
	
		pq.add(s1);
		pq.add(s2);
		pq.add(s3);

		StudentManagementSystem obj = new StudentManagementSystem();
		obj.addStudent(1, s1);
		obj.addStudent(2, s2);
		obj.addStudent(3, s3);
		obj.display();
		System.out.println();
//		obj.removeStudent(1);
//		obj.display();
//
		System.out.println(obj.searchStudentbyID(1));
		System.out.println(obj.searchStudentbyID(2));

		obj.findStudentbySubject("Math");
//
		System.out.println("\nStudents sorted by name: ");
		while (!pq.isEmpty()) {
			StudentObj s = pq.poll();
			System.out.println(s.id + " -> " + s);
		}
		
//		obj.removeStudent(1);

	}

}
