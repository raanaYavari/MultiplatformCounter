package com.raana.multiplatformapp.data.source.remote.service.weather

import arrow.core.Either
import com.raana.multiplatformapp.data.source.remote.ApiClient
import com.raana.multiplatformapp.data.source.remote.makeRequest
import com.raana.multiplatformapp.data.source.remote.model.dto.ProductDto
import com.raana.multiplatformapp.utils.Failure
import io.ktor.http.HttpMethod
import io.ktor.http.URLBuilder
import io.ktor.http.path

class ProductServiceImpl constructor(
    private val apiClient: ApiClient,
) : ProductService {
    override suspend fun getProduct(): Either<Failure.NetworkFailure, ProductDto> {
        return apiClient.makeRequest(
            urlBuilder = URLBuilder(
                "https://dummyjson.com"
            ).apply {
                path("products")
            }, methodType = HttpMethod.Get
        )
    }

}