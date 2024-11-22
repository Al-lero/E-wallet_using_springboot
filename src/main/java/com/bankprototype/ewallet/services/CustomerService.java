package com.bankprototype.ewallet.services;

import com.bankprototype.ewallet.Exceptions.UserNotFoundException;
import com.bankprototype.ewallet.Exceptions.WalletNotFoundException;
import com.bankprototype.ewallet.dto.request.DepositRequest;
import com.bankprototype.ewallet.dto.response.DepositResponse;

public interface CustomerService {
    DepositResponse deposit(DepositRequest depositRequest) throws UserNotFoundException, WalletNotFoundException;
}
