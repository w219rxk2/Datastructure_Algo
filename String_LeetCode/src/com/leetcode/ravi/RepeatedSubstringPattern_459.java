package com.leetcode.ravi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

// TODO: check the correct solution.

public class RepeatedSubstringPattern_459 {
	
	public boolean repeatedSubstringPattern(String s) {
        
		if(s.length()%2 != 0){
			return false;
		}
		
		char firstChar = s.charAt(0);
		int nextIndexLength = -1;
		int nextIdex;
		
		for(int i = 1; i < s.length(); i++) {
			if(firstChar == s.charAt(i) ) {
				nextIndexLength = i;
				break;
			}
		}
		
		if(nextIndexLength == -1) {
			return false;
		}
		
		nextIdex = nextIndexLength;
		
		if(nextIdex == (s.length()/2)) {
			
			int middleIndex = s.length()/2;
			
			for(int i =0; i < middleIndex; i++) {
				if(s.charAt(i) != s.charAt(i+middleIndex)) {
					return false;
				}
			}
		}else {
			nextIdex = nextIdex + 1;
			for(int i = 1; i < nextIndexLength; i++) {
				
				for(int j = i; j < nextIndexLength; j++) {
					
					if(s.charAt(j) != s.charAt(nextIdex)) {
						return false;
					}
					nextIdex++;
				}
				
				if(nextIdex < s.length()) {
					i = -1;
				}else {
					break;
				}
			}
		}
		
		return true;
    }
	
	@Test
	public void testRepeatedSubstringPattern() {
		String s = "abab";
		
		boolean canBeRepeated = repeatedSubstringPattern(s);
		
		assertEquals(true, canBeRepeated);
		
		s = "aba";
		
		canBeRepeated = repeatedSubstringPattern(s);
		
		assertEquals(false, canBeRepeated);
		
		s = "abcabcabcabc";
		
		canBeRepeated = repeatedSubstringPattern(s);
		
		assertEquals(true, canBeRepeated);
	}
}
