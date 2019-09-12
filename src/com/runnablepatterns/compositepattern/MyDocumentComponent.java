package com.runnablepatterns.compositepattern;

import java.util.Iterator;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class to store document components.
 */
public abstract class MyDocumentComponent implements MyDocumentAggregate{

	/**
	 * Add a new child component to the current element.
	 * @param documentComponent.
	 * @throws UnsupportedOperationException when this method does not apply to the element.
	 */
	public void add(MyDocumentComponent documentComponent) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Add several childs component to the current element
	 * @param iterator.
	 * @throws UnsupportedOperationException when this method does not apply to the element.
	 */
	public void add(Iterator<MyDocumentComponent> iterator) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Remove a child component from the current element.
	 * @param documentComponent
	 * @throws UnsupportedOperationException when this method does not apply to the element
	 */
	public void remove(MyDocumentComponent documentComponent) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Get the specific child component from the current element.
	 * @param _index
	 * @return The specific child of this component
	 * @throws UnsupportedOperationException when this method does not apply to the element.
	 */
	public MyDocumentComponent getChild(int _index) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @return the name.
	 * @throws UnsupportedOperationException when this method does not apply to the element
	 */
	public String getName() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @return the type.
	 * @throws UnsupportedOperationException when this method does not apply to the element.
	 */
	public String getType() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @return the data.
	 * @throws UnsupportedOperationException when this method does not apply to the element.
	 */
	public byte[] getData() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Save the component information
	 * @throws UnsupportedOperationException when this method does not apply to the element
	 */
	public void save() {
		throw new UnsupportedOperationException();
	}
}
