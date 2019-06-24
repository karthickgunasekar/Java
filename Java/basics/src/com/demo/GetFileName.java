package com.demo;

import java.util.Set;

import com.tplus.transform.runtime.RawMessage;
import com.tplus.transform.runtime.TransformContext;
import com.tplus.transform.runtime.TransformException;
import com.tplus.transform.runtime.handler.IInvokable;
import com.tplus.transform.runtime.log.LogFactory;
import com.tplus.transform.util.log.Log;

public class GetFileName implements IInvokable {

	static Log log = LogFactory.getRuntimeLog(GetFileName.class.getSimpleName());

	@Override
	public Object run(Object[] arg0, TransformContext arg1) throws TransformException {
		// TODO Auto-generated method stub
		RawMessage rawIn = null;
		if(arg0.length>0){			
			rawIn = (RawMessage) arg0[0];
			//rawIn.getPropertyNames();
			arg1.clear();
		}
		return rawIn.getProperty("file.name","1.txt").toString();
	}

}
