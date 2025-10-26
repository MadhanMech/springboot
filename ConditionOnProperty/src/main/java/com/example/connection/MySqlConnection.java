package com.example.connection;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"prod","qa"})
@ConditionalOnProperty(
		prefix = "sqlconnection",
		value = "enabled",
		havingValue = "created",
		matchIfMissing = false
		
		
		)
public class MySqlConnection {

	public MySqlConnection() {
		  System.out.println("MySqlConnection Init");
			}
    
}
