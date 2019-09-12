package com.runnablepatterns.compositepattern;

import java.util.HashMap;
import java.util.Iterator;

public class ClientC implements MyDocumentAggregate {

	/**
	 * Variable to store XML files
	 */
	private HashMap<String, MyDocumentComponent> documents;
	
	/**
	 * Default constructor used to fill the hash map
	 */
	public ClientC() {
		this.documents = new HashMap<>();
		
		// create the specific paths
		MyPath pathA = new MyPath("pathA");
		MyPath pathB = new MyPath("pathB");
		MyPath pathC = new MyPath("pathC");
		
		// add the files under specific paths
		pathA.add(new MyDocument("XMLA.xml", "XML"));
		pathA.add(new MyDocument("XMLA2.xml", "XML"));
		pathB.add(new MyDocument("XMLB.xml", "XML"));
		pathB.add(new MyDocument("XMLB2.xml", "XML"));
		pathC.add(new MyDocument("XMLC.xml", "XML"));
		pathC.add(new MyDocument("XMLC2.xml", "XML"));
		pathC.add(new MyDocument("XMLC3.xml", "XML"));
		
		// add the paths to the hash
		this.documents.put("pathA", pathA);
		this.documents.put("pathB", pathB);
		this.documents.put("pathC", pathC);
	}
	
	@Override
	public Iterator<MyDocumentComponent> createIterator() {
		// get the specific iterator for array
		return this.documents.values().iterator();
	}

}
