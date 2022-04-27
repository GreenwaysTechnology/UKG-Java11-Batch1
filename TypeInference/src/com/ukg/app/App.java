package com.ukg.app;

import java.util.ArrayList;
import java.util.stream.Collectors;

interface Flyable {
    void fly();
}

@FunctionalInterface
interface MyFunction {
    void doStuff();
}

class FlightService {
    //var is not allowed inside classes: instance variables and static variables cant be marked with var
    // var  test;
    public String getFilghtDetails() {
//        String filghtNo = "111";
//        String airLine = "Indio";
//        double ticketPrice = 1000;
        //without type we can declare variables
        var flightNo = "111";
        var airLine = "Indio";
        var ticketPrice = 1000;
        //flightNo =13;
        var list = new ArrayList<String>();
        list.add("Ticket 1");
        //
        var stream = list.stream();
        var ticketList = stream.filter(items -> items.contains("Ticket 1")).collect(Collectors.toList());
        ticketList.forEach(System.out::println);

        return flightNo + airLine + ticketPrice;
    }

}

class Flight implements Flyable {
    @Override
    public void fly() {
        System.out.println("Flight is flying");
    }
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }
}

public class App {
    public static void main(String[] args) {
        //FlightService flightService = new FlightService();
        var flightService = new FlightService();
        System.out.println(flightService.getFilghtDetails());
        //inside loop
        for (var i = 0; i < 10; i++) {
            System.out.println(i);
        }
        //For Each
        var list = new ArrayList<Integer>();
        list.add(12);
        list.add(45);
        list.add(444);
        for (var value : list) {
            System.out.println(value);
        }
        //  var j; //must be initalized

        //var cant infer null
//        var flyable = null;
//        flyable = new Flight();
//        flyable.fly();
//        flyable = new Bird();
//        flyable.fly();
        // var cant be used for dynamic object binding
//        var flyable = new Flight();
//        flyable.fly();
//        flyable = new Bird();
//        flyable.fly();

        var myFunction = new MyFunction() {
            @Override
            public void doStuff() {
                System.out.println("do Stuff lambda");
            }
        };
        myFunction.doStuff();
        //lambdas cant be declared with var
//        var myLambda = () -> System.out.println("do Stuff lambda");
//        myLambda.doStuff();
    }
}
