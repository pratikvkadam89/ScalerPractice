package com.lld2.PrototypeRegistry.Assignment1;

import java.util.HashMap;

public class UserPrototypeRegistryImpl implements UserPrototypeRegistry {

    HashMap<UserType, User> users = new HashMap<>();

    @Override
    public void addPrototype(User user) {
        users.put(user.getType(), user);
    }

    @Override
    public User getPrototype(UserType type) {
        return users.get(type);
    }

    @Override
    public User clone(UserType type) {
        return users.get(type).cloneObject();
    }
}
