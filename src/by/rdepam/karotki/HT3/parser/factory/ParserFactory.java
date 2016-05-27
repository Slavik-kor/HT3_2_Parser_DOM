package by.rdepam.karotki.HT3.parser.factory;

import java.io.File;

import by.rdepam.karotki.HT3.parser.domain.Node;
import by.rdepam.karotki.HT3.parser.service.DomParserSlv;

public class ParserFactory {
	private static final ParserFactory factory= new ParserFactory();
	
	private ParserFactory(){
	}
	
	public static ParserFactory newInstance(){
		return factory;
	};
	
	public static Node newNodeBuilder(File file){
		DomParserSlv pars = new DomParserSlv();
		return pars.parse(file);
	};
	

}
