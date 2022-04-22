package org.howard.edu.lsp.finalExam;

import java.util.HashMap;
import java.util.Map.Entry;

public class MapUtilities {
    public static void main(String[] args) {
    	
    }
	
	public static int commonKeyValuePairs(
        HashMap<String, String> map1,
        HashMap<String, String> map2)throws NullMapException {
		if (map1 == null || map2 == null)
			throw new NullMapException("One or both maps are null!");
		
		int counter = 0;
			
		/*if (map1.isEmpty() || map2.isEmpty())
			return 0;*/
		
		for (Entry<String, String> entry: map1.entrySet()) {
			for (Entry<String, String> e: map2.entrySet())
				if (e.equals(entry))
					counter++;
		}
		
		return counter;
    }
}
