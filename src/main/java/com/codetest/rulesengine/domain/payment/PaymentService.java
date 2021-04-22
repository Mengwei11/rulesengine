package com.codetest.rulesengine.domain.payment;

import com.codetest.rulesengine.domain.product.Product;

public interface PaymentService {

    void completePayment(Product product);
}
