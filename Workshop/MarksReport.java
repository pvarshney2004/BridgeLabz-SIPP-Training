package Workshop;
import java.util.*;

public class MarksReport {
	static Map<String,List<Integer>> list = new HashMap<>();
	
	
	public void addMarks(String name, int marks) {
		if(!list.containsKey(name)) {
			list.put(name, new ArrayList<>());
		}
		list.get(name).add(marks);
	}
	
	public static double calculateAverageMarks(String name) {
		if(!list.containsKey(name)) {
			System.out.println("Student not exist");
			return 0.0;
		}
		List<Integer> ll = list.get(name);
		double sum = 0;
		for(int i : ll) sum+=i;
		return sum/ll.size();
	}
	
	
	public static void generateReport() {
		System.out.println("Student Marks with thier names:");
		for(String name : list.keySet()) {
			System.out.println(name + "->" + list.get(name));
		}
		System.out.println("\nAverage Marks of each student:");
		for(String name : list.keySet()) {
			System.out.println(name + " has average of "+ MarksReport.calculateAverageMarks(name));
		}
		System.out.println("\nTopper of the class:");
		System.out.println(MarksReport.getTopper());
	}
	public static String getTopper() {
		String ans = "";
		double max = 0;
		for(String name : list.keySet()) {
			double avg = MarksReport.calculateAverageMarks(name);
			if(avg>max) {
				max = avg;
				ans = name;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		MarksReport obj = new MarksReport();
		obj.addMarks("Prashant",50);
		obj.addMarks("Prashant",60);
		obj.addMarks("Sandeep", 97);
		obj.addMarks("Sandeep", 94);
		MarksReport.generateReport();
	}
}
