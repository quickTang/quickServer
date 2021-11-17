package com;

import com.handler.TestHandler;
import com.zw.zcf.command.executor.SimpleCommandExecutor;
import com.zw.zcf.server.HttpServer;
import org.apache.log4j.Logger;

/**
 * 启动入口
 * @author tang
 */
public class BootstrapServer {
private static ServerConfig config = ServerConfig.getServerConfig();

private static Logger logger = Logger.getLogger(BootstrapServer.class);
public static void main(String[] args) throws Exception {
	SimpleCommandExecutor httpExecutor = new SimpleCommandExecutor();
	// 注册handler
	httpExecutor.registerRegexHandler("test", new TestHandler());
	
	// 启动一个HTTP服务器，默认是netty
	new HttpServer(config.getHttpServerHost(), config.getHttpServerPort(), httpExecutor).start();
	System.out.println(config.getHttpServerHost() + "---service started!!!");
	
	// chrome url demo
	// 添加：http://127.0.0.1:7081/test?m=add&id=1
	// 删除：http://127.0.0.1:7081/test?m=del&id=1
	// 修改：http://127.0.0.1:7081/test?m=update&id=1&newId=2
	// 查询单条：http://127.0.0.1:7081/test?m=get&id=1
	// 查询多条：http://127.0.0.1:7081/test?m=getList&id=1&page=1
}
}