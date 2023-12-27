package com.example.marsphotos.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable // 직렬화
data class Marsphoto (
    val id: String,
    @SerialName(value = "img_src")
    val imgSrc: String
)
