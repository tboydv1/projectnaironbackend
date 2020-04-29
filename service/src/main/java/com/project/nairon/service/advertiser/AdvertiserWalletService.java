/**
 * 
 */
package com.project.nairon.service.advertiser;

import com.project.nairon.repository.wallet.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.nairon.models.wallet.Wallet;


/**
 * @author gbemisola
 *
 */
@Service
public class AdvertiserWalletService {


	@Autowired
	WalletRepository walletRepository;


	public void saveToAdvertiserWallet(Wallet advertiserWallet) {
		//use logger here -- TOBI
		System.out.print("Hello");
		walletRepository.save(advertiserWallet);
	}
	


}
