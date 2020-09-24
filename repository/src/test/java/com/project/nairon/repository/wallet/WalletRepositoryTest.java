/**
 * 
 */
package com.project.nairon.repository.wallet;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.nairon.models.wallet.Wallet;
import com.project.nairon.repository.RepositoryConfig;

/**
 * @author gbemisola
 *
 */
@SpringBootTest(classes = RepositoryConfig.class)
class WalletRepositoryTest {


	@Autowired
	WalletRepository walletRepository;

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
//		Wallet newWallet = new Wallet(10L,60.00);
//		walletRepository.save(newWallet);
//		assertEquals(60.00, newWallet.getWalletBalance());
	}

}
