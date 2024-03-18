package com.ldbbank.referal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReferalApplication  implements CommandLineRunner {

	public static void main(String[] args) {


		SpringApplication.run(ReferalApplication.class, args);

		System.out.printf("hello");
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
