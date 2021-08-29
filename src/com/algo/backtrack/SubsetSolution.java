package com.algo.backtrack;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;

public class SubsetSolution {

	public static void main(String[] args) {
		int[]arr = {4,4,4,1,4};
		System.out.println(new SubsetSolution().subsetsWithDup(arr));
		
		//new SubsetSolution().test();
	}
	
	public void subsets(int[] nums, int index, List<List<Integer>> list) {
		if (index == -1) {
			list.add(new ArrayList<>());
			return;
		}
		else {            
			subsets(nums,index-1, list);            
			int num = nums[index];
			List<List<Integer>> copyList = new ArrayList<>();
			for (List<Integer>subList : list) {
				List<Integer> copy = new ArrayList<>();
				copy.addAll(subList);
				copy.add(num);
				copyList.add(copy);
			}

			list.addAll(copyList);

		}
	}
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		subsets(nums, nums.length-1, list);
		list.stream().forEach(t -> Collections.sort(t));
		List<List<Integer>> result = list.stream().distinct().collect(Collectors.toList());
		return result;
	}
}
