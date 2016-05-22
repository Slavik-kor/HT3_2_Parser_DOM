package edu.karotki.ht2.dom;

import java.io.File;

import org.w3c.dom.Document;

public class DomParser {
	
	
	public Document parse(File file){
		return new Document(){
			public List<Component> getListChildNodesByName(String name){
				return new ArrayList<Component>();
			}
		};
	}

}
