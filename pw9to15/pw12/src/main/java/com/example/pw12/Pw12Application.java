package com.example.pw12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import work.with.files.*;

@SpringBootApplication
public class Pw12Application {

	public static void main(String[] args) {
		SpringApplication.run(FileHasher.class, args);
	}

}
