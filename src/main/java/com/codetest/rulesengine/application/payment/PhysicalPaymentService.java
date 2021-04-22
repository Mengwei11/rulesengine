package com.codetest.rulesengine.application.payment;

import com.codetest.rulesengine.domain.packing.PackingService;
import com.codetest.rulesengine.domain.payment.CommissionPayment;
import com.codetest.rulesengine.domain.payment.PaymentService;
import com.codetest.rulesengine.domain.product.Product;
import com.codetest.rulesengine.domain.product.ProductType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PhysicalPaymentService implements PaymentService {

    private final PackingService packingService;
    private final CommissionPayment commissionPayment;

    @Override
    public void completePayment(Product product) {
        System.out.printf("Request payment for "+ product.getProductType() + "\n");
        packingService.createPackingSlip("Delivery");
        commissionPayment.generateCommissionPayment();
        if(product.getProductType().equals(ProductType.BOOK)) {
            packingService.createPackingSlip("Royalty");
        }
    }
}
