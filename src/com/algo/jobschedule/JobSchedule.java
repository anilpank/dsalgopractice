package com.algo.jobschedule;


class Job implements Comparable<Job> {
	int start;
	int end;
	int profit;
	public Job(int start, int end, int profit) {
		this.start = start;
		this.end = end;
		this.profit = profit;
	}
	@Override
	public int compareTo(Job o) {
		return end - o.end;
	}
}
public class JobSchedule {
	public static void main(String[] args) {
		int []startTime = {1,2,3,3};
		int []endTime = {3,4,5,6};
		int []profit = {50,10,40,70};
		System.out.println(new JobSchedule().jobScheduling(startTime, endTime, profit));
	}
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		Job[] jobArr = new Job[startTime.length];
		for (int i=0; i<startTime.length; i++) {
			Job job = new Job(startTime[i], endTime[i], profit[i]);
			jobArr[i] = job;
		}
		return maxProfit(jobArr, jobArr.length-1);
	}

	public int maxProfit(Job[] jobArr, int n) {
		if (n==0) {
			return jobArr[0].profit;
		}

		//find profit when current job is included
		int inclProfit = jobArr[n].profit;
		int i = latestNonConflict(jobArr, n);
		if (i != -1) {
			inclProfit = inclProfit + maxProfit(jobArr, i+1);
		}
		
		//find profit when current job is excluded
		int exclProfit = maxProfit(jobArr, n-1);
		return Math.max(inclProfit, exclProfit);
	}

	private int latestNonConflict(Job[] jobArr, int n) {
		for (int i=n-1; i>=0; i--) {
			if (jobArr[i].end<=jobArr[n].start) {
				return i;
			}
		}
		return -1;
	}

}
