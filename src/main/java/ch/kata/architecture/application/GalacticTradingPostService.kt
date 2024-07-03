package ch.kata.architecture.application

import ch.kata.architecture.application.dto.Commodity
import ch.kata.architecture.application.dto.Planet
import ch.kata.architecture.application.dto.TradeRoute

class GalacticTradingPostService {

    private val commodityService = CommodityService()
    private val planetService = PlanetService()
    private val tradeRouteService = TradeRouteService()

    fun addPlanet(name: String, xCoordinate: Int, yCoordinate: Int): Planet {
        return planetService.addPlanet(name, xCoordinate, yCoordinate)
    }

    fun retrievePlanet(name: String): Planet {
        val result = planetService.retrievePlanet(name)
        if (result.isEmpty()) {
            throw IllegalArgumentException("No planet found with name '$name'")
        } else if (result.size > 1) {
            throw IllegalStateException("Multiple planets found with name '$name'")
        }
        return result.single()
    }

    fun addCommodity(name: String, price: Double): Commodity {
        return commodityService.addCommodity(name, price)
    }

    fun retrieveCommodity(name: String): Commodity {
        val result = commodityService.retrieveCommodity(name)
        if (result.isEmpty()) {
            throw IllegalArgumentException("No commodity found with name '$name'")
        } else if (result.size > 1) {
            throw IllegalStateException("Multiple commodities found with name '$name'")
        }
        return result.single()
    }

    fun addTradeRoute(planetOneName: String, planetTwoName: String): TradeRoute {
        // TODO logik von dass nur genau ein planet kommt, sollte nicht in retrievePlanet von PostService sein, sondern in PlanetService!!!
        val planetOne = retrievePlanet(planetOneName)
        val planetTwo = retrievePlanet(planetTwoName)
        return tradeRouteService.addTradeRoute(planetOne, planetTwo)
    }
}
