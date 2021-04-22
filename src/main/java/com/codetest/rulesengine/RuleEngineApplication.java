package com.codetest.rulesengine;

import com.codetest.rulesengine.domain.PaymentFactory;
import com.codetest.rulesengine.domain.Product;
import com.codetest.rulesengine.domain.ProductType;
import com.codetest.rulesengine.domain.payment.Payment;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RuleEngineApplication {

    public static void main(String[] args) {
        Product product = new Product("Membership", ProductType.ACTIVE_MEMBERSHIP);

        Payment payment = new PaymentFactory().createPayment(product);
        payment.completePayment();
    }
}

