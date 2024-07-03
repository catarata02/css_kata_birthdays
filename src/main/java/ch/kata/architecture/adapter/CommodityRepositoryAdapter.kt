package ch.kata.architecture.adapter

import ch.kata.architecture.application.dto.Commodity
import ch.kata.architecture.application.port.CommodityRepositoryPort

class CommodityRepositoryAdapter : CommodityRepositoryPort {

    private val commodities: MutableMap<String, Commodity> = mutableMapOf()

    override fun save(name: String, price: Double): Commodity {
        val commodity = Commodity(name, price)
        commodities[name] = commodity
        return commodity
    }

    override fun findByName(name: String): List<Commodity> {
        return commodities[name]?.let { listOf(it) } ?: emptyList()
    }

}
