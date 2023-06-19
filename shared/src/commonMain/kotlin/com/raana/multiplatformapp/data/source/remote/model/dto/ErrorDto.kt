package com.raana.multiplatformapp.data.source.remote.model.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ErrorDto(
    @SerialName("error") val error: String?=null,
    @SerialName("Message") val message: String?=null,
    @SerialName("Title") val title: String?=null,
)