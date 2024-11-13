package com.lld2.FactoryDesignPattern.Assignment1;

public abstract class DocumentProcessor {

    private String documentName;

    public DocumentProcessor(String documentName) {
        this.documentName = documentName;
    }

    public abstract DocumentType supportsType();

    public String getDocumentName() {
        return documentName;
    }

    public abstract void processDocument();
}
