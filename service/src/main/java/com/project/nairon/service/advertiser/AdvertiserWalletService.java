/**
 * 
 */
package com.project.nairon.service.advertiser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.nairon.models.advertiser.AdvertiserWallet;
import com.project.nairon.repository.advertiser.AdvertiserWalletRepository;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;


/**
 * @author gbemisola
 *
 */
@Service
public class AdvertiserWalletService {


	@Autowired
	AdvertiserWalletRepository repo;


	public void saveToAdvertiserWallet(AdvertiserWallet advertiserWallet) {
		//use logger here -- TOBI
		System.out.print("Hello");
		repo.save(advertiserWallet);
	}
	


}
