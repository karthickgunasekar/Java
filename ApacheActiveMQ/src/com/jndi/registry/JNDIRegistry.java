package com.jndi.registry;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIRegistry {

	public void registerJndi() {
		InitialContext ic;
		try {
			ic = new InitialContext();
			ConnectionFactory cf = (ConnectionFactory) ic.lookup("jms/connectionFactory");
			Connection c = cf.createConnection();
			Session s = c.createSession(false, 1);
			TextMessage tm = s.createTextMessage();
			tm.setText("hi");
			s.createProducer(c.create)
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
