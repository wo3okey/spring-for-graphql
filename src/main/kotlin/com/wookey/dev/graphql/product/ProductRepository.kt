package com.wookey.dev.graphql.product

import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class ProductRepository {
    var products = listOf(
        Product(
            id = 0,
            common = ProductCommon(title = "우키 조던", description = "우키조던 조아요"),
            transaction = ProductTransaction(price = BigDecimal.valueOf(389000), deliveryYN = false),
            brand = ProductBrand(category = "스니커즈", brand = "조던"),
            image = ProductImage(imgCnt = 3, imgUrl = "imgUrl"),
            inspection = ProductInspection(insPid = 1, modelId = 10)
        ),
        Product(
            id = 0,
            common = ProductCommon(title = "오슬로 마르지엘라", description = "오슬로 마르지엘라 조아요"),
            transaction = ProductTransaction(price = BigDecimal.valueOf(2489000), deliveryYN = false),
            brand = ProductBrand(category = "스니커즈", brand = "마르지엘라"),
            image = ProductImage(imgCnt = 1, imgUrl = "imgUrl"),
            inspection = ProductInspection(insPid = 2, modelId = 1244)
        ),
        Product(
            id = 0,
            common = ProductCommon(title = "딜런 아더에러", description = "딜런 아더에러 조아요"),
            transaction = ProductTransaction(price = BigDecimal.valueOf(128000), deliveryYN = true),
            brand = ProductBrand(category = "남자상", brand = "아더에러"),
            image = ProductImage(imgCnt = 3, imgUrl = "imgUrl"),
            inspection = ProductInspection(insPid = 3, modelId = 222)
        ),
        Product(
            id = 0,
            common = ProductCommon(title = "꿀잼이 롤렉스", description = "꿀잼이 롤렉스 쩔"),
            transaction = ProductTransaction(price = BigDecimal.valueOf(28400000), deliveryYN = false),
            brand = ProductBrand(category = "시계", brand = "롤렉스"),
            image = ProductImage(imgCnt = 3, imgUrl = "imgUrl"),
            inspection = ProductInspection(insPid = 4, modelId = 12482)
        ),
        Product(
            id = 0,
            common = ProductCommon(title = "앨빈 나이키", description = "앨빈이 입은 프리니엄 나이키 신발"),
            transaction = ProductTransaction(price = BigDecimal.valueOf(5000), deliveryYN = true),
            brand = ProductBrand(category = "스니커즈", brand = "나이키"),
            image = ProductImage(imgCnt = 3, imgUrl = "imgUrl"),
            inspection = ProductInspection(insPid = 5, modelId = 12582)
        ),
    )

    fun findAll() = products

    fun findById(id: Int) = products.first { it.id == id }
}