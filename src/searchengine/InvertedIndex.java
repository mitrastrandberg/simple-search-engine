package searchengine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Inverted index
 * Data structure for searching the documents in the data base
 *
 */
public class InvertedIndex {
	
	// index that maps words to documents, format: <term>: <document id>
	private Map<String, TfDocumentList> index = new HashMap<String, TfDocumentList>();
	private Set<String> docIds = new HashSet<String>();
	
	/**
	 * Add a (word, document) pair to the index
	 * @param term A word in the document
	 * @param docID The document identifier, e.g. document name
	 */
	public void insert(String term, Document docTerm) {
		// Add to index
		if (index.containsKey(term)) {
			TfDocumentList docs = index.get(term);
			docs.add(docTerm);
			index.put(term, docs);
		} else {
			TfDocumentList docs = new TfDocumentList(term);
			docs.add(docTerm);
			index.put(term, docs);
		}
		// Keep track of the number of documents
		docIds.add(docTerm.getDocId());
	}
	
	/**
	 * Get the names of all documents that contain a key word
	 */
	public TfDocumentList getDocuments(String term) {
		TfDocumentList documents = index.get(term);
		if (documents == null) {
			documents = new TfDocumentList(term);
		}
		return documents;
	}
	
	public Integer numberOfDocuments() {
		return docIds.size();
	}
	
	/**
	 * Calculates the idf for the specified term
	 * @param term the word/token for which to evaluate the idf
	 * @return the idf score which equals -log(#documents containing term / #documents in index)
	 */
	public Double calcIdf(String term) {
		Double idf;
		if (index.containsKey(term)) {
			idf = -Math.log((double) index.get(term).size() / numberOfDocuments());
		} else {
			idf = 0.0;
		}
		return idf;
	}
	
	@Override
	public String toString() {
		return index.toString();
	}

}
