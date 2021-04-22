package com.codetest.rulesengine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private String productName;

    private ProductType productType;
}
