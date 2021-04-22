package com.codetest.rulesengine.application.payment;

import com.codetest.rulesengine.domain.membership.MembershipService;
import com.codetest.rulesengine.domain.payment.PaymentService;
import com.codetest.rulesengine.domain.product.Product;
import com.codetest.rulesengine.domain.product.ProductType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MembershipPaymentService implements PaymentService {

    private final MembershipService membershipService;

    @Override
    public void completePayment(Product product) {
        System.out.printf("Request payment for "+ product.getProductType() + "\n");

        if(product.getProductType().equals(ProductType.ACTIVE_MEMBERSHIP)) {
            membershipService.activateMembership();
        }else {
            membershipService.upgradeMembership();
        }
    }
}
