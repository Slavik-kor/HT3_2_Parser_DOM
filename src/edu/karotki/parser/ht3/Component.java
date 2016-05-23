package edu.karotki.parser.ht3;

import java.util.List;

public interface Component{
	
	List<Attribute> getAttributes();
	List<Component> getChildNodes();
	void appendChild(Component node);
	String getName();
	boolean hasAttributes();
	boolean hasChildNodes();
	String getTextContent();
	

}
