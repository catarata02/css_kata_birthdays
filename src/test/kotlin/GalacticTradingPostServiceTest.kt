import ch.kata.architecture.application.GalacticTradingPostService
import ch.kata.architecture.application.dto.Planet
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GalacticTradingPostServiceTest {

    private val galacticTradingPostService = GalacticTradingPostService()

    @Test
    fun `WHEN addPlanet() THEN the planet is correctly persisted`() {
        val planetName = "Erde"
        val planetYCoordinate = 1
        val planetXCoordinate = 2
        val expectedPlanet = persistPlanet(planetName, planetXCoordinate, planetYCoordinate)

        val addedPlanet = galacticTradingPostService.addPlanet(
            name = planetName,
            xCoordinate = planetXCoordinate,
            yCoordinate = planetYCoordinate
        )

        assertEquals(expectedPlanet, addedPlanet)
    }

    @Test
    fun `GIVEN a planet is persisted WHEN retrievePlanet() THEN the planet is correctly returned`() {
        val expectedPlanet = persistPlanet()

        val retrievedPlanet = galacticTradingPostService.retrievePlanet(expectedPlanet.name)

        assertEquals(expectedPlanet, retrievedPlanet)
    }

    @Test
    fun `GIVEN no planet persisted WHEN retrievePlanet() THEN error is thrown`() {
        assertThrows<IllegalArgumentException> { galacticTradingPostService.retrievePlanet("guguck") }
    }

    private fun persistPlanet(
        planetName: String = "Erde",
        planetXCoordinate: Int = 1,
        planetYCoordinate: Int = 2
    ): Planet {
        return galacticTradingPostService.addPlanet(
            name = planetName,
            xCoordinate = planetXCoordinate,
            yCoordinate = planetYCoordinate
        )
    }
}