import ch.kata.architecture.application.GalacticTradingPostService
import ch.kata.architecture.application.dto.Planet
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GalacticTradingPostServiceTest {

    private val galacticTradingPostService = GalacticTradingPostService()

    @Test
    fun `GIVEN a GalacticTradingPostService WHEN addPlanet() THEN the planet is correctly persisted`() {
        val newPlanet: Planet = Planet("Erde", 1, 1)

        val addedPlanet = galacticTradingPostService.addPlanet(newPlanet)

        assertEquals(newPlanet, addedPlanet)
    }
}