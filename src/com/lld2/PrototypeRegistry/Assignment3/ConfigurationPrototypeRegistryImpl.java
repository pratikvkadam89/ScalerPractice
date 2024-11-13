package com.lld2.PrototypeRegistry.Assignment3;

import java.util.HashMap;

public class ConfigurationPrototypeRegistryImpl implements ConfigurationPrototypeRegistry {

    HashMap<ConfigurationType, Configuration> configurations = new HashMap<>();

    @Override
    public void addPrototype(Configuration user) {
        configurations.put(user.getType(), user);
    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {
        return configurations.get(type);
    }

    @Override
    public Configuration clone(ConfigurationType type) {
        return configurations.get(type).cloneObject();
    }
}
