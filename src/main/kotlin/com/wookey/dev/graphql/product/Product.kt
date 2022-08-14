package com.wookey.dev.graphql.product

import java.math.BigDecimal

class Product(
    val id: Int,
    val common: ProductCommon,
    val transaction: ProductTransaction,
    val brand: ProductBrand,
    val image: ProductImage,
    val inspection: ProductInspection
)

class ProductCommon(
    val title: String,
    val description: String
)

class ProductTransaction(
    val price: BigDecimal,
    val deliveryYN: Boolean
)

class ProductBrand(
    val category: String,
    val brand: String
)

class ProductImage(
    val imgCnt: Int,
    val imgUrl: String
)

class ProductInspection(
    val insPid: Int,
    val modelId: Int
)
