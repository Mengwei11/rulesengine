package com.codetest.rulesengine.domain.payment;

import com.codetest.rulesengine.domain.Product;

public abstract class Payment {

    private final Product product;

    public Payment(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public abstract void completePayment();
}
