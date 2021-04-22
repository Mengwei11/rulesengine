package com.codetest.rulesengine.application.payment;

import com.codetest.rulesengine.domain.membership.MembershipService;
import com.codetest.rulesengine.domain.notification.NotificationService;
import com.codetest.rulesengine.domain.product.Product;
import com.codetest.rulesengine.domain.product.ProductType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class MembershipPaymentServiceTest {

    @Mock
    private MembershipService membershipService;
    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private MembershipPaymentService membershipPaymentService;

    @Test
    public void completePaymentForActiveMembershipTest() {
        //Given
        Product product = Mockito.mock(Product.class);
        given(product.getProductType()).willReturn(ProductType.ACTIVE_MEMBERSHIP);

        //When
        membershipPaymentService.completePayment(product);

        //Then
        then(membershipService).should().activateMembership();
        then(notificationService).should().sendMessage(any());
    }

    @Test
    public void completePaymentForUpgradeMembershipTest() {
        //Given
        Product product = Mockito.mock(Product.class);
        given(product.getProductType()).willReturn(ProductType.UPGRADE_MEMBERSHIP);

        //When
        membershipPaymentService.completePayment(product);

        //Then
        then(membershipService).should().upgradeMembership();
        then(notificationService).should().sendMessage(any());
    }
}
