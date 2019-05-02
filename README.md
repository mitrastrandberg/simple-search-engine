﻿__Simple Search Engine__

_DB_  
Document 1: “the brown fox jumped over the brown dog”  
Document 2: “the lazy brown dog sat in the corner”  
Document 3: “the red fox bit the lazy dog”  
...

_MAIN_  
Interface with the user, uses a Lexer to tokenize the input an construct the relevant query  
main  
readQuery  
generateOutput

_LEXER_  
Tokenize a line of input according to the grammar:  
begin with ADD, SELECT, GET, EXIT  
FILENAME = filename.txt  
WORD = \w+(([\-\_]\w+)+)*  
PERIOD = [\.\!\?]

_QUERY_  
Object that holds the request from the user, allowed queries are:  
ADD FILENAME WORD+  
SELECT FILENAME+  
GET WORD  
EXIT

_INVERTED INDEX_  
Hashmap datastructure that maps a token to a list of documents
- Calulates idf  
- For each term, store a list of documents as a DocumentList

_DOCUMENTLIST_  
Interface for a list of documents associated with a term (word token)

_TFDOCUMENTLIST_  
A DocumentList that stores tf scores

_TFIDFDOCUMENTLIST_  
A DocumentList that stores tf-idf scores

_SEARCH ENGINE_  
Interface between Main, Queries, InvertedIndex and the data base (db folder)


_TF-IDF_  
TF: (term frequency) the number of times that term t occurs in document d  
	tf = for d; if d contains t; sum+=1

IDF: (inverse document frequency) inverse fraction of the documents that contain the term  
	idf = log( |N| / |N.contains(t)| )  
 	or to avoid division by zero:  
	idf = log ( |N| / 1+|N.contains(t)| )


1. Man vill kunna lägga till nya dokument, och då behålla stora/små bokstäver, siffror, och tecken i databasen!
Därför används inte tokens för själva texten som ska sparas.  
MEN när man laddar dokumenten till index så behöver de vara kompatibla med Query-tokens, så i _load_docs_ så
tokeniseras dokumenten!

2. 

