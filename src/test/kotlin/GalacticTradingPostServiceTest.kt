import ch.kata.architecture.application.dto.Commodity
import ch.kata.architecture.application.GalacticTradingPostService
import ch.kata.architecture.application.dto.Planet
import ch.kata.architecture.application.dto.TradeRoute
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GalacticTradingPostServiceTest {

    private val galacticTradingPostService = GalacticTradingPostService()

    @Nested
    @DisplayName("Tests for planet features")
    inner class PlanetTests {
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

    }

    @Nested
    @DisplayName("Tests for commodity operations")
    inner class CommodityTests {
        @Test
        fun `WHEN addCommodity() THEN the commodity is correctly persisted`() {
            val commodityName = "Mars Steak"
            val commodityPrice = 23.45
            val expectedCommodity = Commodity(name = commodityName, price = commodityPrice)

            val addedCommodity = persistCommodity(commodityName, commodityPrice)

            assertEquals(expectedCommodity, addedCommodity)
        }

        @Test
        fun `GIVEN a commodity is persisted WHEN retrieveCommodity() THEN the commodity is correctly returned`() {
            val expectedCommodity = persistCommodity()

            val retrievedPlanet = galacticTradingPostService.retrieveCommodity(expectedCommodity.name)

            assertEquals(expectedCommodity, retrievedPlanet)
        }


    }

    @Nested
    @DisplayName("Tests for trade route operations")
    inner class TradeRouteTests {

        @Test
        fun `WHEN addTradeRoute() THEN the trade route is correctly persisted`() {
            val planetErdeName = "Erde"
            val planetOne = persistPlanet(planetName = planetErdeName, planetXCoordinate = 1, planetYCoordinate = 1)
            val planetMarsName = "Mars"
            val planetTwo = persistPlanet(planetName = planetMarsName, planetXCoordinate = 1, planetYCoordinate = 2)
            val expectedTradeRoute = TradeRoute(planets = Pair(first = planetOne, second = planetTwo))

            val addedTradeRoute = galacticTradingPostService.addTradeRoute(planetErdeName, planetMarsName)

            assertEquals(expectedTradeRoute, addedTradeRoute)
        }

        @Test
        fun `GIVEN wrong order of planets WHEN addTradeRoute() THEN the trade route is correctly persisted`() {
            val planetErdeName = "Erde"
            val planetOne = persistPlanet(planetName = planetErdeName, planetXCoordinate = 1, planetYCoordinate = 1)
            val planetMarsName = "Mars"
            val planetTwo = persistPlanet(planetName = planetMarsName, planetXCoordinate = 1, planetYCoordinate = 2)
            val expectedTradeRoute = TradeRoute(planets = Pair(first = planetOne, second = planetTwo))

            val addedTradeRoute = galacticTradingPostService.addTradeRoute(planetMarsName, planetErdeName)

            assertEquals(expectedTradeRoute, addedTradeRoute)
        }

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


    private fun persistCommodity(
        commodityName: String = "Mars Steak",
        commodityPrice: Double = 5.45,

        ): Commodity {
        return galacticTradingPostService.addCommodity(
            name = commodityName,
            price = commodityPrice
        )
    }

}