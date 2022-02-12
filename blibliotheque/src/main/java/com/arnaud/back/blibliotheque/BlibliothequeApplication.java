package com.arnaud.back.blibliotheque;

import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.Pret;
import com.arnaud.back.blibliotheque.services.impl.AccountImpl;
import com.arnaud.back.blibliotheque.services.impl.EmailSenderServiceImpl;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.PostMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
@EnableBatchProcessing
public class 	BlibliothequeApplication {

	@Autowired
	EmailSenderServiceImpl emailSenderService;
	@Autowired
	AccountImpl account;
	public static void main(String[] args) {
		SpringApplication.run(BlibliothequeApplication.class, args);


	}

}

