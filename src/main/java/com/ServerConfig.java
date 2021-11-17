/**
 *
 */
package com;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.beans.PropertyDescriptor;

/**
 * 配置文件初始化
 * @author tang
 */
public class ServerConfig {

private static final ServerConfig serverConfig = new ServerConfig();

public static ServerConfig getServerConfig() {
	return serverConfig;
}

private ServerConfig() {
	try {
		PropertiesConfiguration configuration = new PropertiesConfiguration("server.properties");
		PropertyDescriptor[] propertiesArray = PropertyUtils.getPropertyDescriptors(ServerConfig.class);
		for (PropertyDescriptor propertyDescriptor : propertiesArray) {
			Class<?> type = propertyDescriptor.getPropertyType();
			String name = propertyDescriptor.getName();
			if (type == int.class) {
				PropertyUtils.setProperty(this, name, configuration.getInt(name));
			} else if (type == String.class) {
				PropertyUtils.setProperty(this, name, configuration.getString(name));
			}
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

private String mongoHost;
private String mongoDbName;
private String httpServerHost;
private int httpServerPort;

public String getMongoHost() {
	return mongoHost;
}

public void setMongoHost(String mongoHost) {
	this.mongoHost = mongoHost;
}

public String getMongoDbName() {
	return mongoDbName;
}

public void setMongoDbName(String mongoDbName) {
	this.mongoDbName = mongoDbName;
}

public String getHttpServerHost() {
	return httpServerHost;
}

public void setHttpServerHost(String httpServerHost) {
	this.httpServerHost = httpServerHost;
}

public int getHttpServerPort() {
	return httpServerPort;
}

public void setHttpServerPort(int httpServerPort) {
	this.httpServerPort = httpServerPort;
}
	
	
}
