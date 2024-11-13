package com.lld2.FactoryDesignPattern.Assignment1;

public class DocumentProcessorFactory {


    public static DocumentProcessor getDocumentProcessor(DocumentType documentType,String documentName) {

        switch (documentType) {
            case TEXT:
                return new TextDocumentProcessor(documentName);

            case PRESENTATION :
                return new PresentationDocumentProcessor(documentName);

            case SPREAD_SHEET :
                return new SpreadsheetDocumentProcessor(documentName);

            default: return null;
        }

    }
}
