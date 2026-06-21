//$Id$
package com.core.redmo.service;

import java.util.*;
import com.core.redmo.repository.ConnectionRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import com.core.redmo.entity.Connections;

@Service
public class ConnectionService {
	
	private ConnectionRepository connectionRepo;
	
	
	public ConnectionService(ConnectionRepository connectionRepo) {
		this.connectionRepo=connectionRepo;
	}
	
	public Map<String,Object> getAllConnections(){
		Map<String,Object> response=new HashMap<>();
		List<Connections> list=connectionRepo.findAll();
		response.put("status","success");
		response.put("connections",list);
		response.put("message","connections list fetched successfully");
		return response;
	}
	
	public Map<String,Object> createConnection(Connections connection){
		Map<String,Object> response=new HashMap<>();
		Optional<Connections> existingConnection=connectionRepo.findByPortAndHost(connection.getPort(), connection.getHost());
		if(existingConnection.isPresent()) {
			response.put("status","error");
			response.put("message","connection already exist with given Port and Host");
			return response;
		}
		existingConnection=connectionRepo.findByConnectionName(connection.getConnectionName());
		if(existingConnection.isPresent()) {
			response.put("status","error");
			response.put("message","connection already exist with given connection name");
			return response;
		}
		connectionRepo.save(connection);
		response.put("status","success");
		response.put("connection",connection);
		response.put("message","connection created successfully");
		return response;
	}
	
	public Map<String,Object> updateConnection(long connectionId,Connections connection){
		Map<String,Object> response=new HashMap<>();
		Connections existingConnection=connectionRepo.findById(connectionId)
				.orElseThrow(()->new RuntimeException("No resource found with given connection_id"));
		if(connection.getConnectionName()!=null) {
			existingConnection.setConnectionName(connection.getConnectionName());
		}
		if(connection.getHost()!=null) {
			existingConnection.setHost(connection.getHost());
		}
		if(connection.getPort()!=0) {
			existingConnection.setPort(connection.getPort());
		}
		if(connection.getRedisUserName()!=null) {
			existingConnection.setRedisUserName(connection.getRedisUserName());
		}
		if(connection.getRedisPassword()!=null) {
			existingConnection.setRedisPassword(connection.getRedisPassword());
		}
		connectionRepo.save(existingConnection);
		response.put("status","success");
		response.put("message","connection updated successfully");
		return response;
	}
	
	public Map<String,Object> deleteConnection(long connectionId){
		Map<String,Object> response=new HashMap<>();
		Connections existingConnection=connectionRepo.findById(connectionId)
				                       .orElseThrow(()->new RuntimeException("No resource found with given connection_id"));
		connectionRepo.delete(existingConnection);
		response.put("status","success");
		response.put("message","connection deleted successfully");
		return response;
	}
	
	public Map<String,Object> establishConnection(long connectionId){
		Map<String,Object> response=new HashMap<>();
		return response;
	}
}
