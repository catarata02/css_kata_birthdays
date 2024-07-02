package ch.kata.architecture.adapter

import ch.kata.architecture.application.GreetingPortKotlin

class GreetingAdapterKotlin : GreetingPortKotlin {
    
    override fun greet(): String {
        return "Hello World"
    }
}
