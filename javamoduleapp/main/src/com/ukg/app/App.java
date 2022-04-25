package com.ukg.app;

import com.mycom.greeter.Greeter;
import com.ukg.hai.HaiService;

public class App {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
        HaiService haiService = new HaiService();
        System.out.println(haiService.sayHai());
    }
}
