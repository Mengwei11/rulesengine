package com.codetest.rulesengine.application;

import com.codetest.rulesengine.domain.membership.MembershipService;

public class MembershipServiceImpl implements MembershipService {
    @Override
    public void activateMembership() {
        System.out.printf("Membership is actived \r\n");
    }

    @Override
    public void upgradeMembership() {
        System.out.printf("Membership is upgraded \r\n");
    }
}
