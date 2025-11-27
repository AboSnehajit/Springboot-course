package com.codingshuttle.snehajit.module1Intrroduction.impl;

import com.codingshuttle.snehajit.module1Intrroduction.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component
@Qualifier("smsNotif")
//@ConditionalOnProperty(name="notification.type", havingValue = "sms")
public class SmsNotificationService implements NotificationService {
    @Override
    public  void send(String message)
    {
        System.out.println("Hell from sms...  "+message);
    }
}
