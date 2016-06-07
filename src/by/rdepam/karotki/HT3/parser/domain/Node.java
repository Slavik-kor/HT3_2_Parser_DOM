package by.rdepam.karotki.HT3.parser.domain;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Node {
	private static final String TAG = "(\\<(/?[^\\>]+)\\>)";
	private ArrayList<Node> childs = new ArrayList<Node>();
	private ArrayList<Attribute> attributes = new ArrayList<Attribute>();
	private String tag;
	private String text;

	public ArrayList<Node> getChildNodes() {
		return childs;
	}

	public void appendChild(Node newChild) {
		childs.add(newChild);
	}

	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttribute(Attribute attr) {
		attributes.add(attr);
	}

	public String getTextContent() {
		return text;
	}

	public void setTextContent(String text) {
		this.text = text;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isNode() {
		Pattern p = Pattern.compile(TAG);
		Matcher m = p.matcher(text);
		int i = 0;
		while (m.find()) {
			i++;
		}
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + ((childs == null) ? 0 : childs.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (childs == null) {
			if (other.childs != null)
				return false;
		} else if (!childs.equals(other.childs))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [childs=" + childs + ", attributes=" + attributes + ", tag=" + tag + ", text=" + text + "]";
	}

}
