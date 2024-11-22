package com.bankprototype.ewallet.services;

import com.bankprototype.ewallet.Exceptions.WalletNotFoundException;
import com.bankprototype.ewallet.dto.request.WalletDepositRequest;
import com.bankprototype.ewallet.dto.response.WalletDepositResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WalletServiceTest {

    @Autowired
    private WalletService walletService;

    @Test
    //@Sql(scripts = {"/db/data.sql"})
    public void testThatWalletServiceCanDeposit() throws WalletNotFoundException {
        Long walledId = 200L;
        BigDecimal depositAmount = new BigDecimal("5000.00");
        WalletDepositRequest walletDepositRequest = new WalletDepositRequest();
        walletDepositRequest.setId(walledId);
        walletDepositRequest.setAmount(depositAmount);

        WalletDepositResponse walletDepositResponse = walletService.deposit(walletDepositRequest);
        assertNotNull(walletDepositResponse);
        assertNotNull(walletDepositResponse.getStatus());
        assertEquals("SUCCESS", walletDepositResponse.getStatus());


    }

}