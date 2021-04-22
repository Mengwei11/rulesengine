package com.codetest.rulesengine.application;

import com.codetest.rulesengine.domain.packing.PackingService;

public class PackingServiceImpl implements PackingService {

    @Override
    public void createPackingSlip(String department) {
        System.out.printf("Creating packing slip for "+ department + " \r\n");
    }

    @Override
    public void addItemToPackingSlip(String itemName) {
        System.out.printf("Adding item "+itemName +" to packing slip \r\n");
    }
}
