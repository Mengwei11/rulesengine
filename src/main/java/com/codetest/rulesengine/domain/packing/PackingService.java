package com.codetest.rulesengine.domain.packing;

public interface PackingService {

    void createPackingSlip(String department);

    void addItemToPackingSlip(String itemName);
}
