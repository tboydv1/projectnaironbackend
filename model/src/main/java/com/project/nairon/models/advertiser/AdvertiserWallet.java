/**
 * 
 */
package com.project.nairon.models.advertiser;

import javax.persistence.Column;
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
	@Column(name = "wallet_id")
	private Long walletId;

	@Column(name="wallet_balance")
	private double walletBalance;
	
	
	
	public AdvertiserWallet() {
		super();
	}


	public AdvertiserWallet(Long walletId, double walletBalance) {
		super();
		this.walletId = walletId;
		this.walletBalance = walletBalance;
	}
	
	
	public Long getWalletId() {
		return walletId;
	}
	public void setWalletId(Long wallet_id) {
		this.walletId = wallet_id;
	}
	public double getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(double wallet_balance) {
		this.walletBalance = wallet_balance;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdvertiserWallet [walletId=");
		builder.append(walletId);
		builder.append(", walletBalance=");
		builder.append(walletBalance);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
