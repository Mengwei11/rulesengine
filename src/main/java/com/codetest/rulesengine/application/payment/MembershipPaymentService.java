package com.codetest.rulesengine.application.payment;

import com.codetest.rulesengine.domain.Product;
import com.codetest.rulesengine.domain.ProductType;
import com.codetest.rulesengine.domain.membership.MembershipService;
import com.codetest.rulesengine.domain.payment.Payment;

public class MembershipPaymentService extends Payment {

    private final MembershipService membershipService;

    public MembershipPaymentService(Product product, MembershipService membershipService) {
        super(product);
        this.membershipService = membershipService;
        System.out.printf("Request for "+ product.getProductType() + " Membership  \n");
    }

    @Override
    public void completePayment() {
        if(this.getProduct().getProductType().equals(ProductType.ACTIVE_MEMBERSHIP)) {
            membershipService.activateMembership();
        }else {
            membershipService.upgradeMembership();
        }
    }
}
