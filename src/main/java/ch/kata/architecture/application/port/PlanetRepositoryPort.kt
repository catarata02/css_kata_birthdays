package ch.kata.architecture.application.port

import ch.kata.architecture.application.dto.Planet

interface PlanetRepositoryPort {

    fun save(name: String, xCoordinate: Int, yCoordinate: Int): Planet

}
