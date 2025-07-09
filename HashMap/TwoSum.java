package HashMap;
import java.util.*;

public class TwoSum {
	public static void main(String[] args) {
		int[] arr = {2,7,11,15};
		int target = 9;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i], i);
		}
		for(int key : map.keySet()) {
			if(map.containsKey(target-key)) {
				System.out.println(map.get(key)+" "+map.get(target-key));
				break;
			}
		}
		
	}
}
