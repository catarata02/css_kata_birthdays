package ch.kata.architecture.application.port

import ch.kata.architecture.application.dto.Commodity

interface CommodityRepositoryPort {

    fun save(name: String, price: Double): Commodity
    fun findByName(name: String): List<Commodity>

}
