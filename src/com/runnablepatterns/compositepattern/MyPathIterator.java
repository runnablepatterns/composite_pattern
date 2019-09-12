package com.runnablepatterns.compositepattern;

import java.util.Iterator;
import java.util.Stack;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class to return an iterator using all available paths
 * 
 */
public class MyPathIterator implements Iterator<MyDocumentComponent> {

	/**
	 * Variable used to keep track of the current elements and its order
	 */
	private Stack<Iterator<MyDocumentComponent>> items = new Stack();
	
	/**
	 * Overloaded constructor to initialize the internal structure used to handle the items
	 * @param iterator
	 */
	public MyPathIterator(Iterator<MyDocumentComponent> iterator) {
		this.items.push(iterator);
	}
	
	@Override
	public boolean hasNext() {
		// if the stack is empty
		if(this.items.empty()) {
			return false;
		}
		else {
			// get next element to check
			Iterator<MyDocumentComponent> iterator = this.items.peek();
			
			// if there are pending items
			if(iterator.hasNext()) {
				return true;
			}
			else {
				// remove an element from the main structure
				this.items.pop();
				
				// check more more items
				return hasNext();
			}
		}
	}

	@Override
	public MyDocumentComponent next() {
		// check if there are more elements
		if(hasNext()) {
			// get the next element stored in the stack
			Iterator<MyDocumentComponent> iterator = items.peek();
			
			// get the internal element 
			MyDocumentComponent item = iterator.next();
			// if the element is a path
			if(item instanceof MyPath) {
				// add it to the main stack for a future check
				this.items.push(item.createIterator());
			}
			
			// return current item
			return item;
		}
		else {
			// return null if there are no more elements
			return null;
		}
	}

}
