//$Id$
package com.core.redmo.connections;

public class Connection {
	 
	private ConnectionHandler handler=null;
	
	public Connection() {
		this.handler = new ConnectionHandler();
	}
	
	public ConnectionHandler getHandler() {
		return this.handler;
	}
	
}
