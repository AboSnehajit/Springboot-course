package com.codingshuttle.snehajit.module1Intrroduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;


@Component
//@Service
//@Controller
//@Repository
//@RestController
public class PaymentService {

    public void pay()
    {
        System.out.println("this is payment");
    }

     @PostConstruct
      public void afterInitia()
     {
         System.out.println("This is before paying : ");
     }

     @PreDestroy
     public void beforeDestroy()
     {
         System.out.println("This is just beforre death");
     }



}
