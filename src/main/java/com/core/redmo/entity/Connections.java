//$Id$
package com.core.redmo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Connections")
public class Connections {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="connection_id")
	private Long connectionId;
	
	@Column(name="connection_name")
	private String connectionName;
	
	@Column(name="host")
    private String host;
	
	@Column(name="port")
	private int port;
	
	@Column(name="redis_username")
	private String redisUserName;
	
	@Column(name="redis_password")
	private String redisPassword;
	
	public Long getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(Long connectionId) {
		this.connectionId = connectionId;
	}

	public String getConnectionName() {
		return connectionName;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getRedisUserName() {
		return redisUserName;
	}

	public void setRedisUserName(String redisUserName) {
		this.redisUserName = redisUserName;
	}

	public String getRedisPassword() {
		return redisPassword;
	}

	public void setRedisPassword(String redisPassword) {
		this.redisPassword = redisPassword;
	}
		
}
