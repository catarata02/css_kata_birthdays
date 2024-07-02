import ch.kata.architecture.adapter.GreetingAdapter;
import ch.kata.architecture.adapter.GreetingAdapterKotlin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingAdapterTestJava {

    private GreetingAdapter greetingAdapter = new GreetingAdapter();

    @Test
    void test_Hello_say() {
        String result = greetingAdapter.greet();

        assertEquals("Hello World", result);
    }

}