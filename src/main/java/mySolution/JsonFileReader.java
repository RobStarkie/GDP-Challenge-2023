package mySolution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFileReader {
	

	private Map<String, Integer> keyTerms = new HashMap<>();
	
	public String readJsonFile(String filePath) {
		BufferedReader br=null;
		String line ="";
		String jsonText="";
		try {
			FileReader fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			
			while((line = br.readLine()) !=null ) {
				jsonText += line +"\n";//reads each line and adds to next line on string
				searchForKeyTerms(line);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return jsonText; //returns string of the json file
	}
	
	public Map<String, Integer> jsonFileToMap(String filePath) {
		String jsonTxt = readJsonFile(filePath);
		try {
			
			JSONParser parser = new JSONParser();
            Object object = parser.parse(jsonTxt); //parses txt into an object
            JSONObject mainJsonObject = (JSONObject) object; //creates json object
            
            for(String key: keyTerms.keySet()) {
            	
            	if(mainJsonObject.get(key) instanceof JSONArray) { //if object is an array
            		JSONArray array = (JSONArray) mainJsonObject.get(key);
                	keyTerms.put(key,array.size());//add term and amount to map
            	} else if (mainJsonObject.get(key) instanceof JSONObject) { //if object is an object
            		keyTerms.put(key, keyTerms.get(key)+1);//add term and amount to map
            		
            	}
            }
            
		} catch(Exception e) {
            e.printStackTrace();
        }
		return keyTerms; //return map
		
	}
	
	
	public void searchForKeyTerms(String line) {
		Set<String> words = Set.of("Vulnerability","vulnerabilities","vulnerability", "virus","viruses","Threat", "threat","threats", "patch","patches", "bugs","ddos", "cyber", "security");
		String word="";
		
	    for (int i = 0, j = 0; j <= line.length(); j++) { //loop through line
	        char ch = j == line.length() ? '\0' : line.charAt(j);
	        if (j == line.length() || !Character.isLetter(ch) ) {
	        	word = line.substring(i, j);//gets each word in string line
	        	word = word.replace("\"", "");//removes "" from word
	        	word = word.trim();//gets rid of empty space
	            if (!word.isEmpty() && words.contains(word)) {
	            	keyTerms.put(word,0); //if word is present add to map
	            }
	        	
	        }
	    }
		
	}
	
	public Map<String, Integer> getMap() {
		return keyTerms; //returns map
	}

}
