package com.demo.springcloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@EnableZipkinStreamServer
//@EnableZipkinServer
@SpringBootApplication
public class ZipKinApp 
{
	
    public static void main( String[] args )
    {
    	SpringApplication.run(ZipKinApp.class, args);
    }
    
/*    @Bean
    public MySQLStorage mySQLStorage(DataSource dataSource){
    	return MySQLStorage.builder().datasource(dataSource).executor(Runnable::run).build();
    }
    */
}
