package com.codiscope.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class.getName());
	
	public static void main(String[] args) {
		
		String expression = null;
		
		if(args.length > 0)  {
			
			expression = args[0].replaceAll(" ", "");
			
			// minimum length for any expression is 8. Ex:- add(1,2)
			// maximum length we are allowing to solve a expression is 200 
			if(expression.length() < 8 || expression.length() > 200) {
				LOGGER.error("Please enter the expression length greater than 8 and less than 200");
				LOGGER.error("Invalid expression length");
				return;
			}
			
		}
		else
			System.out.println("Please enter the expression as input for calculator");	
		
		Calculator calculator = new Calculator();
		
		try {
			LOGGER.info("Performing the operation : " + expression);
			
			float result = calculator.evaluateExpression(expression);
			if(result != Integer.MAX_VALUE) {
				LOGGER.info("Result of the operation : " + result);
				System.out.println(result);
			}
		} catch (Exception e) {
			LOGGER.error(String.format("Exception found: %1$s", e.getMessage()), e);
			e.printStackTrace();
		}
	}
}
