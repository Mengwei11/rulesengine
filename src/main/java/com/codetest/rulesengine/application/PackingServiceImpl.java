package com.codetest.rulesengine.application;

import com.codetest.rulesengine.domain.packing.PackingService;

public class PackingServiceImpl implements PackingService {

    @Override
    public void createPackingSlip(String department) {
        // TODO real creating packing slip logic

        System.out.printf("Creating packing slip for "+ department + " \r\n");
    }

    @Override
    public void addItemToPackingSlip(String itemName) {
        // TODO real adding packing slip logic

        System.out.printf("Adding item "+itemName +" to packing slip \r\n");
    }
}
