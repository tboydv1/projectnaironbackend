/**
 * 
 */
package com.project.nairon.models.wallet;

import com.project.nairon.models.naironuser.NaironUser;
import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;

/**
 * @author gbemisola
 *
 */
@Entity
@Table(name="cash_wallet")
@Data
public class Wallet {

	@Id
	@Column(name = "wallet_id")
	private Long walletId;

	@Column(name="wallet_balance")
	private double walletBalance;

	private String type;

	private String name;

	@OneToOne()
	@JoinColumn(name = "nairon_user_id", referencedColumnName = "id")
	private NaironUser naironUser;
	
	
}
