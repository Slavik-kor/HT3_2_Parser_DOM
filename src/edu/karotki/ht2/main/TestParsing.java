package edu.karotki.ht2.main;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;


public class TestParsing {

	public static void main(String[] args) {
		try{
			DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder Builder = Factory.newDocumentBuilder();
			Document doc = Builder.parse(new File("menu.xml"));
			doc.getDocumentElement().normalize();
			
			System.out.println("Меню ресторана жемчужинка");
			System.out.println("-------------------------");
			
			NodeList mList=doc.getElementsByTagName("header");
		//	Node header=mList.item(1);
			
			System.out.print(mList.getLength());
		
			
			System.out.println("ok");	
		}catch(Exception e) {e.printStackTrace();}

	}

}
