package com.raana.multiplatformapp.data.source.remote.model.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ProductDto(
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("price") val price: Int,
    @SerialName("discountPercentage") val discountPercentage: Double,
    @SerialName("brand") val brand: String,
    @SerialName("thumbnail") val thumbnail: String,
    @SerialName("images") val images: List<String>,
)


