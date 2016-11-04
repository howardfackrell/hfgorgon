package com.octanner.ca;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
@Configuration
public class HfgorgonApplication {

	public static final String DB_URL_REGEX = "^postgres://(?<user>\\w+):(?<password>\\w+)@(?<host>[a-zA-Z0-9\\.-]+):(?<port>\\d+)/(?<service>\\w+)$";

	Pattern DB_URL_PATTERN = Pattern.compile(DB_URL_REGEX);

	@Bean
	@Primary
	@FlywayDataSource
	DataSource datasource(@Value("${spring.datasource.url}") String url) throws ClassNotFoundException {

		Matcher dbUrlMatcher = DB_URL_PATTERN.matcher(url);

		String user = dbUrlMatcher.group("user");
		String password = dbUrlMatcher.group("password");
		String host = dbUrlMatcher.group("host");
		String port = dbUrlMatcher.group("port");
		String service = dbUrlMatcher.group("service");
		String jdbcUrl = "jdbc:postgresql://" + host + ":" + port + "/" + service;

		DriverManagerDataSource ds = new DriverManagerDataSource(jdbcUrl, user, password);

		return ds;
	}

	public static void main(String[] args) {
		SpringApplication.run(HfgorgonApplication.class, args);
	}
}
