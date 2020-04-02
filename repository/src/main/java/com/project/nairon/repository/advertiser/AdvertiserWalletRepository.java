/**
 * 
 */
package com.project.nairon.repository.advertiser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.nairon.models.advertiser.AdvertiserWallet;

/**
 * @author gbemisola
 *
 */
@Repository
@Transactional
public interface AdvertiserWalletRepository extends JpaRepository<AdvertiserWallet, Long> {}
