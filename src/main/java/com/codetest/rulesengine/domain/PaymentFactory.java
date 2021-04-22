package com.codetest.rulesengine.domain;

import com.codetest.rulesengine.application.CommissionPaymentImpl;
import com.codetest.rulesengine.application.EmailServiceImpl;
import com.codetest.rulesengine.application.MembershipServiceImpl;
import com.codetest.rulesengine.application.PackingServiceImpl;
import com.codetest.rulesengine.application.payment.MembershipPaymentService;
import com.codetest.rulesengine.application.payment.PhysicalPaymentService;
import com.codetest.rulesengine.application.payment.VideoPaymentService;
import com.codetest.rulesengine.domain.payment.PaymentService;
import com.codetest.rulesengine.domain.product.Product;

public class PaymentFactory {

    /*
     Reason for these ugly new statement is because the entrance of the service is in Application file,
      where I don't want to have the services to be initialized

      TODO could have more elegant way to use this factory
     */

    public PaymentService createPayment(Product product) {
        switch (product.getProductType()) {
            case PHYSICAL:
            case BOOK:
                return new PhysicalPaymentService(new PackingServiceImpl(), new CommissionPaymentImpl());
            case ACTIVE_MEMBERSHIP:
            case UPGRADE_MEMBERSHIP:
                return new MembershipPaymentService(new MembershipServiceImpl(), new EmailServiceImpl());
            case VIDEO:
                return new VideoPaymentService(new PackingServiceImpl());
            default:
                return null;
        }
    }
}
