package by.rdepam.karotki.HT3.parser.factory;

import by.rdepam.karotki.HT3.parser.service.DomParserSlv;

public class ParserFactory {
	private static final ParserFactory factory = new ParserFactory();

	private ParserFactory() {
		super();
	}

	public static ParserFactory newInstance() {
		return factory;
	};

	public DomParserSlv newNodeBuilder() {
		return new DomParserSlv();
	};

}
