package edu.karotki.parser.ht3;

import java.util.ArrayList;

public class Node {
	
	private ArrayList<Node> childs= new ArrayList<Node>();
	private ArrayList<Attribute> attributes= new ArrayList<Attribute>();
	private String tag;
	private String text;
	
	public void appendChild(Node newChild){
		childs.add(newChild);
	}
	
	public ArrayList<Attribute> getAttributes(){
		return attributes;
	}
	
	public ArrayList<Node> getChildNodes(){
		return childs;
	}
	
	public String getTextContent(){
		return text;
	}
	
	public void setTextContent(String text){
		this.text=text;
	}
	
	public String getTag(){
		return tag;
	}
	
	public void setTag(String tag){
		this.tag=tag;
	}
	
	public boolean isNode(){
		if (childs.isEmpty()) { return false;}
		return true;
	}

}
