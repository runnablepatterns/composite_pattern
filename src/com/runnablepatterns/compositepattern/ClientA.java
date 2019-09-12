package com.runnablepatterns.compositepattern;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class to handle ClientA request to save documents.
 * 
 */
public class ClientA implements MyDocumentAggregate {
	
	/**
	 * Variable to store all photos
	 */
	private ArrayList<MyDocumentComponent> documents = new ArrayList<>();
	
	/**
	 * Default constructor used to fill the array list
	 */
	public ClientA() {
		this.documents.add(new MyDocument("PhotoA.png", "PNG"));
		this.documents.add(new MyDocument("PhotoB.png", "PNG"));
		this.documents.add(new MyDocument("PhotoC.png", "PNG"));
	}

	@Override
	public Iterator<MyDocumentComponent> createIterator() {
		// get the specific iterator for array list
		return this.documents.iterator();
	}

}
