package com.wookey.dev.graphql.product

import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class ProductController(
    val productService: ProductService
) {
    @QueryMapping
    fun products(): List<Product> = productService.all()

    @QueryMapping
    fun product(id: Int) = productService.find(id)

    @QueryMapping
    fun exception() = productService.exception()
}