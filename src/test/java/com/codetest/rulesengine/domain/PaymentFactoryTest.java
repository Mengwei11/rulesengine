package com.codetest.rulesengine.domain;

import com.codetest.rulesengine.application.payment.MembershipPaymentService;
import com.codetest.rulesengine.application.payment.PhysicalPaymentService;
import com.codetest.rulesengine.application.payment.VideoPaymentService;
import com.codetest.rulesengine.domain.payment.PaymentService;
import com.codetest.rulesengine.domain.product.Product;
import com.codetest.rulesengine.domain.product.ProductType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PaymentFactoryTest {

    private PaymentFactory paymentFactory = new PaymentFactory();

    private Product product;

    @BeforeEach
    void beforeEach() {
        product = Mockito.mock(Product.class);
    }

    @Nested
    class PhysicalPaymentTests {
        @Test
        public void returnPhysicalPaymentIfPhysicalProductTest() {
            //Given
            given(product.getProductType()).willReturn(ProductType.PHYSICAL);

            //When
            PaymentService service = paymentFactory.createPayment(product);

            //Then
            assertEquals(PhysicalPaymentService.class, service.getClass());

        }

        @Test
        public void returnPhysicalPaymentIfBookProductTest() {
            //Given
            given(product.getProductType()).willReturn(ProductType.BOOK);

            //When
            PaymentService service = paymentFactory.createPayment(product);

            //Then
            assertEquals(PhysicalPaymentService.class, service.getClass());

        }
    }

    @Nested
    class MembershipTests {
        @Test
        public void returnMembershipPaymentIfActiveTest() {
            //Given
            given(product.getProductType()).willReturn(ProductType.ACTIVE_MEMBERSHIP);

            //When
            PaymentService service = paymentFactory.createPayment(product);

            //Then
            assertEquals(MembershipPaymentService.class, service.getClass());

        }

        @Test
        public void returnMembershipPaymentIfUpgradeTest() {
            //Given
            given(product.getProductType()).willReturn(ProductType.UPGRADE_MEMBERSHIP);

            //When
            PaymentService service = paymentFactory.createPayment(product);

            //Then
            assertEquals(MembershipPaymentService.class, service.getClass());

        }
    }

    @Nested
    class VideoPaymentTests {
        @Test
        public void returnVideoPaymentTest() {
            //Given
            given(product.getProductType()).willReturn(ProductType.VIDEO);

            //When
            PaymentService service = paymentFactory.createPayment(product);

            //Then
            assertEquals(VideoPaymentService.class, service.getClass());

        }
    }
}