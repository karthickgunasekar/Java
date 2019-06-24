package com.spring.core.examples;

public class XMLBeanInitialization {
	
	public String colorName;
	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public ColorEmun getColorEmun() {
		return colorEmun;
	}

	public void setColorEmun(ColorEmun colorEmun) {
		this.colorEmun = colorEmun;
	}

	public ColorRandomizer getColorRandomizer() {
		return colorRandomizer;
	}

	public void setColorRandomizer(ColorRandomizer colorRandomizer) {
		this.colorRandomizer = colorRandomizer;
	}

	public ColorEmun colorEmun;
	public ColorRandomizer colorRandomizer;

/*	public XMLBeanInitialization(){
		System.out.println("default constructor of XMLBeanInitialization");
	}*/
	
	public XMLBeanInitialization(String colorNm,ColorEmun colorEmun){
		this.colorName = colorNm;
		this.colorEmun = colorEmun;
	}
	
	public void display(){
		System.out.println("display func can be accessed by spring bean");
	}
}
