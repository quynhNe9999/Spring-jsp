package com.oneempower.auth;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.oneempower.auth.service.FileStorageService;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {

	@Resource
	private FileStorageService storageService;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebApplication.class, args);
	}

	public void run(String... arg) throws Exception {
//      storageService.deleteAll();
		storageService.init();
	}
}
