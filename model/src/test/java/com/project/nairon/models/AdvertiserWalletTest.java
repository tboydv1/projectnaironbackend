/**
 * 
 */
package com.project.nairon.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.nairon.models.advertiser.AdvertiserWallet;

/**
 * @author gbemisola
 *
 */
class AdvertiserWalletTest {
	
   AdvertiserWallet advertiserWallet = new AdvertiserWallet();;
	
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
	void testMyWalletObject() {
		assertNotNull(advertiserWallet);
	}

}
