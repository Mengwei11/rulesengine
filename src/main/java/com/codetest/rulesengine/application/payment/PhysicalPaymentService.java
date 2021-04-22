package com.codetest.rulesengine.application.payment;

import com.codetest.rulesengine.domain.Product;
import com.codetest.rulesengine.domain.ProductType;
import com.codetest.rulesengine.domain.packing.PackingService;
import com.codetest.rulesengine.domain.payment.CommissionPayment;
import com.codetest.rulesengine.domain.payment.Payment;

public class PhysicalPaymentService extends Payment{

    private final PackingService packingService;
    private final CommissionPayment commissionPayment;

    public PhysicalPaymentService(Product product, PackingService packingService, CommissionPayment commissionPayment) {
        super(product);
        this.packingService = packingService;
        this.commissionPayment = commissionPayment;
        System.out.printf("Buying " + product.getProductType().toString() +" Item \n");
    }

    @Override
    public void completePayment() {
        packingService.createPackingSlip("Delivery");
        commissionPayment.generateCommissionPayment();
        if(this.getProduct().getProductType().equals(ProductType.BOOK)) {
            packingService.createPackingSlip("Royalty");
        }
    }
}
