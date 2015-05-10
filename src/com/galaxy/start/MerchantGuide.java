package com.galaxy.start;

import java.io.IOException;

import com.galaxy.logic.InputFileProcessor;

public class MerchantGuide {

	public static void main(String args[]) {
		String filePath = "Input";
		if(args.length != 0){
			filePath = args[0];
		}
		
		try {
			InputFileProcessor.process(filePath);
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
		InputFileProcessor.show();
	}
}
