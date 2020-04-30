package com.project.nairon.repository.wallet;

import com.project.nairon.models.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author oluwatobi
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
