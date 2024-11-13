package com.lld2.DecoratorDesignPatter.Assignment1;

public class CompressionDecorator  {

    FileStorage baseFileDecorator;

    public CompressionDecorator(FileStorage baseFileDecorator) {
        this.baseFileDecorator = baseFileDecorator;
    }

//    @Override
    public void storeFile(String fileName) {
        baseFileDecorator.storeFile(fileName);
    }

//    @Override
    public void retrieveFile(String fileName) {
        baseFileDecorator.retrieveFile(fileName);
    }

    public void compress() {
        System.out.println("compressing file ");
    }
}
