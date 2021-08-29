package com.algo.knapsack;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value 
 * in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and 
 * weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find out
 *  the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You 
 *  cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 * @author anupam
 *
 */
public class ZeroOneKnapSack {

	public static void main(String[] args) {
		int []val = {60, 100, 120};
		int []wt = {10, 20, 30};
		int w = 50;
		System.out.println(new ZeroOneKnapSack().profit(val, wt, w, 3));
	}
	
	/**
	 * Returns max profit that can be obtained
	 * @param val values of n items
	 * @param wt weights of n items 
	 * @param w total max weight that knapsack bag can contain
	 * @param n number of items in the array
	 * @return
	 */
	public int profit(int[]val, int[] wt, int w, int n) {
		// Base case, if no items or no weight capacity then profit will be zero.
		if (n==0 || w==0) {
			return 0;
		}
		
		// Choice Dragon
		if (wt[n-1] > w) {
			return profit(val, wt, w, n-1);
		}
		else {
			 int profitIfIncluded = val[n-1] + profit(val, wt, w-wt[n-1], n-1);
			 int profitIfNotIncluded = profit(val, wt, w, n-1);
			 return Math.max(profitIfIncluded, profitIfNotIncluded);
		}
	}
}
