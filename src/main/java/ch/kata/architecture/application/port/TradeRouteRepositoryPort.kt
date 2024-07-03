package ch.kata.architecture.application.port

import ch.kata.architecture.application.dto.Planet
import ch.kata.architecture.application.dto.TradeRoute

interface TradeRouteRepositoryPort {

    fun save(planetPair: Pair<Planet, Planet>): TradeRoute
    fun findByName(planetPair: Pair<Planet, Planet>): List<TradeRoute>

}
