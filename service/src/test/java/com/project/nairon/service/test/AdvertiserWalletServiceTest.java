/**
 * 
 */
package com.project.nairon.service.test;

import static org.junit.jupiter.api.Assertions.*;


import com.project.nairon.ServiceConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.nairon.models.advertiser.AdvertiserWallet;
import com.project.nairon.repository.RepositoryConfig;
import com.project.nairon.service.advertiser.AdvertiserWalletService;


/**
 * @author gbemisola
 *
 */

@SpringBootTest(classes = ServiceConfig.class)
class AdvertiserWalletServiceTest {
	

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
