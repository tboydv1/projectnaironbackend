/**
 * 
 */
package com.project.nairon.service.test;

import static org.junit.jupiter.api.Assertions.*;


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
@SpringBootTest(classes = RepositoryConfig.class)
class AdvertiserWalletServiceTest {
	
	
	AdvertiserWalletService advertWalletService = new AdvertiserWalletService() ;

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

	@Test
	void testSaveAdvertiserWalletMethod() {
		
		AdvertiserWallet newWallet = new AdvertiserWallet(10090L,800.00);
		assertNotNull(newWallet);
		
		advertWalletService.saveToAdvertiserWallet(newWallet);

	}
	@Test 
	void testNull() {
		assertNotNull(advertWalletService);
	}
	

}
