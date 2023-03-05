package mySolution;

import java.util.HashMap;
import java.util.Map;

public class ChallengeMain {
	
	
	public static void main(String[] args) {
		ChallengeMain CM = new ChallengeMain();
		Map<String, Integer> cSMap = new HashMap<>();
		Map<String, Integer> dDOSMap = new HashMap<>();
		Map<String, Integer> secureFileMap = new HashMap<>();
		Map<String, Integer> jsonFileMap = new HashMap<>();
		cSMap = CM.readCyberSecurityXMLFile();
		dDOSMap = CM.readDDOSFileTxt();
		secureFileMap = CM.readsecureFileTxt();
		jsonFileMap = CM.JsonFileReader();
		CM.printMaps(cSMap, dDOSMap, secureFileMap, jsonFileMap);
		
		
	}
	
	
	public Map<String, Integer> readCyberSecurityXMLFile() {
		Map<String, Integer> map = new HashMap<>();
		CyberSecurityXMLTermFinder csTermFinder = new CyberSecurityXMLTermFinder();//create new instance
		csTermFinder.readXMLFile(); //read file
		map = csTermFinder.getOutPutOfXMLFile();//get output
		return map;
	}
	
	public Map<String, Integer> readDDOSFileTxt() {
		Map<String, Integer> map = new HashMap<>();
		TxtFileReader TFR = new TxtFileReader();
		TFR.readTxtFile("./data/DDOS-file.txt");
		map = TFR.getMap();
		return map;	
	}
	
	public Map<String, Integer> readsecureFileTxt() {
		Map<String, Integer> map = new HashMap<>();
		TxtFileReader TFR = new TxtFileReader();
		TFR.readTxtFile("./data/Secure-file.txt");
		map = TFR.getMap();
		return map;	
	}
	
	public Map<String, Integer> JsonFileReader() {
		Map<String, Integer> map = new HashMap<>();
		JsonFileReader JFR = new JsonFileReader();
		map = JFR.jsonFileToMap("./data/online-data.json");
		return map;	
	}
	
	void printMaps(Map<String, Integer> cSMap, Map<String, Integer> dDOSMap, Map<String, Integer> secureFileMap ,Map<String, Integer> jsonFileMap) {
		
		System.out.println("Key Terms Found in 'cyber-security.xml':");
		for (Map.Entry<String, Integer> entry : cSMap.entrySet()) {
		    System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		System.out.println("Key Terms Found in 'DDOS-file.txt':");
		for (Map.Entry<String, Integer> entry : dDOSMap.entrySet()) {
		    System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		System.out.println("Key Terms Found in 'Secure-file.txt':");
		for (Map.Entry<String, Integer> entry : secureFileMap.entrySet()) {
		    System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
		
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println();
		
		System.out.println("Key Terms Found in 'Secure-file.txt':");
		for (Map.Entry<String, Integer> entry : jsonFileMap.entrySet()) {
		    System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
	}
}
