package com.galaxy.rulesImpl;

import java.lang.reflect.Array;
import java.util.Arrays;

import com.galaxy.logic.RomanNumerals;
import com.galaxy.rules.ConversionProtocol;

public class RomanToDecimalConverter implements ConversionProtocol {

	public RomanToDecimalConverter() {
		for (Character ch : repeatableRomanNumerals) {
			repeatableRomanNumeralCount.put(ch, 0);
		}

		for (Character ch : nonRepeatableRomanNumerals) {
			nonRepeatableRomanNumeralCount.put(ch, 0);
		}

		romanNumeralSubtractableMapping.put('I', new Character[] { 'V', 'X' });
		romanNumeralSubtractableMapping.put('V', new Character[] {});
		romanNumeralSubtractableMapping.put('X', new Character[] { 'L', 'C' });
		romanNumeralSubtractableMapping.put('L', new Character[] {});
		romanNumeralSubtractableMapping.put('C', new Character[] { 'D', 'M' });
		romanNumeralSubtractableMapping.put('D', new Character[] {});
		romanNumeralSubtractableMapping.put('M', new Character[] {});
	}

	@Override
	public Integer convertRomanToDecimal(String romanString) {
		char prevLiteral = ' ';
		int result = 0;
		for (Character ch : romanString.toCharArray()) {
			validateLiteral(ch);
			result = processRomanNumeral(prevLiteral, ch, result);
			prevLiteral = ch;
		}
		repeatableRomanNumeralCount.clear();
		nonRepeatableRomanNumeralCount.clear();
		
		return result;
	}

	private void validateLiteral(Character literal) {

		if (nonRepeatableRomanNumeralCount.containsKey(literal)) {

			if (nonRepeatableRomanNumeralCount.get(literal) > 0) {
				System.out.print("The numeral " + literal
						+ "can not be repeated");
				System.exit(0);
			}
			nonRepeatableRomanNumeralCount.put(literal,
					nonRepeatableRomanNumeralCount.get(literal) + 1);

		} else if (repeatableRomanNumeralCount.containsKey(literal)) {

			if (repeatableRomanNumeralCount.containsValue(3)) {
				System.out.println("The numeral " + literal
						+ "can not be repeated more than 3 times");
			}
			repeatableRomanNumeralCount.put(literal,
					repeatableRomanNumeralCount.get(literal) + 1);

		}
	}

	private Integer getIntValueByRoman(String romanToken) {
		for (RomanNumerals rn : RomanNumerals.values()) {
			if (rn.getRomanToken().equalsIgnoreCase(romanToken)) {
				return rn.getValue();
			}
		}
		return 0;
	}

	private int processRomanNumeral(Character prevLiteral,
			Character currenLiteral, int result) {
		int preLiteralValue = getIntValueByRoman(Character.toString(prevLiteral));
		int currentLiteralValue = getIntValueByRoman(Character.toString(currenLiteral));
		
		if (preLiteralValue != 0 && preLiteralValue < currentLiteralValue) {
			
			if(Arrays.asList(romanNumeralSubtractableMapping.get(prevLiteral)).contains(currenLiteral)){
				return result - preLiteralValue;
			} else
				return result + preLiteralValue;
		} else {
			return result + currentLiteralValue;
		}
	}

}
