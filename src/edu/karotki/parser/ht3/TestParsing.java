package edu.karotki.parser.ht3;

import java.io.File;

public class TestParsing {

	public static void main(String[] args) {
		DomParserSlv parser = new DomParserSlv();
		Node doc = parser.parse(new File("menu.xml"));
		System.out.println(doc.getTag());
		for (int i=0;i<doc.getChildNodes().size();i++){
		System.out.println(doc.getChildNodes().get(i).getTag());
		if(doc.getChildNodes().get(i).isNode()){
			for(int j=0; j<doc.getChildNodes().get(i).getChildNodes().size();j++){
				System.out.println(doc.getChildNodes().get(i).getChildNodes().get(j).getTag());
				if(doc.getChildNodes().get(i).getChildNodes().get(j).isNode()){
					for (int s=0;s<doc.getChildNodes().get(i).getChildNodes().get(j).getChildNodes().size();s++)
					   if(doc.getChildNodes().get(i).getChildNodes().get(j).getChildNodes().get(s).isNode()){
						   for (int k=0;k<doc.getChildNodes().get(i).getChildNodes().get(j).getChildNodes().get(s).getChildNodes().size();k++ ){
							   System.out.print(doc.getChildNodes().get(i).getChildNodes().get(j).getChildNodes().get(s).getChildNodes().get(k).getTextContent()+"   ");
							   System.out.println("");
						   }
					   }else{
						System.out.print(doc.getChildNodes().get(i).getChildNodes().get(j).getChildNodes().get(s).getTextContent()+"  ");
						System.out.println("");
						}
					
				}else{System.out.println(doc.getChildNodes().get(i).getChildNodes().get(j).getTextContent());}
				System.out.println("***********************************************");
			}
		}else{
			System.out.println(doc.getChildNodes().get(i).getTextContent());
		}
		System.out.println("-------------------------------------------------");
		}
		
	
	}

}
