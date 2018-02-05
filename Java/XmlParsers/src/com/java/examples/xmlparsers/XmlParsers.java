package com.java.examples.xmlparsers;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.tplus.transform.runtime.RawMessage;
import com.tplus.transform.runtime.TransformException;
import com.tplus.transform.runtime.formula.MessageFunctions;

public class XmlParsers {

	static DocumentBuilderFactory documentBuilderFactory = null;
	static DocumentBuilder documentBuilder = null;
	static Document document = null;

	static String tagValue = "";
	static String tagFldValue = "";
	static String retValue = "";

	public static void subElem(int itemIdx, NodeList nodeLst) {
		itemIdx = 0;
		do {
			Node node = nodeLst.item(itemIdx);
			if (itemIdx != 0) {
				retValue = retValue.concat("\r\n");
			}
			tagFldValue = node.getNodeName().trim();
			if (tagFldValue != null && tagFldValue.length() > 0 && tagFldValue != "#text") {
				retValue = retValue.concat(tagFldValue);
				retValue = retValue.concat(" : ");

				tagValue = node.getTextContent().trim();
				if (tagValue != null && tagValue.length() > 0) {
					retValue = retValue.concat(tagValue);
				}
			}
			itemIdx++;
		} while (nodeLst.getLength() > itemIdx);
	}

	public static String fieldNmVal(RawMessage fldValue)
			throws ParserConfigurationException, IOException, SAXException, TransformException {

		documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilder = documentBuilderFactory.newDocumentBuilder();
		document = documentBuilder.parse(fldValue.getAsStream());
		document.normalizeDocument();
		NodeList nodeList = document.getDocumentElement().getChildNodes();

		NodeList nodeSubList = null;

		Node node = null;
		int itemIdx = 0;
		boolean flag = false;
		do {
			node = nodeList.item(itemIdx);

			node.normalize();

			if (itemIdx != 0) {
				retValue = retValue.concat("\r\n");
			}
			tagFldValue = node.getNodeName().trim();
			if (tagFldValue != null && tagFldValue.length() > 0 && tagFldValue != "#text") {
				retValue = retValue.concat(tagFldValue);
				retValue = retValue.concat(" : ");

				tagValue = node.getTextContent().trim();
				if (tagValue != null && tagValue.length() > 0) {
					retValue = retValue.concat(tagValue);
				}
			}

			if (nodeList.item(itemIdx).hasChildNodes()) {
				NodeList subNodeLst = nodeList.item(itemIdx).getChildNodes();
				subElem(itemIdx, subNodeLst);

			}

			itemIdx++;

		} while (nodeList.getLength() > itemIdx);
		//System.out.println(retValue);

		return retValue;
	}

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, TransformException {
		// TODO Auto-generated method stub
		RawMessage raw = MessageFunctions.newMessage();
		raw.append(args[0].getBytes());
		fieldNmVal(raw);

	}

}
