package edu.karotki.parser.ht3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DomParserSlv {
	
	private String readFile(File file){
		String s="";
		try{
			Scanner sc= new Scanner(file);
			while(sc.hasNext()){
				s=s+sc.nextLine();			
			}
			sc.close();			
		}
		catch(Exception e){e.printStackTrace();}
		return s;
	}
	
/**	public Document parse(File file){
		String str=readFile(file);
		
	    Pattern p = Pattern.compile("<(\"[^\"]*\"|'[^']*'|[^'\">])*>");
	    Matcher m = p.matcher(str);
	    
	    while (m.find()){
	    }
				
		return new Document(){
			ArrayList<Component> node= new ArrayList<component>();
			
			public List<Attribute> getAttributes(){
				
			};
			public List<Component> getChildNodes(){};
			public void appendChild(Component node){};
			public String getName(){};
			public boolean hasAttributes(){};
			public boolean hasChildNodes(){};
			public String getTextContent(){ };
		};
	}**/

}
