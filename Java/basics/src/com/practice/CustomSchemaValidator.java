package com.practice;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class CustomSchemaValidator {

	static SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	static Schema schema = null;

	public void validate(OutputStream inputStream, String fileNm) throws SAXException, IOException {
		schema = schemaFactory.newSchema(new File(fileNm));
		Validator validator = schema.newValidator();
		validator.validate(new StreamSource(inputStream.toString()));

	}

}
