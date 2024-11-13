package com.lld2.PrototypeRegistry.Assignment2;

import java.util.HashMap;

public class InvoicePrototypeRegistryImpl implements InvoicePrototypeRegistry {

    HashMap<InvoiceType, Invoice> invoices = new HashMap<>();

    @Override
    public void addPrototype(Invoice user) {
        invoices.put(user.getType(), user);
    }

    @Override
    public Invoice getPrototype(InvoiceType type) {
        return invoices.get(type);
    }

    @Override
    public Invoice clone(InvoiceType type) {
        return invoices.get(type).cloneObject();
    }
}
