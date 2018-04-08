package com.leetcode.ravi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class DetectCapitalUse_520 {
	
	public boolean detectCapitalUse(String word) {
        
		return word.equals(word.toUpperCase()) || 
	               word.equals(word.toLowerCase()) ||
	               Character.isUpperCase(word.charAt(0)) && 
	               word.substring(1).equals(word.substring(1).toLowerCase());
		
    }
	
	@Test
	public void testDetectCapitalUse() {
		String word = "USA";
		boolean detectCapitalUse = detectCapitalUse(word);
		
		assertEquals(true, detectCapitalUse);
		
		word = "FlaG";
		
		detectCapitalUse = detectCapitalUse(word);
		
		assertEquals(false, detectCapitalUse);
	}
}
