package mySolution;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CyberSecurityXMLTermFinder {
	
	private Map<String, Integer> map = new HashMap<>();
	
	void readXMLFile() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			DocumentBuilder db = dbf.newDocumentBuilder();
	        Document doc = db.parse(new File("./data/cyber-security.xml")); 
	        doc.getDocumentElement().normalize();
	        
	        //define variables
	        String tagName = "cyber";
	        NodeList list = doc.getElementsByTagName(tagName);
	        Node node;
	        int i =0;
	        String word="";
	        int amount=-1;
	        Element element;
	        Set<String> words = Set.of("Vulnerabilities","Viruses","Threats", "Patches","Threat");
	        //loop if tag exists
	        while(list.getLength()==1) {
	        	//loop through each term to find relevant data
	        	for (int temp = 0; temp < list.getLength(); temp++) {
					node = list.item(temp);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						element = (Element) node;
						word = element.getElementsByTagName("item").item(0).getTextContent(); //extracting term name
						if(words.contains(word)) {
							try {
			                	amount = Integer.parseInt(element.getElementsByTagName("amount").item(0).getTextContent());
			                	if(map.get(word)!= null) {
			                		amount = map.get(word)+amount;
			                		map.put(word, amount);
			                	} else {
			                		map.put(word, amount);
			                	}
			                } catch (NumberFormatException e) {
			                	temp = 0;
			                }
						}
					}
				}
	        	i++;
				tagName = "cyber"+"-"+(i)+""; //change the tagName to the next term
				list = doc.getElementsByTagName(tagName); //search for new tagName
	        }

		// catch statements   
		} catch (ParserConfigurationException e) {
            e.printStackTrace();
		} catch (SAXException e) {
             e.printStackTrace();
		} catch (IOException e) {
              e.printStackTrace();
		}
	}

	
	 public Map<String, Integer> getOutPutOfXMLFile() {
		return map;
	}

}
