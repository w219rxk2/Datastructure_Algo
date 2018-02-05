package com.algo.stackexamples;

import java.util.*;

import com.algo.ravi.StackAlgo;

public class MatchingParanthesis {
	private static final Map<Character, Character> paranthesisMap = new HashMap<Character, Character>();
	private static final Set<Character> openingParanthesisSet = new HashSet<Character>();

	static {
		paranthesisMap.put('}','{');
		paranthesisMap.put(']','[');
		paranthesisMap.put(')','(');
		openingParanthesisSet.addAll(paranthesisMap.values());
	}
	
	public boolean matchBrackets(String input) {
		StackAlgo<Character> parenStack = new StackAlgo<Character>();
		try {
			int valueLength = input.length();
			for(int i=0 ; i<valueLength;i++) {
				char ch = input.charAt(i);
				if(openingParanthesisSet.contains(ch)) {
					parenStack.push(ch);
				}
				
				if(paranthesisMap.containsKey(ch)) {
					if(paranthesisMap.get(ch) != parenStack.pop()) {
						return false;
					}
				}
			}
			return parenStack.isEmpty();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
