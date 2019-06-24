package com.volante;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseXMLAsDOM {

	public static FileInputStream fis = null;
	public static FileOutputStream fos = null;
	public static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	public static DocumentBuilder db = null;
	public static Document doc = null;
	public static Element elm = null;
	public static NodeList nl = null;
	public static TransformerFactory transFac = TransformerFactory.newInstance();
	public static Transformer trans = null;
	public static DOMSource domSrc = null;
	public static StreamResult result = null;
	public static boolean non_jndi = false;

	public static boolean getOrSetUNmAndPass(Document doc, String nodeName, String uNm, String pass) {
		elm = doc.getDocumentElement();
		if (elm != null) {
			nl = elm.getChildNodes();
			int i = 0;
			while (i < nl.getLength()) {
				Node nd = nl.item(i);
				if (nd.getNodeName().equals(nodeName)) {
					if (nd.getAttributes().getNamedItem("username") != null) {
						nd.getAttributes().getNamedItem("username").setNodeValue(uNm);
						non_jndi = true;
					}
					if (nd.getAttributes().getNamedItem("password") != null) {
						nd.getAttributes().getNamedItem("password").setNodeValue(pass);
						non_jndi = true;
					}
				}
				i++;
			}
		}
		return non_jndi;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			trans = transFac.newTransformer();
			trans.setOutputProperty(OutputKeys.INDENT, "yes");
			transFac.setAttribute("indent-number", new Integer(2));
			db = dbf.newDocumentBuilder();
			if (args.length > 2) {
				File f = new File(args[0]);
				String dbValue = "";
				for (String dirName : f.list()) {
					if (dirName != null && dirName.startsWith("_")) {
						dbValue = dirName;
						break;
					}
				}
				f = new File(f.getAbsolutePath() + File.separator + dbValue);
				if (f.isDirectory()) {
					fis = new FileInputStream(f.getAbsolutePath() + File.separator + dbValue
							+ "/VolPayHubRT/Config/Common/VolPayConfig/data-sources.xml");
					if (fis != null) {
						doc = db.parse(fis);
						fis.close();
					}
					non_jndi = getOrSetUNmAndPass(doc, "data-source", args[1], args[2]);
					if (non_jndi) {
						domSrc = new DOMSource(doc);
						fos = new FileOutputStream(f.getAbsolutePath() + File.separator + dbValue
								+ "/VolPayHubRT/Config/Common/VolPayConfig/data-sources.xml");
						result = new StreamResult(fos);
						trans.transform(domSrc, result);
					} else {
						fis = new FileInputStream(
								f.getAbsolutePath() + File.separator + dbValue + "/apache-tomcat/conf/context.xml");
						if (fis != null) {
							doc = db.parse(fis);
							fis.close();
						}
						non_jndi = getOrSetUNmAndPass(doc, "Resource", args[1], args[2]);
						domSrc = new DOMSource(doc);
						fos = new FileOutputStream(
								f.getAbsolutePath() + File.separator + dbValue + "/apache-tomcat/conf/context.xml");
						result = new StreamResult(fos);
						trans.transform(domSrc, result);
					}
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
