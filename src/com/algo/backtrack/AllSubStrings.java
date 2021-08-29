package com.algo.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllSubStrings {

	public static void main(String[] args) {
		System.out.println(new AllSubStrings().longestPalindrome("babad"));	
	}
	
	public String longestPalindrome(String s) {
        List<String> substrings = allSubstrings(s);
        Collections.sort(substrings, (a,b) -> b.length()-a.length());
        for (String sub : substrings) {
            if (isPalindrome(sub)) {
                return sub;
            }
        }
        return null;
    }
    
    private boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        int len = s.length();
        for (int i=0; i<s.length(); i++) {
            builder.append(s.charAt(len-i-1));
        }
        String rev = builder.toString();
        return s.equals(rev);
    }
    
    private void findAllSubStringsBeginAt(String s, int beg,  List<String> substrings) {
		for (int i=beg; i<s.length(); i++) {
			StringBuilder builder = new StringBuilder();
			for (int j=beg; j<=i; j++) {
				builder.append(s.charAt(j));
			}
			substrings.add(builder.toString());
		}		
	}
    
    private List<String>  allSubstrings(String s) {
        List<String> substrings = new ArrayList<>();
        for (int x=0; x<s.length(); x++) {
			findAllSubStringsBeginAt(s, x, substrings);
		}
        return substrings;
    }
	
	private void findAllSubStringsBeginAt1(String s, int beg) {
		for (int i=beg; i<s.length(); i++) {
			StringBuilder builder = new StringBuilder();
			for (int j=beg; j<=i; j++) {
				builder.append(s.charAt(j));
			}
			System.out.println(builder.toString());
		}		
	}
}
