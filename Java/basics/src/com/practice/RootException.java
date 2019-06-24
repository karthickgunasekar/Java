package com.practice;


import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="RootException")
public class RootException extends Exception implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static RootException rootExcep = null;
	static List<RootException> rootExcepColl = null;
	

	String Messages;
	String ErrorCode;
	String Severity;
	boolean Cascadable;
	String FieldName;
	String FieldId;
	String StackTraces;

	private RootException() {
	}

	public static RootException getOrCreateRootException() {
		if (rootExcep == null) {
			rootExcep = new RootException();
		}
		return rootExcep;
	}

	public void setCollRootException(RootException rootExpection) {
		rootExcepColl.add(rootExpection);
	}

	public List<RootException> getCollRootException() {
		return rootExcepColl;
	}

	public RootException getRootException() {
		return rootExcep;
	}

	@XmlElement
	public String getMessages() {
		return Messages;
	}

	public void setMessages(String messages) {
		this.Messages = messages;
	}
	@XmlElement
	public String getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(String errorCode) {
		this.ErrorCode = errorCode;
	}
	@XmlElement
	public String getSeverity() {
		return Severity;
	}

	public void setSeverity(String severity) {
		this.Severity = severity;
	}
	@XmlElement
	public boolean isCascadable() {
		return Cascadable;
	}

	public void setCascadable(boolean cascadable) {
		this.Cascadable = cascadable;
	}
	@XmlElement
	public String getFieldName() {
		return FieldName;
	}

	public void setFieldName(String fieldName) {
		this.FieldName = fieldName;
	}
	@XmlElement
	public String getFieldId() {
		return FieldId;
	}

	public void setFieldId(String fieldId) {
		this.FieldId = fieldId;
	}
	@XmlElement
	public String getStackTraces() {
		return StackTraces;
	}

	public void setStackTraces(String stackTraces) {
		this.StackTraces = stackTraces;
	}

	
}
