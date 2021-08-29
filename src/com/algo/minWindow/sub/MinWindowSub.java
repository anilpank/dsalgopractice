package com.algo.minWindow.sub;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindowSub {

	public static void main(String[] args) {
		//"cabwefgewcwaefgcf"
		//"cae"
		System.out.println(new MinWindowSub().minWindow("cabwefgewcwaefgcf", "cae"));
	}

	public String minWindow(String s, String t) {
		char []sArr = new char[256];
		char []matchArr = new char[256];
		if (s.length()<t.length()) {
			return "";
		}
		
		for (int i=0; i<t.length(); i++) {
			char c = t.charAt(i);
			matchArr[c]++;
		}
		
		int count = 0;
		int start = 0;
		int startIndex = -1;
		int minLength = Integer.MAX_VALUE;
		int end = 0;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			sArr[c]++;
			
			if (sArr[c] <= matchArr[c]) {
				count++;
			}
			
			if (count == t.length()) {
				while (sArr[s.charAt(start)]> matchArr[s.charAt(start)]
						|| matchArr[s.charAt(start)] == 0) {
					
					if (sArr[s.charAt(start)] > matchArr[s.charAt(start)]) {
						sArr[s.charAt(start)]--;
					}
					start++;
				}
				
				//update window size				
				int len = i-start+1;
				if (minLength>len) {
					minLength = len;
					startIndex = start;
				}
			}			
		}
		
		if (startIndex == -1) {
			return "";
		}
		
		return s.substring(startIndex, startIndex+minLength);

	}

	
}
