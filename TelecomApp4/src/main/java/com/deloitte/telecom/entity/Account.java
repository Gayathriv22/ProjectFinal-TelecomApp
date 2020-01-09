package com.deloitte.telecom.entity;

import javax.persistence.*;

@Entity
@Table(name = "mobileaccounts")
public class Account {
    @Id
    @GeneratedValue
    private int id;

    private String phoneNo;

    private String name;
    private double balance;
    private String accType;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public Account(String phoneNo, String name, String accType, String pw) {
        this.phoneNo = phoneNo;
        this.name = name;
        this.balance = 100;
        this.accType = accType;
        this.password = pw;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Account)) {
            return false;
        }
        Account that = (Account) o;
        return that.phoneNo.equals(this.phoneNo);
    }


}