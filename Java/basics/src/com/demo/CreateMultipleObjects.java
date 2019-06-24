package com.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name ="Emps")
//@XmlType(propOrder = {"_Name","_Age"})
public class CreateMultipleObjects {
	@XmlElement(name ="Emp")
	static private List<CreateMultipleObjects> createMultipleObjects = new ArrayList<CreateMultipleObjects>();
	static private CreateMultipleObjects createMultipleObject;

	private String _Name;
	
	public List<CreateMultipleObjects> getCreateMultipleObjects() {
		return createMultipleObjects;
	}
	
	public void setCreateMultipleObjects(List<CreateMultipleObjects> createMultipleObjects) {
		this.createMultipleObjects = createMultipleObjects;
	}
	
	public String get_Name() {
		return _Name;
	}
	
	public void set_Name(String _Name) {
		this._Name = _Name;
	}
	
	public int get_Age() {
		return _Age;
	}
	
	public void set_Age(int _Age) {
		this._Age = _Age;
	}

	private int _Age;

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, JAXBException {

		int age = 20;
		JAXBContext jaxbContext = JAXBContext.newInstance(com.demo.CreateMultipleObjects.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		for (int i = 0; i < 1000; i++) {
			createMultipleObject.setCreateMultipleObjects(createMultipleObjects);
/*			createMultipleObjects.add(new CreateMultipleObjects());
			createMultipleObject = createMultipleObjects.get(i);
*/			createMultipleObject.set_Name(String.valueOf(i));
			if (i % 10 != 0)
				createMultipleObject.set_Age(++age);
			else {
				age = 20;
				createMultipleObject.set_Age(age);
			}
			
			createMultipleObject.getCreateMultipleObjects().add(createMultipleObject);
		}
		marshaller.marshal(createMultipleObject, new File("./Output.xml"));
		
		
	}

	@Override
	public String toString() {
		return "Name = " + this._Name + " Age = " + this._Age ;
	}


}
