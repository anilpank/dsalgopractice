package com.algo.knapsack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DoublePairArrays {

	public static void main(String[] args) {
		//int[] arr = {7,-15,-15,23,-3,80,-35,40,68,22,44,98,20,0,-34,8,40,41,16,46,16,49,-6,-11,35,-15,-74,72,-8,60,40,-2,0,-6,34,14,-16,-92,54,14,-68,82,-30,50,22,25,16,70,-1,-96,11,45,54,40,92,-35,29,80,46,-30,27,7,-70,-37,41,-46,-98,1,-33,-24,-86,-70,80,-43,98,-49,30,0,27,2,82,36,0,-48,3,-100,58,32,90,-22,-50,-12,36,6,-3,-66,72,8,49,-30};
		int[] arr = {-5,-2};
		System.out.println(new DoublePairArrays().canReorderDoubled(arr));
	}
	public boolean canReorderDoubled(int[] arr) {                
		 Arrays.sort(arr);
	        Map<Integer, Integer>numCount = new HashMap<>();
	        for (int num : arr) {
	            numCount.put(num, numCount.getOrDefault(num,0) +1);
	        }
	        
	        for (int num : arr) {
	            if (numCount.get(num) == 0) continue;
	            if (num<0 && num%2==1) return false;
	            int y = num<0 ? num/2 : num*2;
	            if (numCount.getOrDefault(y,0) == 0) return false;
	            numCount.put(num, numCount.get(num)-1);
	            numCount.put(y, numCount.get(y)-1);
	        }
	        return true;

	}
}
