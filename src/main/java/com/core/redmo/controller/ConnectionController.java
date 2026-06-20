//$Id$
package com.core.redmo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connection")
public class ConnectionController {
    /*
     * Design - Connections to redis instances are established through the connection module. 
     * We can connect to multiple instances , 
     * Create connection , list connection , edit connection , delete connection
     * Based on connections  the keys and values are listed
     */
	 /*
	  * connection table design 
	  * 
	  *  connection_id --> Long
	  *  connection_name --> String
	  *  Host --> String
	  *  Port --> Int 
	  *  redis_username --> String 
	  *  redis_password --> String
	  *  connection_status --> up,down,issues with establishing connection
	  */
	@GetMapping
	public void getAllConnections() {
		
	}
	
	@PostMapping
	public void createConnection() {
		
	}
	
	@PutMapping("/{id}")
	public void editConnection() {
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteConnection() {
		
	}

}
