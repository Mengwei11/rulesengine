package com.codetest.rulesengine.application.payment;

import com.codetest.rulesengine.domain.packing.PackingService;
import com.codetest.rulesengine.domain.payment.PaymentService;
import com.codetest.rulesengine.domain.product.Product;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VideoPaymentService implements PaymentService {

    private final PackingService packingService;

    @Override
    public void completePayment(Product product) {
        System.out.printf("Request payment for "+ product.getProductType() + "\n");

        packingService.createPackingSlip("Delivery");
        if(product.getProductName().equals("Learn to Ski")) {
            packingService.addItemToPackingSlip("First Aid");
        }
    }
}
