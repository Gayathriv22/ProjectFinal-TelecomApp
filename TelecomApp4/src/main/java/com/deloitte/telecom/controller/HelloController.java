package com.deloitte.telecom.controller;

import com.deloitte.telecom.entity.Account;
import com.deloitte.telecom.exceptions.PhoneNumberAlreadyExistsException;
import com.deloitte.telecom.service.IAccountService;


import com.deloitte.telecom.sessiondetails.SessionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HelloController {
    private static Logger Log = LoggerFactory.getLogger(HelloController.class);
    private IAccountService service;
    private SessionData sessionData;

    public SessionData getSessionData() {
        return sessionData;
    }

    @Autowired
    public void setSessionData(SessionData sessionData) {
        this.sessionData = sessionData;
    }

    public IAccountService getService() {
        return service;
    }

    @Autowired
    public void setService(IAccountService service) {
        this.service = service;
    }


    @GetMapping("/userinput")
    public ModelAndView userInput() {
        return new ModelAndView(("userinput"));
    }

    @GetMapping("/logincheck")
    public RedirectView checkUserLogin(@RequestParam("phone") String ph,
                                       @RequestParam("password") String password) {
        System.out.println("inside login check");
        boolean correct = service.checkCredentialsByPhone(ph, password);
        if (!correct) {
            return new RedirectView("/userinput");

        } else {
            Account a = service.findAccountByPhone(ph);
            sessionData.setAccount(a);
            return new RedirectView("/home");
        }
    }

    @GetMapping("/home")
    public Object home() {
        System.out.println("inside home page");
        if (sessionData.getAccount() == null) {
            return new RedirectView("/userinput");
        }
        Account acc = sessionData.getAccount();
        ModelAndView mv = new ModelAndView("home", "user", acc);
        return mv;
    }

    @GetMapping("/processregister")
    public RedirectView processregister(@RequestParam("phone") String ph,
                                        @RequestParam("name") String name, @RequestParam("acctype") String at,
                                        @RequestParam("password") String password) {
        System.out.println("inside process register");

        Account a = new Account(ph, name, at, password);
        a = service.save(a);
        sessionData.setAccount(a);
        System.out.println("after register, to home");
        return new RedirectView("/home");

    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("/register");
    }

    @GetMapping("/recharge")
    public ModelAndView dorecharge() {
        return new ModelAndView("/recharge");
    }
    @GetMapping("/signout")
    public RedirectView signout() {
        sessionData.setAccount(null);
        return new RedirectView("/userinput");
    }

    @GetMapping("/processrecharge")
    public RedirectView processrecharge(@RequestParam("phone") String ph, @RequestParam("amount") double amount) {

        System.out.println("inside recharge page");

        Account a = service.RechargeAccount(ph,amount);

        sessionData.setAccount(a);
        System.out.println("after recharge, to home");
        return new RedirectView("/home");}

        @GetMapping("/error")
        public ModelAndView error () {
            return new ModelAndView("error", "message", "Something went wrong!");
        }

        @ExceptionHandler(PhoneNumberAlreadyExistsException.class)
        public ModelAndView handleIfMobileNumberAlreadyExists (PhoneNumberAlreadyExistsException e){
            return new ModelAndView("error", "message", "mobile number already exists");
        }

        @ExceptionHandler(value = Throwable.class)
        public ModelAndView catchAll (Throwable e){
            e.printStackTrace();
            return new ModelAndView("error", "message", "Something went wrong");
        }
    }
