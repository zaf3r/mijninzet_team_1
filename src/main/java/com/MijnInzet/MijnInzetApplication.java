package com.MijnInzet;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MijnInzetApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(MijnInzetApplication.class)
				.logStartupInfo(false)
				.run(args);
	}
}
