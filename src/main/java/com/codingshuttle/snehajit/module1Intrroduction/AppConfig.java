package com.codingshuttle.snehajit.module1Intrroduction;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
@Bean
@Scope("prototype")
    PaymentService paymentService()
    {
        //space for more logic
        return new PaymentService();
    }

}
