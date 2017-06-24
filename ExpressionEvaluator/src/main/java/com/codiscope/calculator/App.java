package com.codiscope.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class.getName());
		
		public static void main(String[] args) {
			String expression = null;

			
			if(args.length > 0)
				expression = args[0];
			else
				System.out.println("Please enter the argrument");
			
			ExpressionEvaluator calc = new ExpressionEvaluator();
			
			try{
				LOGGER.info("Performing the operation : " + expression);
				double result = calc.evaluateExpression(expression);
				System.out.println(result);				
			}catch(Exception e){
				LOGGER.error(String.format("Exception found: %1$s", e.getMessage()), e);
			}
		}
}
