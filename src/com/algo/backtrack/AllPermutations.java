package com.algo.backtrack;

public class AllPermutations {

	public static void main(String[] args) {
		String str = "ABC";
		int n = str.length();
		new AllPermutations().permute(str,0, n-1);
	}

	private void permute(String str, int l, int r) {
		System.out.println("str-" + str + " l-" + l + " r-" + r);
		if (l == r) {
			System.out.println(str);
		}
		else {
			for (int i=l; i<=r; i++) {
				str = swap(str, l, i);
				permute(str, l+1, r);
				str = swap(str,l,i);
			}
		}		
	}
	

	private String swap(String str, int l, int i) {
		char[] arr = str.toCharArray();
		char temp = arr[l];
		arr[l] = arr[i];
		arr[i] = temp;
		return String.valueOf(arr);
	}
}
