package com.example.marsphotos.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// kotlin serialization : JSON을 파싱할 때 이름과 일치하는 키를 찾아 데이터 객체를 적절한 값으로 채움.
@Serializable // MarsPhoto 클래스 직렬화
data class MarsPhoto ( // MarsPhoto 클래스의 각 변수는 JSON 객체의 키 이름에 대응
    val id: String,

    @SerialName(value = "img_src")
    val img_src: String
)