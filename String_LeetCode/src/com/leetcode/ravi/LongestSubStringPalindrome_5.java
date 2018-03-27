package com.leetcode.ravi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class LongestSubStringPalindrome_5 {
	
	public String longestPalindrome(String s) {
		
		int n = s.length();
		int palindromeStartsAt = 0;
		int maxLength = 1;
		boolean palindrome[][] = new boolean[n][n];
		int i;
		
		// for single alphabet case
		for(i =0; i<n;i++) {
			palindrome[i][i] = true;
		}
		
		// for double alphabet case
		for(i = 0;i<n-1;i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				palindromeStartsAt = i;
				maxLength = 2;
				palindrome[i][i+1] = true;
			}
		}
		
		// for alphabets length > 2
		for(int cur_lenth=3;cur_lenth<=n;cur_lenth++) {
			for(i=0;i<n-cur_lenth+1;i++) {
				int j = i+cur_lenth-1;
				if(s.charAt(i) == s.charAt(j)
						&& palindrome[i+1][j-1]) {
					palindromeStartsAt = i;
					maxLength = cur_lenth;
					palindrome[i][j] = true;
				}
			}
		}
		return s.substring(palindromeStartsAt, palindromeStartsAt+maxLength);
	}
	
	@Test
	public void testLongestPalindrome() {
		String s = "fuccu";
		String longestPalindrome = longestPalindrome(s);
		assertEquals("uccu", longestPalindrome);
		s= "babad";
		longestPalindrome = longestPalindrome(s);
		assertEquals("aba",longestPalindrome);
		s= "nipsonz anomematas met monaanom em atamemona nospin";
		longestPalindrome = longestPalindrome(s);
		assertEquals(" monaanom ",longestPalindrome);
		
		s = "eabcb";
		longestPalindrome = longestPalindrome(s);
		assertEquals("bcb",longestPalindrome);
		
		s = "aaabaaaa";
		longestPalindrome = longestPalindrome(s);
		assertEquals("aaabaaa",longestPalindrome);
		
		s = "ccc";
		longestPalindrome = longestPalindrome(s);
		assertEquals("ccc",longestPalindrome);
	}
}
