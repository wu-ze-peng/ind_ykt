package com.ykt.ind_ykt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = {"com.ykt.ind_ykt.mapper"})
public class IndYktApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndYktApplication.class, args);
	}

}
