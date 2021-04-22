package com.codetest.rulesengine.application.payment;

import com.codetest.rulesengine.domain.packing.PackingService;
import com.codetest.rulesengine.domain.payment.CommissionPayment;
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
class PhysicalPaymentServiceTest {

    @Mock
    private PackingService packingService;

    @Mock
    private CommissionPayment commissionPayment;

    @InjectMocks
    private PhysicalPaymentService physicalPaymentService;

    @Test
    void completePaymentForNormalPhysicalTest() {
        //Given
        Product product = Mockito.mock(Product.class);
        given(product.getProductType()).willReturn(ProductType.PHYSICAL);

        //When
        physicalPaymentService.completePayment(product);

        //Then
        then(packingService).should().createPackingSlip(any());
        then(commissionPayment).should().generateCommissionPayment();
    }

    @Test
    void completePaymentForBookTest() {
        //Given
        Product product = Mockito.mock(Product.class);
        given(product.getProductType()).willReturn(ProductType.BOOK);

        //When
        physicalPaymentService.completePayment(product);

        //Then
        then(packingService).should().createPackingSlip("Delivery");
        then(commissionPayment).should().generateCommissionPayment();
        then(packingService).should().createPackingSlip("Royalty");
    }
}