package com.codetest.rulesengine.application;

import com.codetest.rulesengine.domain.payment.CommissionPayment;

public class CommissionPaymentImpl implements CommissionPayment {

    @Override
    public void generateCommissionPayment() {
        System.out.printf("Generate commission payment \r\n ");
    }
}
