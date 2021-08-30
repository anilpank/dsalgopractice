package com.algo.arrayPatch;
import java.util.*;

public class PatchingArray {
	public static void main(String[] args) throws InterruptedException {
		int[] nums = {1,5, 10};
		int n = 20;
		System.out.println(new PatchingArray().minPatches(nums, n));
	}

	public int processCount(List<Integer> nums, int n) throws InterruptedException {
		// find all sums of num combinations
		// add smallest missing number between 1..n
		// repeat
		int counter = 0;
		while (true) {					
			List<Integer> sumList = findAllSubsetSums(nums, nums.size());
			Collections.sort(sumList);
			System.out.println("sumList->" + sumList);
			int missingNum = 0;
			for (int i=0; i<sumList.size()-1; i++) {
				if (sumList.get(i)>n) {
					break;
				}
				if (sumList.get(i+1) - sumList.get(i)>1) {
					missingNum = sumList.get(i)+1;
					break;
				}
			}
			if (missingNum == 0) {
				if (sumList.get(sumList.size()-1)<n) {
					missingNum = sumList.get(sumList.size()-1)+1;
				}
				else {
					break;
				}
			}			
			counter++;
			nums.add(missingNum);
			System.out.println("nums->" + nums);
		}
		return counter;
	}

	public int minPatches(int[] nums, int n) throws InterruptedException {
		List<Integer> numList = new ArrayList<>();
		for (int num : nums) {
			numList.add(num);
		}
		return processCount(numList, n);
	}

	public List<List<Integer>> findAllSubsets(List<Integer> nums, int n) {
		if (n==0) {
			List<List<Integer>> list = new ArrayList<>();
			list.add(new ArrayList<>());
			return list;
		}

		else {
			List<List<Integer>> list = findAllSubsets(nums, n-1);			
			List<List<Integer>> resultList = new ArrayList<>();
			for (List<Integer> sublist : list) {
				List<Integer> resultSubList = new ArrayList<>();
				for (Integer data: sublist) {
					resultSubList.add(data);
				}
				resultList.add(resultSubList);
			}
			int num = nums.get(n-1);
			List<List<Integer>>listWithAddedNum = new ArrayList<>();
			for (List<Integer> resultSubList : resultList) {
				List<Integer> mySubList = new ArrayList<>();
				for (Integer data: resultSubList) {
					mySubList.add(data);
				}
				mySubList.add(num);
				listWithAddedNum.add(mySubList);
			}
			resultList.addAll(listWithAddedNum);
			return resultList;
		}
	}
	
	public List<Integer> findAllSubsetSums(List<Integer> nums, int n) {
		if (n==0) {
			List<Integer> list = new ArrayList<>();
			list.add(0);
			return list;
		}
		
		else {
			List<Integer> list = findAllSubsetSums(nums, n-1);			
			List<Integer> resultList = new ArrayList<>();
			for (Integer item : list) {				
				resultList.add(item);
			}
			int num = nums.get(n-1);
			List<Integer>listWithAddedNum = new ArrayList<>();
			for (Integer resultItem : resultList) {			
				listWithAddedNum.add(resultItem+num);
			}
			resultList.addAll(listWithAddedNum);
			return resultList;
		}
	}
}
