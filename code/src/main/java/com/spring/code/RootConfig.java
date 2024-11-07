package com.spring.code;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//pom.xml을 사용하지 않을때 만드는 자바 설정파일
@Configuration//해당 클래스의 인스턴스를 이용하여 설정파일을 대체합니다
@ComponentScan(basePackages= {"com.spring.code.sample"})
public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
		
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
		hikariConfig.setUsername("TEST_USR");
		hikariConfig.setPassword("1234");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);	
		return dataSource;
	}

}
