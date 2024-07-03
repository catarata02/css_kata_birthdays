package ch.kata.architecture.adapter

import ch.kata.architecture.application.dto.Planet
import ch.kata.architecture.application.port.PlanetRepositoryPort

class PlanetRepositoryAdapter : PlanetRepositoryPort {

    private val planets: MutableMap<String, Planet> = mutableMapOf()

    override fun save(name: String, xCoordinate: Int, yCoordinate: Int): Planet {
        val planet = Planet(name, xCoordinate, yCoordinate)
        planets[name] = planet
        return planet
    }

    override fun findByName(name: String): List<Planet> {
        return planets[name]?.let { listOf(it) } ?: emptyList()
    }

}
