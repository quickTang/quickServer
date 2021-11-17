package com.util;

import com.ServerConfig;
import com.zw.zcf.dao.mongo.IMongoDao;
import com.zw.zcf.dao.mongo.factory.MongoDaoFactory;

/**
 * Dao工厂
 * @author tang
 */
public class DaoFactory {
private static ServerConfig config = ServerConfig.getServerConfig();

public static IMongoDao getMongoDao(String table) {
	MongoDaoFactory.warnLogTimeThreshold = 1000;
	return MongoDaoFactory.getMongoDao(config.getMongoHost(), config.getMongoDbName(), table, "", "");
}
}
