package com.demo.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DBConnectionCheck {
	
	@Autowired
	private DataSource dataSource;
	
	
	@PostConstruct
	public void checkDBConnection() {
		try (Connection connection = dataSource.getConnection()) {
			if(connection != null ) {
				DatabaseMetaData metaData = connection.getMetaData();
				String DatabaseName = metaData.getDatabaseProductName();
				System.out.println("Data is successfully connected ! " );
				System.out.println("Database Name is : "+DatabaseName);
			}else {
				System.out.println("Database not connected ! Try again ...");
			}	
		} catch (Exception e) {
			System.out.println("Unexpected error occured ! "+ e);
		}
	}

}
