package com.galaxy.rules;

import java.util.*;

public interface ConversionProtocol {
	public static final Character[] repeatableRomanNumerals = {'I','X','C','M'};
	public static final Character[] nonRepeatableRomanNumerals = {'D','L','V'};
	
	public static final Map<Character, Integer> repeatableRomanNumeralCount = new HashMap<Character,Integer>();
	public static final Map<Character, Integer> nonRepeatableRomanNumeralCount = new HashMap<Character,Integer>();

	public static final Map<Character, Character[]> romanNumeralSubtractableMapping  = 	new HashMap<Character, Character[]>();
	public Integer convertRomanToDecimal(String romanString);
}
