package by.home.Lesson14.DOM;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MainDOM {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder=factory.newDocumentBuilder();
		Document doc=documentBuilder.parse(new File("src/Families.xml"));
		
		String title1=doc.getDocumentElement().getNodeName();
		System.out.println("Title1= "+title1);
		
		//po tegy prodykt
		NodeList nodeList= doc.getElementsByTagName("family");
		
		String family="";
		String dad="";
		String mom="";
		String child="";
		
		for (int i=0; i<nodeList.getLength(); i++) {
			Element element=(Element)nodeList.item(i);
			family=element.getElementsByTagName("family").item(0).getChildNodes().item(0).getNodeValue();
			dad=element.getElementsByTagName("Father").item(0).getChildNodes().item(0).getNodeValue();
			mom=element.getElementsByTagName("Mother").item(0).getChildNodes().item(0).getNodeValue();
			child=element.getElementsByTagName("Child").item(0).getChildNodes().item(0).getNodeValue();
			}
		
		System.out.println("Family: "+family+"Father: "+dad+"Mother: "+mom+"Child: "+child);
		
	}

}
