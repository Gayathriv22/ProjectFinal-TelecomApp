package com.deloitte.telecom.sessiondetails;

import com.deloitte.telecom.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class SessionData {
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
