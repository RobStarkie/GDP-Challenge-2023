package myTests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


import mySolution.ChallengeMain;
import mySolution.TxtFileReader;

class JUnitTests {
	
	@Test
	void isCyberSecurityXMLFileEmpty() {
		ChallengeMain CM = new ChallengeMain();
		Map<String, Integer> output = CM.readCyberSecurityXMLFile();
		assertNotNull(output, "XML file is not empty");
	}
	
	@Test
	void outputCorrectForXMLFile() {
		ChallengeMain CM = new ChallengeMain();
		Map<String, Integer> output = CM.readCyberSecurityXMLFile();
		Map<String, Integer> expectedResult = new HashMap<String, Integer>();
		expectedResult.put("Vulnerabilities", 5);
		expectedResult.put("Viruses", 5);
		expectedResult.put("Threats", 5);
		expectedResult.put("Patches", 99); 
		expectedResult.put("CD", 50);
		expectedResult.put("Threat", 1);
		assertEquals(output, expectedResult);
	}
	
	

}

