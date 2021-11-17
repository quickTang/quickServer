package com.service;

import com.util.DaoFactory;
import com.zw.zcf.dao.mongo.IMongoDao;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现类
 *
 * @author tang
 */
public class TabServiceImpl {
private final IMongoDao mongoDao;


public TabServiceImpl() {
	mongoDao = DaoFactory.getMongoDao("voice");
}

/**
 * 添加
 */
public void addData(long uid, String name) {
	Map<String, Object> cond = new HashMap<String, Object>();
	cond.put("uid", uid);
	cond.put("name", name);
	mongoDao.insert(cond);
}
	
}
