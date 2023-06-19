package com.raana.multiplatformapp.data.source.remote.service.weather

import arrow.core.Either
import com.raana.multiplatformapp.data.source.remote.model.dto.ProductDto
import com.raana.multiplatformapp.utils.Failure

interface ProductService {

    suspend fun getProduct(): Either<Failure.NetworkFailure, ProductDto>
}