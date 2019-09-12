package com.runnablepatterns.compositepatterndemo;

import com.runnablepatterns.compositepattern.ClientA;
import com.runnablepatterns.compositepattern.ClientB;
import com.runnablepatterns.compositepattern.ClientC;
import com.runnablepatterns.compositepattern.MyDocumentAggregate;
import com.runnablepatterns.compositepattern.MyDocumentComponent;
import com.runnablepatterns.compositepattern.MyPath;
import com.runnablepatterns.compositepattern.SaveMyDocument;

/**
 * 
 * @author Carlos Marin
 * Runnable Patterns (runnablepatterns.com)
 * 
 * Class used to demonstrates Iterator pattern
 * 
 */
public class CompositePatternDemo {

	public static void main(String[] args) {
		
		// create main path to search for files to save
		// this is an instance of MyPath that can hold additional paths or files
		MyDocumentComponent allDocuments = new MyPath("GlobalRepository");
				
		// create client that uses ArrayList
		MyDocumentAggregate clientA = new ClientA();
		
		// add all documents to the main path
		allDocuments.add(clientA.createIterator());
		
		// create client that uses Array
		MyDocumentAggregate clientB = new ClientB();
		
		// add all documents to the main path
		allDocuments.add(clientB.createIterator());
		
		// create client that uses HashMap and paths
		MyDocumentAggregate clientC = new ClientC();
		
		// add all paths to the main path
		allDocuments.add(clientC.createIterator());
				
		// create save service
		SaveMyDocument saveDocument = new SaveMyDocument(allDocuments);
		
		// save all documents
		saveDocument.saveDocuments();
		
		// save just PDF
		saveDocument.saveByType("PDF");
	}

}
