package HashMap;
import java.util.*;
public class Longest_Consecutive_Sequence {
	public static void main(String[] args) {
		int[] arr = {100,4,200,1,3,2};
		Map<Integer,Boolean> map = new HashMap<>();
		for(int ele : arr) {
			if(map.containsKey(ele-1)) {
				map.put(ele, false);
			}
			else {
				map.put(ele, true);
			}
			if(map.containsKey(ele+1)) {
				map.put(ele+1, false);
			}
		}
		int ans = 0;
		for(int key : map.keySet()) {
			if(map.get(key)) {
				int count=0;
				while(map.get(key)) {
					key++;
					count++;
				}
				ans = Math.max(ans, count);
			}
		}
		System.out.println(ans);
		
	}
}
