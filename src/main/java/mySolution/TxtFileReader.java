package mySolution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TxtFileReader {
	private Map<String, Integer> map = new HashMap<>();
	
	public void readTxtFile(String fileLocation) {
		BufferedReader br = null;
		try {
			//open readers
			FileReader fr = new FileReader(fileLocation);
			br = new BufferedReader(fr);
			String line;
			int amount=0;
			String word;
			String tempAmount="";
			
			Set<String> words = Set.of("vulnerabilities", "virus","viruses", "threat","threats", "patch","patches", "bugs","ddos", "cyber", "security");
			while ((line = br.readLine()) != null) { // read each line if it doesn't null
				line = line.toLowerCase(); // convert each line to lower case
			    for (int i = 0, j = 0; j <= line.length(); j++) { //loop through line
			        char ch = j == line.length() ? '\0' : line.charAt(j);
			        if (Character.isDigit(ch)) {
			        	tempAmount = tempAmount + ch;//gets each word from each line
			        } else if (j == line.length() || !Character.isLetter(ch) ) { //finds j once a space if found by the !isWordSymbol, isLetter is more efficient than .matches as it doesn't compile a new pattern
			            word = line.substring(i, j);//gets each word from each line
			            if (!word.isEmpty() && words.contains(word)) { //checks to see if the current word is in the word data set
		            		amount = parseStringToInt(tempAmount);
		                	addNewTermToMap(word,amount);
			                tempAmount="";
			            }
			            i = j + 1;
			            
			        }
			    }
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public void addNewTermToMap(String word, int amount) {
		if(map.get(word)!= null) {
    		amount = map.get(word)+ amount; // if word is already present in map, add the value stored in the map to the new found amount
    		map.put(word, amount);
    	} else {
    		map.put(word, amount); // if word isn't present in map, add to map
    	}
	}
	
	public int parseStringToInt(String tempAmount) {
		int amount=0;
		try {
	    	amount = Integer.parseInt(tempAmount);// parse amount from string to an integer
	    	return amount;
		} catch (NumberFormatException e) { //if term had no associated amount return as 1
	    	return 1;
	    }
	}
	
	public Map<String, Integer> getMap() {
		return map;
	}
}
