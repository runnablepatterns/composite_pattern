package com.runnablepatterns.compositepattern;

import java.util.Iterator;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class to handle ClientB request to save documents.
 * 
 */
public class ClientB implements MyDocumentAggregate {

	private MyDocumentComponent[] documents;
	private final int MAX_DOCUMENTS = 3;
	
	/**
	 * Default constructor used to fill the array
	 */
	public ClientB() {
		this.documents = new MyDocumentComponent[MAX_DOCUMENTS];
		this.documents[0] = new MyDocument("FileA.pdf", "PDF");
		this.documents[1] = new MyDocument("FileB.pdf", "PDF");
		this.documents[2] = new MyDocument("FileC.pdf", "PDF");
	}
	
	@Override
	public Iterator<MyDocumentComponent> createIterator() {
		// get the specific iterator for array
		return new ArrayIterator(this.documents);
	}

}
