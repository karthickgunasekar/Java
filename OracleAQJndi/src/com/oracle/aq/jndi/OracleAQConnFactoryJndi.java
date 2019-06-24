package com.oracle.aq.jndi;

import java.util.Hashtable;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.sql.DataSource;

import org.apache.naming.NamingContext;

import oracle.jms.AQjmsConnection;
import oracle.jms.AQjmsConnectionFactory;
import oracle.jms.AQjmsConstants;
import oracle.jms.AQjmsError;
import oracle.jms.AQjmsOracleDebug;
import oracle.jms.AQjmsQueueConnectionFactory;

public class OracleAQConnFactoryJndi extends AQjmsConnectionFactory {
	String hostname;
	String oracle_sid;
	int portno;
	String jdbc_driver;
	String jdbc_conn_str;
	String user;
	String passwd;
	String classname;
	Properties jdbc_info;
	DataSource data_source;
	// boolean compliant = AQjmsConstants.IS_COMPLIANT;
	static final String HOST_ATTR = "host";
	static final String PORT_ATTR = "port";
	static final String SID_ATTR = "sid";
	static final String JDBC_CNN_ATTR = "jdbc_connect_string";
	static final String JDBC_DRV_ATTR = "driver";
	static final String USER_NAM_ATTR = "username";
	static final String PASSWORD_ATTR = "password";

	OracleAQConnFactoryJndi(String hostname, String oracle_sid, int portno, String jdbc_driver) {
		try {
			Connection conn = createConnection();
			conn.start();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Object getObjectInstance(Object paramObject, Name paramName, Context paramContext,
			Hashtable paramHashtable) {

		Reference localReference = (Reference) paramObject;

		AQjmsOracleDebug.setTraceLevel(AQjmsOracleDebug.AQ_ORA_TR4);

		if (localReference == null) {
			AQjmsOracleDebug.setTraceLevel(AQjmsOracleDebug.AQ_ORA_TR3);

			return null;
		}

		this.classname = localReference.getClassName();
		if ((!this.classname.equals("oracle.jms.AQjmsQueueConnectionFactory"))
				&& (!this.classname.equals("oracle.jms.AQjmsTopicConnectionFactory"))
				&& (!this.classname.equals("oracle.jms.AQjmsConnectionFactory"))
				&& (!this.classname.equals("oracle.jms.AQjmsXAQueueConnectionFactory"))
				&& (!this.classname.equals("oracle.jms.AQjmsXATopicConnectionFactory"))
				&& (!this.classname.equals("oracle.jms.AQjmsXAConnectionFactory"))) {
			AQjmsOracleDebug.setTraceLevel(AQjmsOracleDebug.AQ_ORA_TR3);

			return null;
		}

		Object localObject = null;
		/*
		 * SearchControls localSearchControls = new SearchControls(); String[]
		 * arrayOfString = { "orclDBAQGeneric" };
		 * 
		 * localSearchControls.setSearchScope(0);
		 * localSearchControls.setReturningAttributes(arrayOfString);
		 */
		NamingContext localDirContext = (NamingContext) paramContext;
		// NamingEnumeration localNamingEnumeration = localDirContext.search(paramName,
		// "(objectclass=*)", localSearchControls);

		// if (localNamingEnumeration != null) {
		/*
		 * SearchResult localSearchResult = (SearchResult)localNamingEnumeration.next();
		 * Attribute localAttribute =
		 * localSearchResult.getAttributes().get("orclDBAQGeneric");
		 */

		/*
		 * for (int i = 0; i < localAttribute.size(); i++) { String str =
		 * (String)localAttribute.get(i);
		 * 
		 * if (str.toLowerCase().startsWith("host")) { this.hostname =
		 * str.substring("host".length() + 1); } else if
		 * (str.toLowerCase().startsWith("port")) { this.portno =
		 * Integer.valueOf(str.substring("port".length() + 1)).intValue(); } else if
		 * (str.toLowerCase().startsWith("sid")) { this.oracle_sid =
		 * str.substring("sid".length() + 1); } else if
		 * (str.toLowerCase().startsWith("jdbc_connect_string")) { this.jdbc_conn_str =
		 * str.substring("jdbc_connect_string".length() + 1); } else if
		 * (str.toLowerCase().startsWith("driver")) { this.jdbc_driver =
		 * str.substring("driver".length() + 1); } else if
		 * (str.toLowerCase().startsWith("username")) { this.user =
		 * str.substring("username".length() + 1); } else if
		 * (str.toLowerCase().startsWith("password")) { this.passwd =
		 * str.substring("password".length() + 1); } }
		 */

		if (this.classname.equals("com.oracle.aq.jndi.OracleAQConnFactoryJndi")) {

			localObject = new OracleAQConnFactoryJndi(this.hostname, this.oracle_sid, this.portno, this.jdbc_driver);

		}
		// }

		AQjmsOracleDebug.setTraceLevel(AQjmsOracleDebug.AQ_ORA_TR4);

		return localObject;
	}

}
