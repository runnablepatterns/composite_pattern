package com.runnablepatterns.compositepattern;

import java.util.Iterator;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class to return a null or empty iterator. In this case for leaf documents
 * 
 */
public class NullIterator implements Iterator<MyDocumentComponent>{

	@Override
	public boolean hasNext() {
		// return false by default
		return false;
	}

	@Override
	public MyDocumentComponent next() {
		// return null
		return null;
	}

}
