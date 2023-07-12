package api;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLFileReader {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("app.xml");
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.parse(fis);
			document.getDocumentElement().normalize();
			
			NodeList tagList = document.getElementsByTagName("record");
			System.out.println(tagList.getLength());
			System.out.println(tagList.item(0).getChildNodes().getLength());
			
			NodeList childList = tagList.item(0).getChildNodes();
			for (int i=0;i<childList.getLength();i++) {
				if(childList.item(i).getNodeType() == Node.ELEMENT_NODE) {
					System.out.println(childList.item(i).getNodeName() + " - " 
							+ childList.item(i).getTextContent());
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}



