package org.howard.edu.lsp.assignment6.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.howard.edu.lsp.assignment6.integerset.IntegerSet;
import org.howard.edu.lsp.assignment6.integerset.IntegerSetException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class IntegerSetTest {
	
	IntegerSet set1;
	IntegerSet set2;
	IntegerSet testCase;
	
	@BeforeEach
	void setUp(){
		set1 = new IntegerSet();
		set2 = new IntegerSet();
		testCase = new IntegerSet();
		
		set1.add(0);
		set1.add(1);
		set1.add(2);
		
		set2.add(2);
		set2.add(3);
		set2.add(4);
	}
	
	@Test
	@DisplayName("Test case for toString")
	public void testToString() {
		assertEquals("∅", testCase.toString());
		
		assertEquals("0, 1, 2", set1.toString());
		
		assertEquals("2, 3, 4", set2.toString());
	}
	
	@Test
	@DisplayName("Test case for Add")
	public void testAdd() {
		testCase.add(0);
		testCase.add(1);
		testCase.add(2);
		assertEquals("0, 1, 2", testCase.toString());
		
		testCase.add(0);
		assertEquals("0, 1, 2", testCase.toString());
	}
	
	@Test
	@DisplayName("Test case for Remove")
	public void testRemove() throws IntegerSetException {
		set1.remove(4);
		
		set1.remove(0);
		set1.remove(1);
		set1.remove(2);
		assertTrue(set1.equals(testCase));
		assertThrows(IntegerSetException.class, () -> {
			set1.remove(0);
		});	
	}
	
	@Test
	@DisplayName("Test case for isEmpty")
	public void testIsEmpty() {
		assertTrue(testCase.isEmpty());
		assertFalse(set1.isEmpty());
	}
	
	@Test
	@DisplayName("Test case for Clear")
	public void testClear() {
		testCase = new IntegerSet();
		testCase.add(0);
		assertFalse(testCase.isEmpty());
		testCase.clear();
		assertTrue(testCase.isEmpty());
	}
	
	@Test
	@DisplayName("Test case for Equals")
	public void testEquals() {
		assertFalse(set1.equals(set2));
		
		set1.add(3);
		set1.add(4);
		
		set2.add(0);
		set2.add(1);
		
		assertTrue(set1.equals(set2));
		set1.add(0);
		set2.add(4);
		assertTrue(set1.equals(set2));
		assertFalse(set1.equals(testCase));
		set1.clear();
		assertTrue(set1.equals(testCase));
	}
	
	@Test
	@DisplayName("Test case for Contains")
	public void testContains() {
		assertTrue(set1.contains(0));
		assertFalse(set2.contains(0));
		assertFalse(testCase.contains(0));
		
		assertTrue(set2.contains(4));
		assertFalse(set1.contains(4));
	}
	
	@Test
	@DisplayName("Test case for Largest")
	public void testLargest() throws IntegerSetException {
		assertEquals(2,set1.largest());
		assertEquals(4,set2.largest());
		assertThrows(IntegerSetException.class, () -> {
			testCase.largest();
		});	
	}
	
	@Test
	@DisplayName("Test case for Smallest")
	public void testSmallest() throws IntegerSetException {
		assertEquals(0,set1.smallest());
		assertEquals(2,set2.smallest());
		assertThrows(IntegerSetException.class, () -> {
			testCase.smallest();
		});	
	}
	
	@Test
	@DisplayName("Test case for Union")
	public void testUnion() {
		testCase = new IntegerSet();
		testCase.add(0);
		testCase.add(1);
		testCase.add(2);
		testCase.union(set2);
		assertEquals("0, 1, 2, 3, 4", testCase.toString());
	}
	
	@Test
	@DisplayName("Test case for Intersection")
	public void testIntersection() throws IntegerSetException {
		set1.intersect(set2);
		assertEquals("2", set1.toString());
		
		set1.intersect(testCase);
		assertEquals("∅", set1.toString());
	}

}
