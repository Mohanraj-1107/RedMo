//$Id$
package com.core.redmo.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.core.redmo.entity.Connections;
import com.core.redmo.service.ConnectionService;

@RestController
@RequestMapping("/connection")
public class ConnectionController {
	 /*
	  * connection table design 
	  *  connection_id --> Long
	  *  connection_name --> String
	  *  Host --> String
	  *  Port --> Integer
	  *  redis_username --> String 
	  *  redis_password --> String
	  *  connection_status --> up,down,issues with establishing connection
	  *  create_on --> long 
	  *  modifies_on --> long
	  */
	private ConnectionService connectionService;
	
	public ConnectionController(ConnectionService connectionService) {
		this.connectionService=connectionService;
	}
	
	@GetMapping
	public ResponseEntity<Map<String,Object>> getAllConnections() {
		Map<String,Object> serviceResponse=connectionService.getAllConnections();
		return ResponseEntity.ok(serviceResponse);
	}
	
	@PostMapping
	public ResponseEntity<Map<String,Object>> createConnection(@RequestBody Connections connection) {
		if(connection==null) {
			throw new RuntimeException("connection object is null");
		}
		Map<String,Object> serviceResponse=new HashMap<>();
		
		if(connection.getConnectionName()==null | connection.getHost()==null || connection.getPort()==0 || connection.getRedisPassword()==null || connection.getRedisUserName()==null) {
			serviceResponse.put("status","error");
			serviceResponse.put("message","some required params are missing");
			return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(serviceResponse);
		}
		serviceResponse=connectionService.createConnection(connection);
		return ResponseEntity.ok(serviceResponse);
	}
	
	@PutMapping("/{connectionId}")
	public ResponseEntity<Map<String,Object>>  updateConnection(@PathVariable Long connectionId,@RequestBody Connections connection) {
		if(connectionId==null) {
			throw new RuntimeException("connection_id is null");
		}
		if(connection==null) {
			throw new RuntimeException("connection object is null");
		}
		Map<String,Object> serviceResponse=connectionService.updateConnection(connectionId, connection);
		return ResponseEntity.ok(serviceResponse);
	}
	
	@DeleteMapping("/{connectionId}")
	public ResponseEntity<Map<String,Object>> deleteConnection(@PathVariable Long connectionId) {
		if(connectionId==null) {
			throw new RuntimeException("connection_id is null");
		}
		Map<String,Object> serviceResponse=connectionService.deleteConnection(connectionId);
		return ResponseEntity.ok(serviceResponse);
	}
	
	@PostMapping("/connect/{connectionId}")
	public ResponseEntity<Map<String,Object>> establishConnection(@PathVariable Long connectionId){
		if(connectionId==null) {
			throw new RuntimeException("connection_id is null");
		}
		return ResponseEntity.ok().build();
	}
}
