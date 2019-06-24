package com.volante;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.ibm.mq.MQException;
import com.ibm.mq.jms.MQQueueConnectionFactory;
public abstract class MsgPutMQ {
	static MQQueueConnectionFactory conFac = new MQQueueConnectionFactory();

	public static void main(String[] args) throws JMSException, MQException, IOException {
		conFac.setHostName(args[0]);
		conFac.setPort(Integer.parseInt(args[1]));
		conFac.setTransportType(1);
		conFac.setChannel(args[2]);
		Connection con = conFac.createQueueConnection();
		con.start();
	
		 /* UserCredentialsConnectionFactoryAdapter connectionFactoryAdapter=new
		  UserCredentialsConnectionFactoryAdapter();
		  connectionFactoryAdapter.setUsername("mqm");
		  connectionFactoryAdapter.setPassword("mqm");*/
		 
		 
		Session ses = con.createSession(Session.CLIENT_ACKNOWLEDGE);
		//	com.ibm.mq.jms.MQQueue mq = new com.ibm.mq.jms.MQQueue("");
		
		Destination des =ses.createQueue("queue:///"+"BL.ESB.PSD2.GET.BALANCES.REPLY");
		
		MessageProducer mp = ses.createProducer(des);
	
		TextMessage tm = ses.createTextMessage();
		FileInputStream bais = new FileInputStream(args[4]);
		
		tm.setJMSCorrelationID(args[3]);
		int n = bais.available();
		byte[] bytes = new byte[n];
		bais.read(bytes, 0, n);
		String s = new String(bytes);
		System.out.println(s);
		tm.setText(s);
		
		mp.send(tm);
		mp.close();
		con.close();
		
/*		mp.send(tm);
		mp.close();
		ses.commit();
		ses.close();*/

//		con.stop();
//		con.close();
		
		 /* conFac.setHostName("10.0.3.122"); conFac.setPort(1414);
		  conFac.setTransportType(1); conFac.setChannel("VolPayTxnMgrChannel");
		  MQQueueManager mqQueueManager = new MQQueueManager("VOLPAY_BL"); 
		  com.ibm.mq.jms.MQQueue mq = new com.ibm.mq.jms.MQQueue("BL.ESB.PSD2.GET.BALANCES.REPLY");
		  mq.put(, arg1)*/
		 
	}

}
