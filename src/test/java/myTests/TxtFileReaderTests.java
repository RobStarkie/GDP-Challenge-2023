package myTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import mySolution.TxtFileReader;

class TxtFileReaderTests {

	@Test
	void isTxtFileEmpty() {
		TxtFileReader TFR = new TxtFileReader();
		TFR.readTxtFile("./data/DDOS-file.txt");
		Map<String, Integer> output = TFR.getMap();
		assertNotNull(output, "txt file is not empty");
	}
	
	@Test
	void addAndRetrieveMap() {
		TxtFileReader TFR = new TxtFileReader();
		TFR.addNewTermToMap("test", 1);
		Map<String, Integer> output = TFR.getMap();
		Map<String, Integer> expectedResult = new HashMap<String, Integer>();
		expectedResult.put("test", 1);
		assertEquals(output, expectedResult);
	}
	
	@Test
	void convertStringToInt() {
		TxtFileReader TFR = new TxtFileReader();
		int test1 =TFR.parseStringToInt("5");
		int test2 =TFR.parseStringToInt("");
		assertEquals(test1,5);
		assertEquals(test2,1);
	}
	
	@Test
	void readFileCorrectly() {
		TxtFileReader TFR = new TxtFileReader();
		TFR.readTxtFile("./data/DDOS-file.txt");
		Map<String, Integer> output = TFR.getMap();
		Map<String, Integer> expectedResult = new HashMap<String, Integer>();
		expectedResult.put("vulnerabilities", 6);
		expectedResult.put("viruses", 9);
		expectedResult.put("cyber", 1);
		expectedResult.put("bugs", 10);
		assertEquals(output, expectedResult);
	}
	

}
