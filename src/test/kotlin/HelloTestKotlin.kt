import ch.kata.architecture.adapter.GreetingAdapterKotlin
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class HelloTestKotlin{
    val hello = GreetingAdapterKotlin()

    @Test
    fun `GIVEN hello when say() THEN world is returned`() {
        val actual = hello.greet()

        assertEquals("world", actual)
    }
}