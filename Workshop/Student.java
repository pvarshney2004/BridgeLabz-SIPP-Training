package Workshop;
import java.util.*;
public class Student {
	String name;
	int[] marks;
	final String[] subjects = {"Maths", "English", "Science"};
	
	Student(String name){
		this.name = name;
		marks = new int[subjects.length];
	}
	
	public void setSubjectMarks(int subjectIndex, int m) throws Exception{
		if(subjectIndex<0 || subjectIndex>=subjects.length) {
			throw new Exception("Invalid subject index");
		}
		if(m<0 || m>100) {
			throw new Exception("Invalid marks");
		}
		marks[subjectIndex] = m;
	}
	
	public double calculateAverage() {
		int sum = 0;
		for(int m : marks) {
			sum+=m;
		}
		return (double)sum / marks.length;
	}
	
	public char assignGrade(double avg) {
		if(avg>=90) return 'A';
		else if(avg>=80) return 'B';
		else if(avg>=70) return 'C';
		else if(avg>=60) return 'D';
		else return 'F';
	}
	
	public void displayResult() {
		System.out.println("Student name: " + this.name);
		System.out.println("\nMarks in each subject: ");
		System.out.println("----------------------");
		for(int i=0; i<marks.length; i++) {
			System.out.println(subjects[i]+"\t\t" + marks[i]);
		}
		double average = calculateAverage();
		char grade = assignGrade(average);
		System.out.printf("\nAverage of marks: %.2f", average);
		System.out.println("\nGrade: "+ grade);
		System.out.println("---------------------------------\n");
		
	}
	
	public static void main(String[] args) throws Exception {
		List<Student> ll = new ArrayList<>();
		
		Student s1 = new Student("PV");
		s1.setSubjectMarks(0, 67);
		s1.setSubjectMarks(1, 76);
		s1.setSubjectMarks(2, 89);
		ll.add(s1);
		
		Student s2 = new Student("Sandeep");
		s2.setSubjectMarks(0, 99);
		s2.setSubjectMarks(1, 90);
		s2.setSubjectMarks(2, 98);
		ll.add(s2);
		
		for(Student s : ll) {
			s.displayResult();
		}
	}
}
