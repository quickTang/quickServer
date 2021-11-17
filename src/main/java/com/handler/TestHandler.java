package com.handler;

import com.service.TabServiceImpl;
import com.zw.zcf.command.Command;
import com.zw.zcf.command.Response;
import com.zw.zcf.command.handler.MultiCommandHandler;

/**
 * 测试类
 *
 * @author tangyong
 */
public class TestHandler extends MultiCommandHandler {
private TabServiceImpl tabServiceImpl = new TabServiceImpl();

public void add(Command cmd) {
	try {
		Long uid = cmd.getLongParam("uid");
		String name = cmd.getStringParam("name");
		//有mongodb的同学，放开下面的注释即可入库。
//		tabServiceImpl.addData(uid, name);
		Response response = new Response();
		response.addValue("status", "200");
		cmd.setResponse(response);
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	
}

public void get(Command cmd) {
	try {
		
		Response response = new Response();
		response.addValue("status", "200");
		cmd.setResponse(response);
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	
}
}
