package com.deloitte.telecom.service;

import com.deloitte.telecom.entity.Account;

import java.util.List;


public interface IAccountService {


    Account findAccountByPhone(String ph);
    Account RechargeAccount(String ph, double amount);

    void exitApp();
    List<Account> fetchAccount (int blockSize);


    boolean checkCredentialsByPhone(String phone, String password);
    boolean checkCredentialsById(int id, String pw);

Account findAccountById(int id);
    Account save(Account a);

}