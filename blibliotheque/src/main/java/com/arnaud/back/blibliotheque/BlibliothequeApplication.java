package com.arnaud.back.blibliotheque;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

@SpringBootApplication
@EnableSwagger2
@EnableBatchProcessing
public class 	BlibliothequeApplication {

	public static boolean isValidEmail( String email ) {
		//String regExp = "^.+@.+\\..+$";
		String regExp = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$";
		return email.matches( regExp );
	}


	public static void main(String[] args) {
		SpringApplication.run(BlibliothequeApplication.class, args);
		// --- Good Emails ---
		System.out.println( isValidEmail( "dominique.liard@infini-software.com" ) );
		System.out.println( isValidEmail( "martin@societe.com" ) );
		System.out.println( isValidEmail( "martin@societe.fr" ) );

		System.out.println( "-----------------------------" );

		// --- Bad Emails ---
		System.out.println( isValidEmail( "martin.societe.com" ) );   // No @ character
		System.out.println( isValidEmail( "martin@societe" ) );       // No . character
		System.out.println( isValidEmail( "@@@.@" ) );
		System.out.println( isValidEmail( "martin@societe.f" ) );

		// create an LocalDate object
		LocalDate lt
				= LocalDate.now();

		// print result
		System.out.println("LocalDate : "
				+ lt);
	}

}
