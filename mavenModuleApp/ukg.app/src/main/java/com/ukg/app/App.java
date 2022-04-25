package com.ukg.app;

import com.ukg.CustomerService;

public class App {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        System.out.println(customerService.findAll());
    }
}
