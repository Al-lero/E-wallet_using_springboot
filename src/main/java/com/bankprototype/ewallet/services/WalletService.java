package com.bankprototype.ewallet.services;

import com.bankprototype.ewallet.Exceptions.WalletNotFoundException;
import com.bankprototype.ewallet.dto.request.WalletDepositRequest;
import com.bankprototype.ewallet.dto.response.WalletDepositResponse;

public interface WalletService {
    WalletDepositResponse deposit(WalletDepositRequest walletDepositRequest) throws WalletNotFoundException;
}
