/**
 * 
 */
package com.project.nairon.service.test;


import com.project.nairon.ServiceConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.nairon.service.advertiser.AdvertiserWalletService;


/**
 * @author gbemisola
 *
 */

@SpringBootTest(classes = ServiceConfig.class)
class WalletServiceTest {
	

	@Autowired
	AdvertiserWalletService advertWalletService;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	
	

}
