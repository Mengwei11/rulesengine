package com.codetest.rulesengine;

import com.codetest.rulesengine.domain.PaymentFactory;
import com.codetest.rulesengine.domain.payment.PaymentService;
import com.codetest.rulesengine.domain.product.Product;
import com.codetest.rulesengine.domain.product.ProductType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RuleEngineApplication {

    public static void main(String[] args) {
        //Input for the services
        Product product = new Product("Learn to Ski", ProductType.VIDEO);

        //Create different payment for different products
        PaymentService payment = new PaymentFactory().createPayment(product);
        payment.completePayment(product);
    }
}

