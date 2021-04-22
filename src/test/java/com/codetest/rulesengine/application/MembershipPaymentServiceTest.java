package com.codetest.rulesengine.application;

import com.codetest.rulesengine.application.payment.MembershipPaymentService;
import com.codetest.rulesengine.domain.membership.MembershipService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MembershipPaymentServiceTest {

    @Mock
    private MembershipService membershipService;

    @InjectMocks
    private MembershipPaymentService membershipPaymentService;
}
