package myTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import mySolution.JsonFileReader;

class JsonFileReaderTests {

	@Test
	void test() {
		JsonFileReader JFR = new JsonFileReader();
		Map<String, Integer> output = JFR.jsonFileToMap("./data/online-data.json");
		Map<String, Integer> expectedResult = new HashMap<String, Integer>();
		expectedResult.put("Vulnerability", 1);
		expectedResult.put("Threat", 4);
		assertEquals(output, expectedResult);
	}
	
	@Test 
	void searchForKeyWords() {
		JsonFileReader JFR = new JsonFileReader();
		JFR.searchForKeyTerms(" Vulnerability ");
		Map<String, Integer> output =JFR.getMap();
		Map<String, Integer> expectedResult = new HashMap<String, Integer>();
		expectedResult.put("Vulnerability", 0);
		assertEquals(output, expectedResult);
	}
	
	@Test
	void testGetMap() {
		JsonFileReader JFR = new JsonFileReader();
		Map<String, Integer> output =JFR.getMap();JFR.getMap();
		Map<String, Integer> expectedResult = new HashMap<String, Integer>();
		assertEquals(output,expectedResult);
		
	}
	
	@Test
	void testReadJSON() {
		JsonFileReader JFR = new JsonFileReader();
		String output = JFR.readJsonFile("./data/online-data.json");
		String expectedResult ="";
		assert(!output.equals(expectedResult));
	}

}
