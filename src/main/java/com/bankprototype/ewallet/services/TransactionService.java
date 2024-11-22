package com.bankprototype.ewallet.services;

import com.bankprototype.ewallet.dto.request.TransactionRequest;
import com.bankprototype.ewallet.dto.response.TransactionResponse;

public interface TransactionService {
    TransactionResponse makeTransaction(TransactionRequest transactionRequest);

    TransactionResponse getTransactionBy(Long transactionId);
}
