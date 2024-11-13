package com.lld2.PrototypeRegistry.Assignment1;

public interface UserPrototypeRegistry {

    void addPrototype(User user);

    User getPrototype(UserType type);

    User clone(UserType type);
}
