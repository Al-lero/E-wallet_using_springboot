package com.bankprototype.ewallet.Exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String customerNotFound) {
        super(customerNotFound);

    }
}
