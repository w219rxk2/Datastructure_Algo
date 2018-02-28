package com.leetcode.ravi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class LongestSubstring {
	
	public int findLongestSubstring(String name) {
		
		if(name == null  || name.length() == 0) {
			return 0;
		}
		
		if(name.length() == 1) {
			return 1;
		}
		
		Set<Character> duplicate = new HashSet<Character>();
		Character charAt;
		int length = name.length();
		int j = 0;
		int max = 0;
		for(int i = 0; i < length; i++) {
			charAt = name.charAt(i);
			
			if(duplicate.contains(charAt)) {
				if(duplicate.size() > max) {
					max = duplicate.size();
				}
				duplicate = new HashSet<Character>();
				i = j++;
			}else {
				duplicate.add(charAt);
			}
			max = duplicate.size();
		}
		
		return max;
	}
	
	@Test
	public void testFindLongestSubstring() {
		String name = "abcabc";
		
		int longestSubstringLength = findLongestSubstring(name);
		
		assertEquals(3, longestSubstringLength);
		
		name = "abcabcdefhnl";
		
		longestSubstringLength = findLongestSubstring(name);
		
		assertEquals(9, longestSubstringLength);
		
		name = "abcdefghijklmnopqrst";
		
		longestSubstringLength = findLongestSubstring(name);
		
		assertEquals(20, longestSubstringLength);
		
		name = "abcdefghijklmnopqrsta";
		
		longestSubstringLength = findLongestSubstring(name);
		
		assertEquals(20, longestSubstringLength);
	}
}
