package com.octanner.ca;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
@Configuration
public class HfgorgonApplication {

//	@Bean
//	@Primary
//	@FlywayDataSource
//	DataSource datasource  (
//			@Value("${spring.datasource.url}") String url,
//			@Value("${spring.datasource.username}") String username,
//			@Value("${spring.datasource.password}") String password) throws ClassNotFoundException {
//
//		DriverManagerDataSource  ds = new DriverManagerDataSource(url, username, password);
////		ds.setDriverClassName("org.postgresql.Driver");
//
//		return ds;
//	}

	public static void main(String[] args) {
		SpringApplication.run(HfgorgonApplication.class, args);
	}
}
