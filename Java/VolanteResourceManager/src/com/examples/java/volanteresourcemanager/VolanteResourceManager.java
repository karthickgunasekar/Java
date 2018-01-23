package com.examples.java.volanteresourcemanager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;

import javax.naming.NamingException;

import com.tplus.transform.runtime.TransformException;

public class VolanteResourceManager{
	public static void main(String[] args)
			throws ClassNotFoundException, NamingException, TransformException, RemoteException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		
//	Object str= Class.forName("com.transform.cartridge.resourcecart.ResourceCartresources").getMethod("getNew_Resource1").invoke(null);
		Class classObj = Class.forName("com.transform.cartridge.resourcecart.ResourceCartresources");		
		Method methodObj = classObj.getMethod("getstrListVal");
		Object str= methodObj.invoke(null);
		System.out.println(str.toString());

	}

}
