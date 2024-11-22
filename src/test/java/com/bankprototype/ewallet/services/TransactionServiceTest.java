package com.bankprototype.ewallet.services;

import com.bankprototype.ewallet.dto.request.TransactionRequest;
import com.bankprototype.ewallet.dto.response.TransactionResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.bankprototype.ewallet.dto.response.TransactionStatus.SUCCESS;
import static com.bankprototype.ewallet.dto.response.TransactionType.DEPOSIT;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    void testThatUserCanMakeTransaction() {

        String transactionType = DEPOSIT.toString();
        String accountNumber = "1234567890";
        BigDecimal transactionAmount = new BigDecimal("5000.00");

        TransactionRequest transactionRequest = getTransactionRequest(accountNumber, transactionAmount, transactionType);
        TransactionResponse transactionResponse = transactionService.makeTransaction(transactionRequest);
        assertNotNull(transactionResponse);
        // assertNotNull(transactionResponse.getMessage());
        assertEquals(SUCCESS.toString(), transactionResponse.getStatus());

    }

    private static TransactionRequest getTransactionRequest(String accountNumber, BigDecimal transactionAmount, String transactionType) {
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAccountNumber(accountNumber);
        transactionRequest.setTransactionAmount(transactionAmount);
        transactionRequest.setTransactionType(transactionType);
        transactionRequest.setTransactionDate(LocalDate.now());
        return transactionRequest;

    }

}