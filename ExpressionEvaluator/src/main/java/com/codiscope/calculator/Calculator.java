package com.codiscope.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {

	private static final Logger LOGGER = LoggerFactory.getLogger(Calculator.class.getName());

	private Pattern pattern = Pattern.compile("\\d+");
	private Map<Object, Float> operations = new HashMap<>();

	private float evaluate(Object expList) {

		if (expList instanceof String) {
			
			if (pattern.matcher(expList.toString()).matches())
				return Integer.parseInt(expList.toString());
			
			else
				return operations.get(expList.toString());
		} 
		else {
			
			ArrayList<?> expressionList = (ArrayList<?>) expList;

			String operator = expressionList.get(0).toString();
			Object exp = expressionList.get(1);

			if (operator.equalsIgnoreCase("start"))
				return evaluate(exp);

			else if (operator.equalsIgnoreCase("add")) {

				LOGGER.info("Performing addition");
				return evaluate(exp) + evaluate(expressionList.get(2));				
			} else if (operator.equalsIgnoreCase("sub")) {

				LOGGER.info("Performing subtraction");
				return evaluate(exp) - evaluate(expressionList.get(2));
			} else if (operator.equalsIgnoreCase("mult")) {

				LOGGER.info("Performing multiplication");
				return evaluate(exp) * evaluate(expressionList.get(2));
			} else if (operator.equalsIgnoreCase("div")) {

				LOGGER.info("Performing division");
				return evaluate(exp) / evaluate(expressionList.get(2));
			} else if (operator.equalsIgnoreCase("let")) {

				LOGGER.info("Performing let operation");
				operations.put(exp, evaluate(expressionList.get(2)));
				return evaluate(expressionList.get(3));
			} else {

				LOGGER.error("Invalid operation");
				return Integer.MAX_VALUE;
			}
		}
	}

	private Object[] parseExp(String expression, String operation, int index) {
		
		ArrayList<Object> expList = new ArrayList<Object>();
		
		expList.add(operation);
		String temp = "";
		
		try {
			while (true) {
				char charPoint = expression.charAt(index);
				if (charPoint == '(') {
					Object[] returned = parseExp(expression, temp, index + 1);
					index = (Integer) returned[1];
					expList.add(returned[0]);
					temp = "";
					
					if (operation.equalsIgnoreCase("start"))
						break;
					
				} else if (charPoint == ')') {
					if (temp.length() > 0)
						expList.add(temp);
					break;
					
				} else if (charPoint == ',') {
					if (temp.length() > 0)
						expList.add(temp);
					temp = "";
				} else {
					temp += expression.charAt(index);
				}
				++index;
			}
		} catch (Exception e) {
			LOGGER.error(String.format("Exception found: %1$s", e.getMessage()), e);
			e.printStackTrace();
		}

		return new Object[] { expList, index };
	}

	public float evaluateExpression(String expression) {
		LOGGER.info("Operation is started");
		return evaluate(parseExp(expression.replaceAll(" ", ""), "start", 0)[0]);
	}
}
