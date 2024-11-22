package com.bankprototype.ewallet.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class WalletDepositRequest {
    private Long id;
    private BigDecimal amount;
    public String status;


}
