package ch.kata.architecture

import ch.kata.architecture.adapter.PlanetRepositoryAdapter
import ch.kata.architecture.application.port.PlanetRepositoryPort

class CdiContext {
    companion object {
        fun getPlanetRepositoryAdapter(): PlanetRepositoryPort {
            return PlanetRepositoryAdapter()
        }
    }
}
