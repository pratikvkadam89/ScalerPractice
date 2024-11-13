package com.lld2.DecoratorDesignPatter.Assignment1;

public class VirusScanDecorator implements FileStorage{

    FileStorage baseFileDecorator;

    public VirusScanDecorator(FileStorage file) {
        this.baseFileDecorator = file;
    }

    VirusScanDecorator(){

    }

    @Override
    public void storeFile(String fileName) {
        baseFileDecorator.storeFile(fileName);
    }

    @Override
    public void retrieveFile(String fileName) {
        baseFileDecorator.retrieveFile(fileName);
    }

    public void virusScan() {
        System.out.println("virusScan ");
    }
}
