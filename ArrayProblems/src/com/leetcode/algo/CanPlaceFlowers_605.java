package com.leetcode.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CanPlaceFlowers_605 {
	
	 public boolean canPlaceFlowers(int[] flowerbed, int n) {
	        
		 int size = 0;
		 int i = 0;
		 
		 while(i < flowerbed.length) {
			 if(flowerbed[i] == 0 
					 && (i == 0 || flowerbed[i-1] == 0) 
					 && (i == flowerbed.length-1 || flowerbed[i+1] == 0) ) {
				 flowerbed[i] = 1;
				 size++;
			 }
			 i++;
		 }
		 
		 return (size >= n);
	 }
	 
	 @Test
	 public void testCanPlaceFlowers() {
		int[] flowerBed = {1,0,0,0,1};
		boolean canPlaceFlowers = canPlaceFlowers(flowerBed, 1);
		
		assertEquals(true, canPlaceFlowers);
		
		canPlaceFlowers = canPlaceFlowers(flowerBed, 2);
		
		assertEquals(false, canPlaceFlowers);
	 }
}
