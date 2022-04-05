package org.howard.edu.lsp.assignment6.integerset;

import java.util.ArrayList;
/**
 * 
 * @author Logan Ross
 *
 */

public class IntegerSet {
	private ArrayList<Integer> set = new ArrayList<Integer>();
	
	/**
	 * IntegerSet constructor
	 */
	public IntegerSet() {
		
	}
	
	/**
	 * Empties out the IntegerSet
	 */
	public void clear() {
		set.clear();
	};
	
	/**
	 *
	 * @return the length of the IntegerSet
	 */
	public int length() {
		return set.size();
	};
	
	/**
	 *
	 * @param b is the IntegerSet that is being compared
	 * @return true if the two sets are equal, false if otherwise
	 */
	public boolean equals(IntegerSet b) {
		int counter = 0;
		for (int i : b.set)
			if (this.contains(i))
				counter++;
		if (counter == this.length())
			return true;
		return false;
	};
	
	/**
	 *
	 * @param value is the value being searched for
	 * @return true if the IntegerSet contains the given value, false if otherwise
	 */
	public boolean contains(int value) {
		return set.contains(value);
	};
	
	/**
	 *
	 * @return the largest integer in the IntegerSet
	 * @throws IntegerSetException with null sets
	 */
	public int largest() throws IntegerSetException{
		if (set.size() == 0)
			throw new IntegerSetException("There are no values in this set!");
		int num = set.get(0);
		for (int i = 1; i < set.size(); i++)
			if (set.get(i) > num)
				num = set.get(i);
		return num;
	};
	
	/**
	 *
	 * @return the smallest integer in the IntegerSet
	 * @throws IntegerSetException with null sets
	 */
	public int smallest() throws IntegerSetException{
		if (set.size() == 0)
			throw new IntegerSetException("There are no values in this set!");
		int num = set.get(0);
		for (int i = 1; i < set.size(); i++)
			if (set.get(i) < num)
				num = set.get(i);
		return num;
	};
	
	/**
	 *
	 * @param item is the value being added to the IntegerSet
	 */
	public void add(int item) {
		if (!set.contains(item))
			set.add(item);
	};
	
	/**
	 *
	 * @param item is the value being removed from the IntegerSet
	 * @throws IntegerSetException with null sets
	 */
	public void remove(int item) throws IntegerSetException {
		if (set.size() == 0)
			throw new IntegerSetException("There are no values in this set to remove!");
		set.remove(Integer.valueOf(item));
	};
	
	/**
	 *
	 * @param intSetb is the second set that participated in the union
	 */
	public void union(IntegerSet intSetb) {
		for (int i : intSetb.set)
			this.add(i);
	};
	
	/**
	 *
	 * @param intSetb is the set that is being intersected with
	 * @throws IntegerSetException when one of the IntegerSets are empty
	 */
	public void intersect(IntegerSet intSetb) throws IntegerSetException {
		if (this.length() < intSetb.length()) {
			for (int i : intSetb.set)
				if (!this.contains(i))
					this.remove(i);
		}
		else {
			for (int i = 0; i < this.length(); i++)
				if (!intSetb.contains(set.get(i))) {
					this.remove(set.get(i));
					i--;
				}
		}
			
	};
	
	/**
	 *
	 * @param intSetb is the IntegerSet being subtracted from the initial set
	 * @throws IntegerSetException when one of the IntegerSets are empty
	 */
	public void diff(IntegerSet intSetb) throws IntegerSetException {
		for (int i : intSetb.set)
			if (this.contains(i))
				this.remove(i);
	};
	
	/**
	 * 
	 * @return true if the set is empty, false if otherwise
	 */
	public boolean isEmpty(){
		if (set.size() == 0)
			return true;
		return false;
	};
	
	public String toString() {
		String ans = "";
		for (int i : set)
			ans += i + ", ";
		if (ans.length() >= 2)
			return ans.substring(0,ans.length()-2);
		return "∅";
	}

}
