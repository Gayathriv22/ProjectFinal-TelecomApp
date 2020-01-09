package com.deloitte.telecom.dao;

import com.deloitte.telecom.entity.Account;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IAccountDao {


    Account findAccountByPhone(String ph);
List<Account> fetchAccount (int blockSize);

    Account RechargeAccount(String ph, double amount);
    void exitApp();
    boolean checkCredentialsByPhone(String phone, String password);
    boolean checkCredentialsById(int id, String pw);

Account findAccountById(int id);
Account save(Account a);

}