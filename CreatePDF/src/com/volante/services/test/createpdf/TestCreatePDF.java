package com.volante.services.test.createpdf;

import javax.naming.NamingException;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;
import org.apache.camel.util.jndi.JndiContext;

import com.tplus.transform.runtime.log.LogFactory;
import com.tplus.transform.util.log.Log;
import com.volante.services.createpdf.CreatePDFFile;

public class TestCreatePDF extends RouteBuilder {
static Log log = LogFactory.getRuntimeLog(TestCreatePDF.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestCreatePDF tcp = new TestCreatePDF();
		JndiContext jndiCont;
			
		Main main = new Main();
		try {
			/*jndiCont = new JndiContext();
			jndiCont.bind("myBean", CreatePDFFile.class);
			CamelContext cc = new DefaultCamelContext(jndiCont);*/
			main.bind("myBean", CreatePDFFile.class);
			main.addRouteBuilder(tcp);
			main.start();
			main.run();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
System.out.println("inside configure");
		from("file://input").beanRef("myBean").to("bean:myBean");
	}

}
