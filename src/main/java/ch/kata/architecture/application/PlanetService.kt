package ch.kata.architecture.application

import ch.kata.architecture.CdiContext
import ch.kata.architecture.application.dto.Planet
import ch.kata.architecture.application.port.PlanetRepositoryPort

class PlanetService {

    private val planetRepository: PlanetRepositoryPort = CdiContext.getPlanetRepositoryAdapter()

    fun addPlanet(name: String, xCoordinate: Int, yCoordinate: Int): Planet {
        return  planetRepository.save(name, xCoordinate, yCoordinate)
    }

    fun retrievePlanet(name: String): List<Planet> {
        return planetRepository.findByName(name)
    }

}
