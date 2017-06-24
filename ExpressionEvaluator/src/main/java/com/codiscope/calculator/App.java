package com.codiscope.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class.getName());
	
	public static void main(String[] args) {
		
		String expression = "add(5,5)";
	
		/*
		if(args.length > 0) 
			expression = args[0]; 
		else
			System.out.println("Please enter the argrument");
		*/

		ExpressionEvaluator calculator = new ExpressionEvaluator();

		try {
			LOGGER.info("Performing the operation : " + expression);
			double result = calculator.evaluateExpression(expression);
			if(result != Integer.MAX_VALUE) {
				LOGGER.info("Result of the operation : " + result);
				System.out.println(result);
			}
		} catch (Exception e) {
			LOGGER.error(String.format("Exception found: %1$s", e.getMessage()), e);
		}
	}
}
