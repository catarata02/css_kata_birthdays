package ch.kata.architecture.adapter;


import ch.kata.architecture.application.GreetingPort;

public class GreetingAdapter implements GreetingPort {

    @Override
    public String greet() {
        return "Hello World";
    }
}
