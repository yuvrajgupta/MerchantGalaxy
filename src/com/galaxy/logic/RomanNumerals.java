package com.galaxy.logic;

public enum RomanNumerals {

	I("i", 1),
	V("v", 5),
	X("x", 10),
	L("l", 50),
	C("c", 100),
	D("d", 500),
	M("m", 1000);
	
	
	private String romanToken;
	private Integer value;
		
	private RomanNumerals(String romanToken, Integer value) {
		// TODO Auto-generated constructor stub
		this.romanToken = romanToken;
		this.value = value;
	}
	
	public String getRomanToken() {
		return romanToken;
	}
	public void setRomanToken(String romanToken) {
		this.romanToken = romanToken;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
}
