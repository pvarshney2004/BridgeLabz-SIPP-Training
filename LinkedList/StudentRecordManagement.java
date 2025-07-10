package LinkedList;

import java.util.*;

class Student {
	int roll;
	String name;
	int age;
	char grade;
	Student next;

	public Student(int rollNo, String name, int age, char grade) {
		this.roll = rollNo;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.next = null;
	}
}

class StudentLinkedList {
	private Student head;

	public void addAtBeginning(int roll, String name, int age, char grade) {
		Student s = new Student(roll, name, age, grade);
		s.next = head;
		head = s;
	}

	public void addAtLast(int roll, String name, int age, char grade) {
		Student s = new Student(roll, name, age, grade);
		if (head == null) {
			head = s;
			return;
		}
		Student temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = s;
	}

	public void addAtPosition(int idx, int roll, String name, int age, char grade) {
		if (idx < 0) {
			System.out.println("Not valid index");
			return;
		}
		if (idx == 0) {
			addAtBeginning(roll, name, age, grade);
			return;
		}
		Student s = new Student(roll, name, age, grade);
		Student temp = head;
		for (int i = 0; i < idx - 1 && temp != null; i++) {
			temp = temp.next;
		}
		if (temp == null) {
			System.out.println("Index out of bound");
		} else {
			s.next = temp.next;
			temp.next = s;
		}
	}

	// Delete by Roll Number
	public void deleteByRollNumber(int roll) {
		if (head == null)
			return;

		if (head.roll == roll) {
			head = head.next;
			return;
		}

		Student temp = head;
		while (temp.next != null && temp.next.roll != roll) {
			temp = temp.next;
		}

		if (temp.next == null) {
			System.out.println("Roll number " + roll + " not found.");
		} else {
			temp.next = temp.next.next;
		}
	}

	// Search by Roll Number
	public void searchByRollNumber(int roll) {
		Student temp = head;
		while (temp != null) {
			if (temp.roll == roll) {
				displayStudent(temp);
				return;
			}
			temp = temp.next;
		}
		System.out.println("Student with Roll Number " + roll + " not found.");
	}

	// Display all records
	public void displayAll() {
		if (head == null) {
			System.out.println("No student records.");
			return;
		}
		Student temp = head;
		while (temp != null) {
			displayStudent(temp);
			temp = temp.next;
		}
	}

	// Display one student
	private void displayStudent(Student s) {
		System.out.println("Roll: " + s.roll + ", Name: " + s.name + ", Age: " + s.age + ", Grade: " + s.grade);
	}
}

public class StudentRecordManagement {
	public static void main(String[] args) {
		StudentLinkedList list = new StudentLinkedList();

        list.addAtLast(101, "Alice", 20, 'A');
        list.addAtBeginning(102, "Bob", 21, 'B');
        list.addAtPosition(103,  22, "Charlie", 1, 'C');

        System.out.println("All Student Records:");
        list.displayAll();
        
        System.out.println("\nSearching Roll Number 103:");
        list.searchByRollNumber(103);

	}
}
