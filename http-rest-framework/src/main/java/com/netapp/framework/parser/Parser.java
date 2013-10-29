package com.netapp.framework.parser;

import java.io.InputStream;


public interface Parser<K> {
	public K parseData(InputStream is) throws Exception;
}
