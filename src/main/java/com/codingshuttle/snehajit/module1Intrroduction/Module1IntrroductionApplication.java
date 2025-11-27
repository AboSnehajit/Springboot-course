package com.codingshuttle.snehajit.module1Intrroduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Module1IntrroductionApplication implements CommandLineRunner {

//	@Autowired
//	final NotificationService notificationServiceobj;
//
//	public Module1IntrroductionApplication(NotificationService notificationServiceobj) {
//		this.notificationServiceobj = notificationServiceobj;
//	}


	@Autowired
	Map<String,NotificationService > notificationServiceMap= new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(Module1IntrroductionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Not the SpingBoot way
//		NotificationService notificationServiceobj= new EmailNotificationService();
//		notificationServiceobj.send("Hello Snehajit");


		for (var notificationService:
			 notificationServiceMap.entrySet()) {
			System.out.println(notificationService.getKey());
			notificationService.getValue().send("Heya");

		}


	}
}
