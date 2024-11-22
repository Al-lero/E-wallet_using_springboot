package com.bankprototype.ewallet.services;

import com.bankprototype.ewallet.Exceptions.UserNotFoundException;
import com.bankprototype.ewallet.Exceptions.WalletNotFoundException;
import com.bankprototype.ewallet.data.models.Customer;
import com.bankprototype.ewallet.data.models.Wallet;
import com.bankprototype.ewallet.data.repository.CustomerRepository;
import com.bankprototype.ewallet.dto.request.DepositRequest;
import com.bankprototype.ewallet.dto.request.TransactionRequest;
import com.bankprototype.ewallet.dto.request.WalletDepositRequest;
import com.bankprototype.ewallet.dto.response.DepositResponse;
import com.bankprototype.ewallet.dto.response.WalletDepositResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WolletCustomerService implements CustomerService{

    private final CustomerRepository customerRepository;
    private final WalletService walletService;
    private final ModelMapper modelMapper;
    private final TransactionService transactionsService;


    @Override
    public DepositResponse deposit(DepositRequest depositRequest) throws UserNotFoundException, WalletNotFoundException {
        //1. Retrieve the customer
        Customer customer = customerRepository.findById(depositRequest.getCustomerId())
                .orElseThrow(()-> new UserNotFoundException(
                        String.format("Customer with id %d not found", depositRequest.getCustomerId())));
        //2. obtains the customer wallet
        Wallet customerWallet = customer.getWallet();
        WalletDepositRequest walletDepositRequest = createWalletDepositRequest(depositRequest, customerWallet);

        //3. Deposit into the customers wallet
        WalletDepositResponse response = walletService.deposit(walletDepositRequest);
        var depositResponse = modelMapper.map(response, DepositResponse.class);
        // TransactionRequest
        transactionsService.makeTransaction(modelMapper.map(depositRequest, TransactionRequest.class));
        depositResponse.setMessage("deposit successful");
        return depositResponse;
    }

    private static WalletDepositRequest createWalletDepositRequest(DepositRequest depositRequest, Wallet customerWallet) {
        WalletDepositRequest walletDepositRequest = new WalletDepositRequest();
        walletDepositRequest.setId(customerWallet.getId());
        walletDepositRequest.setAmount(depositRequest.getAmount());
        return walletDepositRequest;

    }

}
