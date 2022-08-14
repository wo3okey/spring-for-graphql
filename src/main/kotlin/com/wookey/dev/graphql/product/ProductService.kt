package com.wookey.dev.graphql.product

import com.wookey.dev.graphql.CustomException
import org.springframework.stereotype.Service

@Service
class ProductService(
    val repository: ProductRepository
) {
    fun all(): List<Product> {
        return repository.findAll()
    }

    fun find(id: Int): Product {
        return repository.findById(id)
    }

    fun exception(): Boolean {
        throw CustomException("custom error 발생시키기")

        return false
    }
}