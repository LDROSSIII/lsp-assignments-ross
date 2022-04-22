package org.howard.edu.lsp.finalExam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class MapUtilitiesTest {
	
	HashMap<String, String> map1;
	HashMap<String, String> map2;
	HashMap<String, String> nullMap;
	
	@BeforeEach
	void setUp(){
		map1 = new HashMap<>();
		map2 = new HashMap<>();
		
		map1.put("Alice", "Healthy");
		map1.put("Mary", "Ecstatic");
		map1.put("Bob", "Happy");
		map1.put("Chuck", "Fine");
		map1.put("Felix", "Sick");
		
		map2.put("Mary", "Ecstatic");
		map2.put("Felix", "Healthy");
		map2.put("Ricardo", "Superb");
		map2.put("Tam", "Fine");
		map2.put("Bob", "Happy");
	}
	
	@Test
	@DisplayName("Regular Test")
	public void regularTest() throws NullMapException {
		assertEquals(2, MapUtilities.commonKeyValuePairs(map1, map2));
		
		map2.put("Alice", "Healthy");
		
		assertEquals(3, MapUtilities.commonKeyValuePairs(map1, map2));
	}
	
	@Test
	@DisplayName("When a map is null.")
	public void nullTest() {
		assertThrows(NullMapException.class, () -> {
			MapUtilities.commonKeyValuePairs(nullMap, map1);
		});	
	}
	
	@Test
	@DisplayName("When one of the maps are empty.")
	public void emptyTest() throws NullMapException {
		map2.clear();
		assertEquals(0,MapUtilities.commonKeyValuePairs(map1, map2));
	}

}
