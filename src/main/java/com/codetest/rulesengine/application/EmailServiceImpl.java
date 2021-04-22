package com.codetest.rulesengine.application;

import com.codetest.rulesengine.domain.notification.NotificationService;

public class EmailServiceImpl implements NotificationService {

    @Override
    public void sendMessage(String message) {

        System.out.printf(message + "\r\n");

    }
}
