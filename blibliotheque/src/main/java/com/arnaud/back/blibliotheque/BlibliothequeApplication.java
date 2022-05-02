package com.arnaud.back.blibliotheque;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;

@SpringBootApplication
@EnableSwagger2
@EnableBatchProcessing
public class 	BlibliothequeApplication {



	public static void main(String[] args) {
		SpringApplication.run(BlibliothequeApplication.class, args);

		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dTf = DateTimeFormatter.ofPattern("dd MMMM, YYYY");
		System.out.println(dTf.format(localDateTime));
	}



}

