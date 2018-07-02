package by.home.Lesson14.SAX;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler{
	private int id;
	private String family;
	private Map<Integer, String> data= new HashMap<Integer, String>();
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start parsing");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("End parsing");
		super.endDocument();
	}
	
	@Override
	public void startElement(String nameSpace, String localName, String qName, Attributes attr) throws SAXException {
	family=qName;
	if(family.equals("family")) {
		id=Integer.parseInt(attr.getValue(0));
	}
	}
	
	@Override
	public void endElement(String nameSpace, String localName, String qName) throws SAXException {
	family="";
	id=-1;
	}
	
	@Override
	public void characters(char[] ch, int start, int end) throws SAXException {
	if(family.equals("family")) {
		String familyStr=new String (ch, start, end);
		data.put(id, familyStr);
	}
	}
	
	public Map<Integer, String> getData(){
		return data;
	}


	
	

}
