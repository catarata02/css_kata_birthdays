package ch.kata.architecture.application

import ch.kata.architecture.adapter.PlanetRepositoryAdapter
import ch.kata.architecture.application.dto.Planet
import ch.kata.architecture.application.port.PlanetRepositoryPort

class PlanetService {

    private val planetRepository: PlanetRepositoryPort = PlanetRepositoryAdapter()

    fun addPlanet(name: String, xCoordinate: Int, yCoordinate: Int): Planet {
        return  planetRepository.save(name, xCoordinate, yCoordinate)
    }

}
