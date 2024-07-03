package ch.kata.architecture.application

import ch.kata.architecture.application.dto.Planet

class GalacticTradingPostService {

    private val planetService = PlanetService()

    fun addPlanet(name: String, xCoordinate: Int, yCoordinate: Int): Planet {
        return planetService.addPlanet(name, xCoordinate, yCoordinate)
    }
}
