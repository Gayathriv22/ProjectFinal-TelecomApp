package com.deloitte.telecom.dao;

import com.deloitte.telecom.entity.Account;
import com.deloitte.telecom.exceptions.AccountNotFoundException;
import com.deloitte.telecom.exceptions.InvalidPhoneNumberException;
import com.deloitte.telecom.exceptions.PhoneNumberAlreadyExistsException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class AccountDaoImpl implements IAccountDao {
   // Map<String, Account> store = new HashMap<>();
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void validatePhoneNumber(String ph) {
        if (ph == null || (ph.length() != 10)) {
            throw new InvalidPhoneNumberException("Invalid Phone Number!!!");
        }
    }

    public void validateAccount(Account a) {
        if (a == null) {
            throw new AccountNotFoundException("No account found!!");
        }
    }
    @Override
    public Account RechargeAccount(String ph, double amount) {
        validatePhoneNumber(ph);
        Account a = findAccountByPhone(ph);
        validateAccount(a);
        double bal = a.getBalance();
        bal = bal + amount;
        a.setBalance(bal);
        return a;


    }

    @Override
    public Account save(Account a) {
        System.out.println("inside save, account: " +a);
        String ph = a.getPhoneNo();
        boolean exists = phoneNumberExists(ph);
        if(exists){
            throw new PhoneNumberAlreadyExistsException("Mobile Number Already Exists!!");
        }
       a = getEntityManager().merge(a);
        return a;

    }

    @Override
    public List<Account> fetchAccount(int blockSize) {
        String jql = "from Account";
        TypedQuery<Account> query = entityManager.createQuery(jql, Account.class);
        query.setMaxResults(blockSize);
        List<Account> list = query.getResultList();
        return list;
    }
    public  boolean phoneNumberExists(String ph){
        Account a = findAccountByPhone(ph);
        return a != null;
    }

    @Override
    public Account findAccountByPhone(String ph) {

        try {

            String jql = "from Account where phoneNo=:mob";
            TypedQuery<Account> query = entityManager.createQuery(jql, Account.class);
            query.setParameter("mob", ph);
            Account result = query.getSingleResult();
            return result;
        }catch (NoResultException e){
            return null;
        }

    }
    @Override
    public Account findAccountById(int id){
        Account a = entityManager.find(Account.class, id);
        return a;
    }



    @Override
    public void exitApp() {
        System.out.println("Exiting...."); //need to edit code
    }

    @Override
    public boolean checkCredentialsByPhone(String phone, String password) {
        Account a = findAccountByPhone(phone);
        if (a == null) {
            return false;
        }
        return a.getPassword().equals(password);
    }

    @Override
    public boolean checkCredentialsById(int id, String pw) {
        Account acc = entityManager.find(Account.class, id);
        if (acc == null) {
            return false;
        }
        return acc.getPassword().equals(pw);
    }
}