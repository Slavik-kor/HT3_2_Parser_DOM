package edu.karotki.parser.ht3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DomParserSlv {
	public static final String TAG="(\\<(/?[^\\>]+)\\>)";
	public static final String BEGINTAG="(\\<[^/](/?[^\\>]+)\\>)";
	public static final String XMLTAG="(\\<[?xml][^/](/?[^\\>]+)[xml?]\\>)";
	
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
	//	System.out.println(s);
		return s;
	}
	
	private Node parseLevel(String text){
		Node node = new Node();
		node.setTextContent(text);
		int i=0; 
		Pattern p = Pattern.compile(BEGINTAG);
		Matcher m = p.matcher(text);
		
		do{
			int end=0;
			
			if (m.find()) {
				Pattern tagp=Pattern.compile(XMLTAG);
				Matcher tagm=tagp.matcher(m.group());
				if (tagm.find()){
				continue;
				}
				
				node.appendChild(new Node());
				node.getChildNodes().get(i).setTag(analizeTag(m.group()));
				end=text.indexOf("</"+analizeTag(m.group())+">",m.end());
				//System.out.println(end);
				int start=m.end();//text.indexOf(m.group())+m.group().length();
				//System.out.println(text.substring(start, end));
				node.getChildNodes().get(i).setTextContent(text.substring(start, end));
			
			if (node.getChildNodes().get(i).isNode()){
				String str=node.getChildNodes().get(i).getTextContent();
				node.getChildNodes().remove(i);
				node.appendChild(parseLevel(str));
			}	
			//text=text.substring(end+m.group().length());
			
			} else {break;}
			
			i++;
			//System.out.println(i);
		    
				
			
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
