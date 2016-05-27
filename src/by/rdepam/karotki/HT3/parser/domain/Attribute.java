package by.rdepam.karotki.HT3.parser.domain;

public class Attribute {
	private String key;
	private String value;
	
	public Attribute(String key, String value){
		this.key=key;
		this.value=value;
	}
	
	public String getValue(){
		return value;
	}
	
	public String getKey(){
		return key;
	}

	public void setValue(String value){
		this.value=value;
	}
	
	public void setKey(String key){
		this.key=key;
	}
}
