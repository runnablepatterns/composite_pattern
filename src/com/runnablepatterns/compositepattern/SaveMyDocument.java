package com.runnablepatterns.compositepattern;

import java.util.Iterator;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class used to perform MyDocument save operations
 * 
 */
public class SaveMyDocument {
	
	/**
	 * Variable to store tree hierarchy of paths and files
	 */
	private MyDocumentComponent allDocuments;
	
	/**
	 * Overloaded constructor that receives the tree
	 * @param _allDocuments
	 */
	public SaveMyDocument(MyDocumentComponent _allDocuments) {
		this.allDocuments = _allDocuments;
	}
	
	/**
	 * Save the current documents
	 */
	public void saveDocuments() {
		this.allDocuments.save();
	}
	
	public void saveByType(String type) {
		// create the custom iterator
		Iterator<MyDocumentComponent> docsByType = this.allDocuments.createIterator();
		
		System.out.println(String.format("Saving all %s files.", type));
		
		while(docsByType.hasNext()) {
			MyDocumentComponent document = docsByType.next();
			
			try {
				// if the document type is PDF
				if(document.getType().equals(type)) {
					
					// save the document
					document.save();
				}
			}// handle exception when the element is a path since it does not have a type
			catch(UnsupportedOperationException ex)
			{
				
			}
		}
	}
}
