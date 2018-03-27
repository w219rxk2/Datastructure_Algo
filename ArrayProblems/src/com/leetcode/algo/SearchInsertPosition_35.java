package com.leetcode.algo;

import org.junit.Test;

public class SearchInsertPosition_35 {
	
	public int insert(int[] nums, int target) {
		int index = -1;
		for(int i =0; i<nums.length; i++) {
			if(target == nums[i]) {
				index = i;
				break;
			}else if(target < nums[i]) {
				if( i-1 >= 0 &&  target > nums[i-1]) {
					index = i;
					break;
				}
			}
		}
		return index;
	}
	
	public int searchInsert(int[] nums, int target) {
		
		return insertRecursive(target, nums, 0, nums.length-1);
		
	}
	
	private int insertRecursive(int target, int[] ar, int start, int end) {
		int mid = (start+end)/2;
		
		if(start <= end) {
			if(ar[mid] > target) {
				return insertRecursive(target, ar, start, mid-1);
			} else if(ar[mid] < target) {
				return insertRecursive(target, ar, mid+1, end);
			}else {
				return mid;
			}
		}
		return start;
	}

	@Test
	public void testInsert() {
		int[] ar = {1,2,3,4,6,9,10};
		int index = searchInsert(ar, 11);
		System.out.println(index);
	}
}
