package com.codetest.rulesengine.application;

import com.codetest.rulesengine.domain.membership.MembershipService;

public class MembershipServiceImpl implements MembershipService {
    @Override
    public void activateMembership() {
        // TODO real membership activation logic

        System.out.printf("Membership is actived \r\n");
    }

    @Override
    public void upgradeMembership() {
        // TODO real membership upgrade logic

        System.out.printf("Membership is upgraded \r\n");
    }
}
