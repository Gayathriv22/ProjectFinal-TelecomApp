package com.deloitte.telecom.service;

import com.deloitte.telecom.dao.IAccountDao;
import com.deloitte.telecom.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements IAccountService {
    private IAccountDao dao;

    public IAccountDao getDao() {
        return dao;
    }

    @Autowired
    public void setDao(IAccountDao dao) {
        this.dao = dao;
    }


    @Override
    public Account RechargeAccount(String ph, double amount) {

        Account a = dao.RechargeAccount(ph, amount);
        return a;

    }

    @Override
    public Account save(Account a) {
        return dao.save(a);
    }


    @Override
    public Account findAccountByPhone(String ph) {
        Account a = dao.findAccountByPhone(ph);
        return a;
    }


    @Override
    public void exitApp() {
        dao.exitApp();
    }

    @Override
    public boolean checkCredentialsByPhone(String phone, String password) {
        boolean correct = dao.checkCredentialsByPhone(phone, password);
        return correct;
    }

    @Override
    public boolean checkCredentialsById(int id, String pw) {
        return dao.checkCredentialsById(id, pw);
    }

    @Override
    public Account findAccountById(int id) {
        Account a = dao.findAccountById(id);
        return a;

    }

    @Override
    public List<Account> fetchAccount(int blockSize) {
        List<Account> a = dao.fetchAccount(blockSize);
        return a;
    }
}