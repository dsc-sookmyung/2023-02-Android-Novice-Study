package com.example.marsphotos.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET


    private  val BASE_URL =
        "https://android-kotlin-fun-mars-server.appspot.com"

    private val retrofit = Retrofit.Builder() //retropit 객체를 빌드하고 만듦
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType())) //이제 kotlinx.serialization을 가져왔으므로 JSON 문자열을 반환하는 대신 JSON 배열에서 MarsPhoto 객체 목록을 반환하도록 Retrofit에 요청할 수 있습니다.
        .baseUrl(BASE_URL) //웹서비스의 기본 url을 추가
        .build() //retrofit 객체를 만듦

    interface MarsApiService { //retrofit http 요청을 사용하여 웹서버와 통신하는 방법을 정의하는 인터페이스 정의
        @GET("photos")
        //fun getPhotos() :String //웹서비스에서 응답 문자열을 가져옴
        suspend fun getPhotos(): List<Marsphoto> //String을 반환하는 대신 MarsPhoto 객체 목록을 반환하도록 Retrofit의 MarsApiService 인터페이스를 업데이트합니다.
    }
    object MarsApi { //retropit 서비스 초기화
        val retrofitService : MarsApiService by lazy {
            retrofit.create(MarsApiService::class.java)
        }
    }


