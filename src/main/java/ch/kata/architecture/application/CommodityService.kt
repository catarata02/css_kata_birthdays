package ch.kata.architecture.application

import ch.kata.architecture.CdiContext
import ch.kata.architecture.application.dto.Commodity
import ch.kata.architecture.application.port.CommodityRepositoryPort

class CommodityService {

    private val commodityRepository: CommodityRepositoryPort = CdiContext.getCommodityRepositoryAdapter()

    fun addCommodity(name: String, price: Double): Commodity {
        return commodityRepository.save(name, price)
    }

    fun retrieveCommodity(name: String): List<Commodity> {
        return commodityRepository.findByName(name)
    }

}
