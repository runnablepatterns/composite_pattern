package com.runnablepatterns.compositepattern;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class to store a path the may contain documents or additional paths.
 * It extends MyDocumentComponent so it can be used without knowing if it is a Node or a Leaf.
 */
public class MyPath extends MyDocumentComponent{

	/**
	 * Variable to store all childrens for this Node
	 */
	private ArrayList<MyDocumentComponent> documentsComponent = new ArrayList();
	
	/**
	 * Variable to store current path
	 */
	private String name;
	
	/**
	 * Overloaded constructor used to create this Component with the path name
	 * @param _name The current path
	 */
	public MyPath(String _name) {
		setName(_name);
	}
	
	/**
	 * Add a new child component (file) to the current path.
	 * @param documentComponent.
	 */
	public void add(MyDocumentComponent documentComponent) {
		this.documentsComponent.add(documentComponent);
	}
	
	/**
	 * Add several child components (files) to the current path.
	 * @param documentComponent.
	 */
	public void add(Iterator<MyDocumentComponent> iterator) {
		while(iterator.hasNext()) {
			this.documentsComponent.add(iterator.next());
		}
	}
	
	/**
	 * Remove a child component (file) from the current path.
	 * @param documentComponent
	 */
	public void remove(MyDocumentComponent documentComponent) {
		this.documentsComponent.remove(documentComponent);
	}
	
	/**
	 * Get the specific child component (file) from the current path.
	 * @param _index
	 * @return The file in the specific position
	 */
	public MyDocumentComponent getChild(int _index) {
		return this.documentsComponent.get(_index);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Save the current path and the files on it
	 */
	public void save() {
		System.out.println(String.format("-->%s", getName()));
		
		// get the iterator
		Iterator<MyDocumentComponent> iterator = this.documentsComponent.iterator();
		
		// use the iterator to access all elements (files)
		while(iterator.hasNext()) {
			System.out.print("|-");
			iterator.next().save();
		}
		System.out.println("<--");
	}

	@Override
	public Iterator<MyDocumentComponent> createIterator() {
		// get the specific path iterator using the child elements
		return new MyPathIterator(this.documentsComponent.iterator());
	}
}
