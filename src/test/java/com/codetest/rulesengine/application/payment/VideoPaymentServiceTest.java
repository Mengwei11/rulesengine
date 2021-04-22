package com.codetest.rulesengine.application.payment;

import com.codetest.rulesengine.domain.packing.PackingService;
import com.codetest.rulesengine.domain.product.Product;
import com.codetest.rulesengine.domain.product.ProductType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class VideoPaymentServiceTest {

    @Mock
    private PackingService packingService;
    @InjectMocks
    private VideoPaymentService videoPaymentService;

    @Test
    void completePaymentForNormalVideoTest() {
        //Given
        Product product = Mockito.mock(Product.class);
        given(product.getProductType()).willReturn(ProductType.VIDEO);
        given(product.getProductName()).willReturn("something");

        //When
        videoPaymentService.completePayment(product);

        //Then
        then(packingService).should().createPackingSlip("Delivery");
    }

    @Test
    void completePaymentForSkiVideoTest() {
        //Given
        Product product = Mockito.mock(Product.class);
        given(product.getProductType()).willReturn(ProductType.VIDEO);
        given(product.getProductName()).willReturn("Learn to Ski");

        //When
        videoPaymentService.completePayment(product);

        //Then
        then(packingService).should().createPackingSlip("Delivery");
        then(packingService).should().addItemToPackingSlip("First Aid");
    }
}