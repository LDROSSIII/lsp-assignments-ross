package org.howard.edu.lsp.assignment5.test;

import org.howard.edu.lsp.assignment5.implementation.IntegerSet;
import org.howard.edu.lsp.assignment5.implementation.IntegerSetException;
/**
 * 
 * @author Logan Ross
 *
 */

public class Driver {
	
	/**
	 * 
	 * @param args takes in a string array
	 * @throws IntegerSetException when empty sets are involved
	 */

	public static void main(String[] args) throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		System.out.println("Value of Set1 is: " + set1);
		System.out.println("Smallest value Set1 is: " + set1.smallest());
		System.out.println("Largest value of Set1 is: " + set1.largest());
		System.out.println();
		
		IntegerSet set2 = new IntegerSet();
		set2.add(3);
		set2.add(4);
		set2.add(5);
		
		System.out.println("Union of Set1 and Set2");
		System.out.println("Value of Set1 is: " + set1);
		System.out.println("Value of Set2 is: " + set2);
		set1.union(set2);
		System.out.println("Result of union of Set1 and Set2");
		System.out.println(set1);
		System.out.println();
		
		System.out.println("Intersection of Set1 and Set2");
		System.out.println("Value of Set1 is: " + set1);
		System.out.println("Value of Set2 is: " + set2);
		set1.intersect(set2);
		System.out.println("Result of intersection of Set1 and Set2");
		System.out.println(set1);
		System.out.println();
		
		System.out.println("Value of Set1 is: " + set1);
		System.out.println("Value of Set2 is: " + set2);
		if (set1.equals(set2))
			System.out.println("Currently, Set1 and Set2 are equal.");
		else
			System.out.println("Currently, Set1 and Set2 are not equal.");
		System.out.println();
		
		set1.add(1);
		set2.add(2);
		System.out.println("Value of Set1 is: " + set1);
		System.out.println("Value of Set2 is: " + set2);
		if (set1.equals(set2))
			System.out.println("Currently, Set1 and Set2 are equal.");
		else
			System.out.println("Currently, Set1 and Set2 are not equal.");
		System.out.println();
		
		set1.add(2);
		set2.add(1);
		set1.add(1);
		set2.add(2);
		System.out.println("Value of Set1 is: " + set1);
		System.out.println("Value of Set2 is: " + set2);
		if (set1.equals(set2))
			System.out.println("Currently, Set1 and Set2 are equal.");
		else
			System.out.println("Currently, Set1 and Set2 are not equal.");
		System.out.println();
		
		System.out.println("Value of Set1 is: " + set1);
		System.out.println("Value of Set2 is: " + set2);
		System.out.println("Result of intersection of Set1 and Set2");
		set1.diff(set2);
		System.out.println(set1);
		System.out.println();
		
		System.out.println("Value of Set1 is: " + set1);
		System.out.println("Value of Set2 is: " + set2);
		if (set2.isEmpty())
			System.out.println("Set2 is empty.");
		else
			System.out.println("Set2 is not empty.");
		set2.clear();
		System.out.println("Value of Set2 after cleared is: " + set2);
		if (set2.isEmpty())
			System.out.println("Set2 is empty.");
		else
			System.out.println("Set2 is not empty.");
		if (set1.equals(set2))
			System.out.println("Currently, Set1 and Set2 are equal.");
		else
			System.out.println("Currently, Set1 and Set2 are not equal.");
		// These lines can be commented out to see the various error messages in action
		set1.remove(5);
		System.out.println("Smallest value Set1 is: " + set1.smallest());
		System.out.println("Largest value of Set1 is: " + set1.largest());
		
	}

}
