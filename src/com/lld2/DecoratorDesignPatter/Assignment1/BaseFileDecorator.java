package com.lld2.DecoratorDesignPatter.Assignment1;

public class BaseFileDecorator implements FileStorage{

    private String filename;

    public String getFilename() {
        return filename;
    }

    public BaseFileDecorator(String filename) {
        this.filename = filename;
    }

    @Override
    public void storeFile(String fileName) {
        System.out.println("Storing file BaseFileDecorator " + fileName);
    }

    @Override
    public void retrieveFile(String fileName) {
        System.out.println("retrieve file BaseFileDecorator " + fileName);
    }
}
