/*
1. 데이터 소스인 MarsApiService 클래스를 만듭니다.
2. 기본 URL과 문자열을 변환하는 변환기 팩토리가 포함된 Retrofit 객체를 만듭니다.
3. Retrofit이 웹 서버와 통신하는 방법을 설명하는 인터페이스를 만듭니다.
4. Retrofit 서비스를 만들고 API 서비스에 관한 인스턴스를 앱의 나머지 부분에 노출합니다.
 */
package com.example.marsphotos.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    // ScalarsConverter : 웹 서비스 API 빌드할 수 있도록 Retrofit에서 문자열과 기타 기본 유형 지원
    .baseUrl(BASE_URL).build()
    //  baseUrl() 메소드 : 웹 서비스의 기본 URL 추가, build() : Retrofit 객체 생성

// Retrofit 빌더 호출 아래에 Retrofit이 HTTP 요청을 사용하여 웹 서버와 통신하는 방법을 정의.
interface MarsApiService {
    // Retrofit에 GET 요청임을 알리고 웹 서비스 메서드의 엔드포인트(여기서는 photos) 지정
    // getPhotos() 호출 -> 기본 URL에 엔드포인트 photos 추가
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

// 공개 싱글톤 객체 MarsApi 정의 -> Retrofit 서비스 초기화
// 공개 싱글톤 객체 : 앱의 나머지 부분에서 액세스 가능
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java) // retrofit.create() -> retrofitService 변수 초기화
    }
}