/**
 * 
 */
package com.project.nairon.models.advertiser;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gbemisola
 *
 */
@Entity
@Table(name="advertiser_wallet")
public class AdvertiserWallet {

	@Id
	private Long wallet_id;
	
	private double wallet_balance;
	
	
	
	public AdvertiserWallet() {
		super();
	}


	public AdvertiserWallet(Long wallet_id, double wallet_balance) {
		super();
		this.wallet_id = wallet_id;
		this.wallet_balance = wallet_balance;
	}
	
	
	public Long getWalletId() {
		return wallet_id;
	}
	public void setWalletId(Long wallet_id) {
		this.wallet_id = wallet_id;
	}
	public double getWalletBalance() {
		return wallet_balance;
	}
	public void setWalletBalance(double wallet_balance) {
		this.wallet_balance = wallet_balance;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdvertiserWallet [walletId=");
		builder.append(wallet_id);
		builder.append(", walletBalance=");
		builder.append(wallet_balance);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
