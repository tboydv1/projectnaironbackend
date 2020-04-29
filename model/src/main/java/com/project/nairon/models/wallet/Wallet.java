/**
 * 
 */
package com.project.nairon.models.wallet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gbemisola
 *
 */
@Entity
@Table(name="cash_wallet")
public class Wallet {

	@Id
	@Column(name = "wallet_id")
	private Long walletId;

	@Column(name="wallet_balance")
	private double walletBalance;

	private String type;


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	public Wallet() {
		super();
	}


	public Wallet(Long walletId, double walletBalance) {
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
