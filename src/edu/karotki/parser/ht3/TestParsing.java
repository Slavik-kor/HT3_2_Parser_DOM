package edu.karotki.parser.ht3;

import java.io.File;

public class TestParsing {

	public static void main(String[] args) {
	    DomParserSlv parser=new DomParserSlv();
	    Node doc=parser.parse(new File("menu.xml"));
	  
	}

}
