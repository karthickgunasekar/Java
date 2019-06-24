package com.demo;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JndiExampleClass {

	public static void main(String[] args) {
		try {
			Hashtable<String,Object> env = new Hashtable<String,Object
					>();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.PROVIDER_URL, "ldap://10.0.3.128:389");
			env.put(Context.SECURITY_PRINCIPAL, "colpatria");
			env.put(Context.SECURITY_CREDENTIALS, "colpatria");
			
			Context myObj = new InitialContext(env);
			myObj.lookup("MyObject");
			myObj.bind("MyObject", myObj);
			myObj.close();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
