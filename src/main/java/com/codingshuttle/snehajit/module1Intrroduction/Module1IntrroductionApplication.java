package com.codingshuttle.snehajit.module1Intrroduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1IntrroductionApplication implements CommandLineRunner {
	@Autowired
	PaymentService paymentServiceObj1= null;

	@Autowired
	PaymentService paymentServiceObj2= null;

	public static void main(String[] args) {
		SpringApplication.run(Module1IntrroductionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		paymentServiceObj1.pay();
		paymentServiceObj2.pay();
		System.out.println(paymentServiceObj1.hashCode());
		System.out.println(paymentServiceObj2.hashCode());
	}
}
