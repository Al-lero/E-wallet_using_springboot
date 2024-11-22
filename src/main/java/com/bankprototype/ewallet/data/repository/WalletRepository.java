package com.bankprototype.ewallet.data.repository;

import com.bankprototype.ewallet.data.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
