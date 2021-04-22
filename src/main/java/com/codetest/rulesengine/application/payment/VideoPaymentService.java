package com.codetest.rulesengine.application.payment;

import com.codetest.rulesengine.domain.Product;
import com.codetest.rulesengine.domain.packing.PackingService;
import com.codetest.rulesengine.domain.payment.Payment;

public class VideoPaymentService extends Payment {

    private final PackingService packingService;

    public VideoPaymentService(Product product, PackingService packingService) {
        super(product);
        System.out.printf("Buying Video item \n");
        this.packingService = packingService;
    }

    @Override
    public void completePayment() {
        packingService.createPackingSlip("Delivery");
        if(this.getProduct().getProductName().equals("Learn to Ski")) {
            packingService.addItemToPackingSlip("First Aid");
        }
    }
}
