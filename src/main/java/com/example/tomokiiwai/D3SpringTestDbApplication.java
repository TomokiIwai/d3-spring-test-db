package com.example.tomokiiwai;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Application
 *
 * @author tomoki.iwai
 */
@SpringBootApplication
public class D3SpringTestDbApplication implements CommandLineRunner {
	private final JdbcTemplate jdbcTemplate;

	/**
	 * Constructor
	 */
	public D3SpringTestDbApplication(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * entry point
	 */
	public static void main(String[] args) {
		SpringApplication.run(D3SpringTestDbApplication.class, args);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run(String... args) throws Exception {
		jdbcTemplate.execute("create table if not exists user (id bigint(20) not null auto_increment primary key, name varchar(255) not null, password varchar(255) not null)");
		jdbcTemplate.update("truncate table user");
		jdbcTemplate.update("insert into user(name, password) values ('tomoki', 'password')");
	}
}
