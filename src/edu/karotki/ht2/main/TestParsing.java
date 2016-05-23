package edu.karotki.ht2.main;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
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
			
		
			
			NodeList mList=doc.getElementsByTagName("header").item(0).getChildNodes();
			NodeList cList=doc.getElementsByTagName("category");
			NodeList iList; 
		for(int l=0; l<cList.getLength();l++){
			System.out.println(cList.item(l).getAttributes().item(1).getNodeValue());
			System.out.println("-------------------------");
			for(int i=0;i<mList.getLength();i++)
			{System.out.println(mList.item(i).getTextContent().trim()+"  ");}
			System.out.println();
			System.out.println("-------------------------");
			iList=cList.item(l).getChildNodes();
			for(int i=0;i<iList.getLength();i++){
				for (int j=0;j<iList.item(i).getChildNodes().getLength();j++)
				{for(int k=0;k<iList.item(i).getChildNodes().item(j).getChildNodes().getLength();k++){
					System.out.println(iList.item(i).getChildNodes().item(j).getChildNodes().item(k).getTextContent().trim()+"   ");
				}
					}
				System.out.println("***************************");
				System.out.println();
			}
		}
		}catch(Exception e) {e.printStackTrace();}

	}

}
