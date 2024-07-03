package ch.kata.architecture.application

import ch.kata.architecture.application.dto.Planet

class GalacticTradingPostService {

    private val planetService = PlanetService()

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
}
