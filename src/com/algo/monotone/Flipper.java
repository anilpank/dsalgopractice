package com.algo.monotone;

public class Flipper {

	public static void main(String[] args) {
		System.out.println(new Flipper().minFlipsMonoIncr("0101100011"));
	}

	public int minFlipsMonoIncr(String s) {
		boolean firstOne = false;
		int oneCount = 0;
		int zeroCount = 0;
		for (int i=0; i<s.length(); i++) {
			if (firstOne) {
				if (s.charAt(i)=='1') {
					oneCount++; 
				}
				else {
					zeroCount++;
				}
			} 
			if (s.charAt(i) == '1' && !firstOne) {
				firstOne = true;
				oneCount++;
			}
		}
		return Math.min(oneCount, zeroCount);
	}

}
