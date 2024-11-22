package com.bankprototype.ewallet.services;

import com.bankprototype.ewallet.Exceptions.UserNotFoundException;
import com.bankprototype.ewallet.Exceptions.WalletNotFoundException;
import com.bankprototype.ewallet.dto.request.DepositRequest;
import com.bankprototype.ewallet.dto.response.DepositResponse;
import com.bankprototype.ewallet.dto.response.TransactionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static com.bankprototype.ewallet.dto.response.TransactionStatus.SUCCESS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionService transactionService;

    @Test
    void testThatCustomerCanDeposit() throws UserNotFoundException, WalletNotFoundException {
        Long customerId = 201L;
        BigDecimal depositAmount = new BigDecimal("1000.00");
        String description = "this is just a test for deposit";
        DepositRequest depositRequest = buildDepositRequest(customerId, depositAmount, description);
        DepositResponse depositResponse = customerService.deposit(depositRequest);
        assertNotNull(depositResponse);
        assertNotNull(depositResponse.getMessage());
        assertEquals(SUCCESS.toString(), depositResponse.getStatus());


    }

    private static DepositRequest buildDepositRequest(Long customerId, BigDecimal depositAmount, String description) {
        DepositRequest depositRequest = new DepositRequest();
        depositRequest.setCustomerId(customerId);
        depositRequest.setAmount(depositAmount);
        depositRequest.setDescription(description);
        return depositRequest;
    }

    @Test
    void testThatTransactionIsCreatedForDeposit() throws UserNotFoundException, WalletNotFoundException {
        DepositRequest depositRequest = buildDepositRequest(201L, BigDecimal.valueOf(1000), "this is just a test for deposit");
        DepositResponse depositResponse = customerService.deposit(depositRequest);
        TransactionResponse transactionResponse = transactionService.getTransactionBy(depositResponse.getTransactionId());
        assertThat(transactionResponse).isNotNull();

    }
}