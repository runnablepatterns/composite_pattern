package com.runnablepatterns.compositepattern;

import java.util.Iterator;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class that implements iterable interface used to create array iterator
 * 
 */
public class ArrayIterator implements Iterator<MyDocumentComponent> {

	private MyDocumentComponent[] documents;
	private int position = 0;
	
	/**
	 * Overloaded constructor used to initialize array
	 * @param _documents
	 */
	public ArrayIterator(MyDocumentComponent[] _documents) {
		this.documents = _documents;
	}
	
	@Override
	public boolean hasNext() {
		// check if there are more items
		if(this.documents == null || this.documents.length == position || this.documents[position] == null) {
			return false;
		}
		
		return true;
	}

	@Override
	public MyDocumentComponent next() {
		// get the current document
		MyDocumentComponent document = this.documents[position];
		
		// move the index
		position++;
		
		// return document
		return document;
	}

	@Override
	public void remove() {
		// if this method is called before doing a next() throw exception
		if(position <= 0) {
			throw new IllegalStateException("You can't remove an item before calling next()");
		}
		
		// check if the item before current position is empty
		if(this.documents[position - 1] != null) {
			// iterate in the array starting from the previous position
			for(int i = position - 1; i < this.documents.length - 1; i++) {
				// replace all elements by moving one position before
				this.documents[i] = this.documents[i+1];
			}
			// set the last element empty
			this.documents[this.documents.length - 1] = null;
		}
	}
}
