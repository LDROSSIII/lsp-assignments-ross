package org.howard.edu.lsp.assignment2;
import java.util.Scanner;
// author Logan Ross

public class InputToken {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String tokens = "";
		/**
		 * Creates the loop of string calculations
		 */
		while(true) {
			System.out.println("String?");
			tokens = input.nextLine();
			if (tokens.equals("Goodbye"))
				break;
			System.out.println("Tokens:");
			calculate(tokens);
			System.out.println();
		}
	}
	
	/**
	 * Calculates the product and sum based on the string input and prints
	 * @param tokens
	 */
	public static void calculate(String tokens){
		int space;
		int token;
		int sum = 0;
		int product = 1;
		
		while (true) {
			space = tokens.indexOf(" ");
			if (space >= 0)
				token = Integer.parseInt(tokens.substring(0,space));
			else
				token = Integer.parseInt(tokens);
			System.out.println(token);
			sum += token;
			product *= token;
			if (space < 0)
				break;
			tokens = tokens.substring(tokens.indexOf(" ") + 1);
		}
		
		System.out.println("Sum: " + sum);
		System.out.println("Product: " + product);
	}
}
