package org.rockyang.blockchain;

import org.rockyang.blockchain.account.Account;
import org.rockyang.blockchain.account.Personal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author yangjian
 * @since 2019-06-03 下午5:18.
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

	static Logger logger = LoggerFactory.getLogger(MyApplicationRunner.class);

	@Autowired
	private Personal personal;

	@Override
	public void run(ApplicationArguments arguments) throws Exception
	{
		// 首次运行，执行一些初始化的工作
		File lockFile = new File("block-data/blockchain.lock");
		if (!lockFile.exists()) {
			lockFile.createNewFile();
			// 创建默认钱包地址（挖矿地址）
			Account coinBase = personal.createCoinBase();
			logger.info("Create coinbase address : " + coinBase.getAddress());
		}

	}

}
