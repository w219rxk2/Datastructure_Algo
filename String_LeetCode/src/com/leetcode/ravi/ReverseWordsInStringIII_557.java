package com.leetcode.ravi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ReverseWordsInStringIII_557 {
	
	 public String reverseWords(String s) {
	        
		 StringBuilder sb = new StringBuilder(s.length());
		 
		 String[] split = s.split(" ");
		 
		 String newString;
		 
		 for(int i =0; i < split.length ; i++) {
			 newString = split[i];
			 
			 newString = reverse(newString, 0, newString.length()-1);
			 
			 sb.append(newString);
			 sb.append(" ");
		 }
		 
		sb.deleteCharAt(sb.length()-1);
		return sb.toString().trim();
	 }

	private String reverse(String s, int i, int j) {
		char temp;
		char[] charArray = s.toCharArray();
		
		while(i < j) {
			temp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = temp;
			i++;
			j--;
		}
		
		s = String.copyValueOf(charArray);
		return s;
	}
	
	@Test
	public void testReverseWords() {
		String s = "Let's take LeetCode contest";
		
		String reverseWords = reverseWords(s);
		
		assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWords);
	}
}
