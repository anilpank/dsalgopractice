package com.algo.backtrack;

public class AllPossible {

	public static void main(String[] args) {
		char[] arr = "anil".toCharArray();
      new AllPossible().allPossible( arr, 4);
	}
	
	public void allPossible(char[] set, int k) {
		int n = set.length;
		allPossibleRec(set, "", n, k) ;
	}
	
	public void allPossibleRec(char[] set, String prefix, int n, int k) {
		// Base case k=0, print prefix
		if (k==0) {
			System.out.println(prefix);
			return;
		}
		
		// One by one add all characters
		for (int i=0; i<n; i++) {
			String newPrefix = prefix + set[i];			
			//k is decreased, because we have added a new character
			allPossibleRec(set, newPrefix, n, k-1);
		}
	}
	
}
