package com.lld2.Singleton.Assignment2;

import jdk.jfr.internal.LogLevel;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LoggerImpl implements Logger {

    private static LoggerImpl logger = null;
    private PrintWriter pw;
    private String filePath;

    private LoggerImpl(){

    }

    public static LoggerImpl getInstance(){
        if(logger == null){
            logger = new LoggerImpl();
        }
        return logger;
    }

    public static void resetInstance(){
        logger = null;
    }

    @Override
    public void log(LogLevel level, String message) {
        if(this.pw == null) throw new IllegalStateException();

        logger.pw.append(level.toString());
        logger.pw.append(message);
    }

    @Override
    public void setLogFile(String filePath) {
        try {
            logger.filePath = filePath;
            logger.pw = new PrintWriter(filePath);
        } catch(FileNotFoundException ex) {

        }

    }

    @Override
    public String getLogFile() {
        return logger.filePath;
    }

    @Override
    public void flush() {
        logger.pw.flush();
    }

    @Override
    public void close() {
        logger.pw = null;
    }
}
