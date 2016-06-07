package by.rdepam.karotki.HT3.parser.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.rdepam.karotki.HT3.parser.domain.Node;

public class DomParserSlv {
	public static final String TAG = "(\\<(/?[^\\>]+)\\>)";
	public static final String BEGINTAG = "(\\<[^/](/?[^\\>]+)\\>)";
	public static final String XMLTAG = "(\\<[?xml][^/](/?[^\\>]+)[xml?]\\>)";

	public Node parse(File file) {
		String str = readFile(file);
		Node node = new Node();
		Pattern p = Pattern.compile(BEGINTAG);
		Matcher m = p.matcher(str);
		int end = 0;

		while (m.find(end)) {
			Pattern tagp = Pattern.compile(XMLTAG);
			Matcher tagm = tagp.matcher(m.group());
			if (tagm.find()) {
				end = tagm.end();
				continue;
			}

			String t = getTagName(m.group());
			int start = m.end();
			end = str.indexOf("</" + t + ">", start);
			node.setTag(t);
			node.setTextContent(str.substring(start, end));

			if (node.isNode()) {
				node = parseLevel(node);
			}
		}
		return node;
	}

	private String readFile(File file) {
		String s = "";
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String k;
			while ((k = in.readLine()) != null) {
				s = s + k.trim();
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	private Node parseLevel(Node node) {
		String text = node.getTextContent();
		Pattern p = Pattern.compile(BEGINTAG);
		Matcher m = p.matcher(text);
		int end = 0;

		while (m.find(end)) {

			String t = getTagName(m.group());
			int start = m.end();
			end = text.indexOf("</" + t + ">", start);
			Node nodeChild = new Node();
			nodeChild.setTag(t);
			nodeChild.setTextContent(text.substring(start, end));
			if (nodeChild.isNode()) {
				nodeChild = parseLevel(nodeChild);
			}
			node.appendChild(nodeChild);

		}

		return node;
	}

	private String getTagName(String text) {
		int endIndex = text.length();
		for (int i = 0; i < text.length(); i++) {
			if ((text.charAt(i) == ' ') || (text.charAt(i) == '>')) {
				endIndex = i - 1;
				break;
			}
		}
		return text.substring(1, endIndex + 1);
	}

}
