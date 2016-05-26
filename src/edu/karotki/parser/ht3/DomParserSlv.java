package edu.karotki.parser.ht3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DomParserSlv {
	public static final String BEGINTAG="(\\<(/?[^\\>]+)\\>)";
	public static final String ENDTAG="(\\<[^/](/?[^\\>]+)\\>)";
	
	public Node parse(File file){
		String str=readFile(file);				
		return parseLevel(str);
	}
	
	private String readFile(File file){
		String s="";
		try{
			BufferedReader in=new BufferedReader(new FileReader(file));
			String k;		
			while((k=in.readLine())!=null){
				s=s+k.trim();			
			}
			in.close();		
		}
		catch(Exception e){e.printStackTrace();}
		System.out.println(s);
		return s;
	}
	
	private Node parseLevel(String text){
		Node node = new Node();
		node.setTextContent(text);
		int i=0; 
	//	 String tag=new String("");
		Pattern p = Pattern.compile(BEGINTAG);
		Matcher m = p.matcher(text);
		if ((m.find())) {
			System.out.println(analizeTag(m.group()));
		}
		do{
			
			if (m.find()) {
				node.appendChild(new Node());
				node.getChildNodes().get(i).setTag(analizeTag(m.group()));
				int end=text.indexOf("</"+analizeTag(m.group())+">");
				int start=text.indexOf(m.group())+m.group().length();
				node.getChildNodes().get(i).setTextContent(text.substring(start, end));
			}
			if (node.getChildNodes().get(i).isNode()){ }
		    i++;
				
			
		}while(!text.isEmpty());		
		return node;
	}
	
	private String analizeTag(String text){
		int endIndex=text.length();
		for(int i=0;i<text.length();i++){
			if ((text.charAt(i)==' ')||(text.charAt(i)=='>')){
				endIndex=i-1; break;
			}
			
		}
		return text.substring(1, endIndex+1);
		
	}
	
}
