package edu.karotki.parser.ht3;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DomParserSlv {
	
	public Node parse(File file){
		String str=readFile(file);				
		return parseLevel(str);
	}
	
	private String readFile(File file){
		String s="";
		try{
			Scanner sc= new Scanner(file);
			while(sc.hasNext()){
				s=s+sc.nextLine().trim();			
			}
			sc.close();			
		}
		catch(Exception e){e.printStackTrace();}
		return s;
	}
	
	private Node parseLevel(String text){
		Node node = new Node();
		node.setTextContent(text);
		int i=0; 
		Pattern p=null; String tag=new String("");
		Matcher m=null; 
		do{
			
	   if (i==0) {p = Pattern.compile("<(\"[^\"]*\"|'[^']*'|[^'\">])*>");
	   } else {
		   p=Pattern.compile("<"+tag+"(\"[^\"]*\"|'[^']*'|[^'\">])*>");
	   }
		
		    m = p.matcher(text);
		
		if(m.find()){
		
			node.appendChild(new Node());
			String str=m.group(); int beginIndex=text.indexOf(str);
			node.getChildNodes().get(i).setTag(analizeTag(str));//   извлекаем имя тега и присваиваем 
			
			tag=node.getChildNodes().get(i).getTag(); //присваиваем имя тега промежуточной переменной
			String textContent=text.substring(beginIndex);// обрезка текста
			int endIndex=textContent.indexOf("<"+tag+"/>");
			textContent=textContent.substring(0+str.length(), endIndex-1);
			node.getChildNodes().get(i).setTextContent(textContent);
			text=text.substring(endIndex+tag.length()+2);	
			if (node.getChildNodes().get(i).isNode()) {node.getChildNodes().get(i);}
		}
		
		i++;
		}while(!text.isEmpty());		
		return node;
	}
	
	private String analizeTag(String text){
		int endIndex=0;
		for(int i=1;i<text.length();i++){
			if ((text.charAt(i)==' ')||(text.charAt(i)=='>')){
				endIndex=i-1;
			}
		}
		text.substring(1, endIndex);
		return text;
	}
	
}
