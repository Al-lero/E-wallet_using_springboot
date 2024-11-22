package com.bankprototype.ewallet.data.repository;

import com.bankprototype.ewallet.data.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
}
