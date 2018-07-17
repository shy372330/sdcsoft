package com.sdcsoft.cn;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.sdcsoft.cn.module.*.dao","com.sdcsoft.cn.module.**.mapper"})
@SpringBootApplication

public class Application implements CommandLineRunner{

	@Autowired
    DataSource dataSource;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/**
	 * 查看用了什么数据库连接池
	 */
	public void run(String... args) throws Exception {
        System.out.println("DATASOURCE = " + dataSource);
    }

}
