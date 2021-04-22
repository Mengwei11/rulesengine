package com.codetest.rulesengine.domain;

import com.codetest.rulesengine.application.CommissionPaymentImpl;
import com.codetest.rulesengine.application.MembershipServiceImpl;
import com.codetest.rulesengine.application.PackingServiceImpl;
import com.codetest.rulesengine.application.payment.MembershipPaymentService;
import com.codetest.rulesengine.application.payment.PhysicalPaymentService;
import com.codetest.rulesengine.application.payment.VideoPaymentService;
import com.codetest.rulesengine.domain.payment.Payment;

public class PaymentFactory {

    public Payment createPayment(Product product) {
        switch (product.getProductType()) {
            case PHYSICAL:
            case BOOK:
                return new PhysicalPaymentService(product, new PackingServiceImpl(), new CommissionPaymentImpl());
            case ACTIVE_MEMBERSHIP:
            case UPGRADE_MEMBERSHIP:
                return new MembershipPaymentService(product, new MembershipServiceImpl());
            case VIDEO:
                return new VideoPaymentService(product, new PackingServiceImpl());
            default:
                return null;
        }
    }
}
