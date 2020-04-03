/**
 * 
 */
package com.project.nairon.repository.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.nairon.models.advertiser.AdvertiserWallet;
import com.project.nairon.repository.RepositoryConfig;
import com.project.nairon.repository.advertiser.AdvertiserWalletRepository;

/**
 * @author gbemisola
 *
 */
@SpringBootTest(classes = RepositoryConfig.class)
class AdvertiserWalletRepositoryTest {


	@Autowired
	AdvertiserWalletRepository repo;

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
	void test() {
		AdvertiserWallet newWallet = new AdvertiserWallet(10L,60.00);
		repo.save(newWallet);
		assertEquals(60.00, newWallet.getWalletBalance());
	}

}
