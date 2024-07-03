package ch.kata.architecture.application

import ch.kata.architecture.CdiContext
import ch.kata.architecture.application.dto.Planet
import ch.kata.architecture.application.dto.TradeRoute
import ch.kata.architecture.application.port.TradeRouteRepositoryPort

class TradeRouteService {
    private val tradeRouteRepository: TradeRouteRepositoryPort = CdiContext.getTradeRouteRepositoryAdapter()

    fun addTradeRoute(planetOne: Planet, planetTwo: Planet): TradeRoute {
        // sort alphabetically to ignore order of planets
        val sortedPlanetPair = getSortedPlanetPair(planetOne, planetTwo)
        return tradeRouteRepository.save(sortedPlanetPair)
    }

    fun retrieveTradeRoute(pair: Pair<Planet, Planet>): List<TradeRoute> {
        val sortedPlanetPair = getSortedPlanetPair(pair.first, pair.second)
        return tradeRouteRepository.findByName(sortedPlanetPair)
    }

    private fun getSortedPlanetPair(
        planetOne: Planet,
        planetTwo: Planet
    ): Pair<Planet, Planet> {
        val sortedPlanetList = listOf(planetOne, planetTwo).sortedBy { it.name }
        return Pair(sortedPlanetList[0], sortedPlanetList[1])
    }
}


