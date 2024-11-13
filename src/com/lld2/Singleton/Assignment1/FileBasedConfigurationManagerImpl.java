package com.lld2.Singleton.Assignment1;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager{

    private static FileBasedConfigurationManagerImpl instance = null;


    private FileBasedConfigurationManagerImpl() {

    }

    public static FileBasedConfigurationManagerImpl getInstance() {
        if (instance == null) {
            instance = new FileBasedConfigurationManagerImpl();
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

    @Override
    public String getConfiguration(String key) {
        return instance.properties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        String value  = instance.properties.getProperty(key);
        if(value != null) {
            return convert(value,type);
        } else {
            return null;
        }
    }

    @Override
    public void setConfiguration(String key, String value) {
        instance.properties.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        instance.properties.setProperty(key, value.toString());
    }

    @Override
    public void removeConfiguration(String key) {
        instance.properties.remove(key);
    }

    @Override
    public void clear() {
        instance.properties.clear();
    }
}
