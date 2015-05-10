package com.galaxy.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.galaxy.rulesImpl.RomanToDecimalConverter;

public class InputFileProcessor {

	private static Map<String,String> tokenToRomanMapper = new HashMap<String,String>();
	private static List<String> missingTokens = new ArrayList<>();
	private static List<String> questions =  new ArrayList<>();
 	
	public static void process(String filePath) throws IOException {
		//FileReader reader = new FileReader(filePath);
		String line = null;
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		
		while((line = reader.readLine()) != null){
			processMapping(line);
		}
		reader.close();
		System.out.println(" === >");
		processMissingTokens();
	}
	
	private static void processMapping(final String line) {
		String tokens[] = line.split(" ");
		if(tokens.length > 2) {
			if(tokens[1].equals("is")) {
				tokenToRomanMapper.put(tokens[0], tokens[2]);
			} else if(line.endsWith("?")) {
				questions.add(line);
			} else if(tokens[tokens.length - 1].equalsIgnoreCase("Credits")) {
				missingTokens.add(line);
			}
		}
	}
	
	public static void show() {
		System.out.println(tokenToRomanMapper);
		System.out.println(missingTokens);
		System.out.println(questions);
	}
	
	private static void processMissingTokens() {
		String []tokens= null;
		StringBuilder sb = null;
		int value = 0;
		String missingToken = "";
		RomanToDecimalConverter converter = new RomanToDecimalConverter();
		
		for(String str : missingTokens) {
			sb = new StringBuilder();
			tokens = str.split(" ");
			for(int i=0; i < tokens.length; i++) {
				if(tokenToRomanMapper.containsKey(tokens[i])) {
					sb.append(tokenToRomanMapper.get(tokens[i]));
				} if(tokens[i].equalsIgnoreCase("credits")){
					value = Integer.parseInt(tokens[i-1]);
				} if(tokens[i].equalsIgnoreCase("is")){
					missingToken = tokens[i-1];
				}
			}
			System.out.println("====>"+sb.toString() + " "+value);
			System.out.println(" "+converter.convertRomanToDecimal(sb.toString()) + " "+value/converter.convertRomanToDecimal(sb.toString()));
		}
	}
}
