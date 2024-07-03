package ch.kata.architecture.adapter

import ch.kata.architecture.application.dto.Planet
import ch.kata.architecture.application.dto.TradeRoute
import ch.kata.architecture.application.port.TradeRouteRepositoryPort

class TradeRouteRepositoryAdapter : TradeRouteRepositoryPort {

    private val tradeRouteMap: MutableMap<Pair<Planet, Planet>, TradeRoute> = mutableMapOf()

    override fun save(planetPair: Pair<Planet, Planet>): TradeRoute {
        val tradeRoute = TradeRoute(planetPair)
        tradeRouteMap[planetPair] = tradeRoute
        return tradeRoute
    }

    override fun findByName(planetPair: Pair<Planet, Planet>): List<TradeRoute> {
        TODO("Not yet implemented")
    }

}
