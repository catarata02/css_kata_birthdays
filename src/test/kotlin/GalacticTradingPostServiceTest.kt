import ch.kata.architecture.application.GalacticTradingPostService
import ch.kata.architecture.application.dto.Planet
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GalacticTradingPostServiceTest {

    private val galacticTradingPostService = GalacticTradingPostService()

    @Test
    fun `GIVEN a GalacticTradingPostService WHEN addPlanet() THEN the planet is correctly persisted`() {
        val planetName = "Erde"
        val planetYCoordinate = 1
        val planetXCoordinate = 2
        val expectedPlanet = Planet(name = planetName, xCoordinate = planetXCoordinate, yCoordinate = planetYCoordinate)

        val addedPlanet = galacticTradingPostService.addPlanet(
            name = planetName,
            xCoordinate = planetXCoordinate,
            yCoordinate = planetYCoordinate
        )

        assertEquals(expectedPlanet, addedPlanet)
    }
}