package com.cobiztech.conference_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Code-Reference: https://github.com/dlbunker/ps-first-spring-boot-app
 *
 * PROJECT-STATUS: NOT-COMPLETED.
 *
 * POSTMAN testing REST API.
 * ===== sessions   Resource ======
 * - [GET] http://localhost:8080/api/v1/sessions      ===> get all sessions.
 * - [GET] http://localhost:8080/api/v1/sessions/1    ===> Get session with id = 1
 * - [POST] http://localhost:8080/api/v1/sessions/1
 * - [PUT] http://localhost:8080/api/v1/sessions/1
 *
 * ===== Speakers Resource =====
 *  - http://localhost:8080/api/v1/speakers      ===> get all speakers.
 *  - http://localhost:8080/api/v1/speakers/1    ===> get speaker with Id
 */


@SpringBootApplication
public class SpringBootConferenceBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConferenceBookingApplication.class, args);
	}

}
