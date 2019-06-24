package com.demo;

import java.io.Closeable;
import java.io.Serializable;

public interface Consolable extends Serializable, Closeable {
	public void close1();
	public default void close2(){
		
	}

}
