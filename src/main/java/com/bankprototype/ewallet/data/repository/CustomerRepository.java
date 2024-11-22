package com.bankprototype.ewallet.data.repository;

import com.bankprototype.ewallet.data.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
