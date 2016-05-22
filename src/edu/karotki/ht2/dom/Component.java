package edu.karotki.ht2.dom;

import java.util.List;

public interface Component {
	
	List<Attribute> getListAttributes();
	List<Component> getListChildNodes();
	

}
