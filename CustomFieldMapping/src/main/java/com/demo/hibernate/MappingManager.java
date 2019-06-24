package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.Property;
import org.hibernate.type.Type;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

public class MappingManager {
	public static void updateClassMapping(CustomizableEntityManager entityManager) {
		try {
			Session session = HibernateUtil.getInstance().getCurrentSession();
			Class<? extends CustomizableEntity> entityClass = entityManager.getEntityClass();
			String file = entityClass.getResource(entityClass.getSimpleName() + ".hbm.xml").getPath();
			FileInputStream fis = new FileInputStream(file);
			byte b[] = new byte[fis.available()];
			fis.read(b, 0, b.length);
			DocumentBuilderFactory documentbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentb = documentbf.newDocumentBuilder();
			Document document = documentb.parse(fis);

			XMLUtil.loadDocument(file);
			NodeList componentTags = document.getElementsByTagName("dynamic-component");
			Node node = componentTags.item(0);
			XMLUtil.removeChildren(node);

			Iterator propertyIterator = entityManager.getCustomProperties().getPropertyIterator();
			while (propertyIterator.hasNext()) {
				Property property = (Property) propertyIterator.next();
				Element element = createPropertyElement(document, property);
				node.appendChild(element);
			}
            XMLUtil.saveDocument(document, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Element createPropertyElement(Document document, Property property) {
		Element element = document.createElement("property");
		Type type = property.getType();

		element.setAttribute("name", property.getName());
		element.setAttribute("column", ((Column) property.getColumnIterator().next()).getName());
		element.setAttribute("type", type.getReturnedClass().getName());
		element.setAttribute("not-null", String.valueOf(false));

		return element;
	}
}