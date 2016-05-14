package com.cubetech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class CpSoapApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(CpSoapApplication.class, args);
	}
	
	@Override
	protected final SpringApplicationBuilder configure(
			final SpringApplicationBuilder application) {
		return application.sources(CpSoapApplication.class);
	}

	@Bean
	public Jackson2ObjectMapperFactoryBean jacksonBuilder() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

		Jackson2ObjectMapperFactoryBean builder = new Jackson2ObjectMapperFactoryBean();
		builder.setFeaturesToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		builder.setObjectMapper(mapper);

		return builder;
	}
}
