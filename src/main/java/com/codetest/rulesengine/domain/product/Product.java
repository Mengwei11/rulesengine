package com.codetest.rulesengine.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private String productName;

    private ProductType productType;
}
