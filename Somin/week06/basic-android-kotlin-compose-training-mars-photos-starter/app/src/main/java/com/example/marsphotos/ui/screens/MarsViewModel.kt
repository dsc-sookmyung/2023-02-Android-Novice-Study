/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.marsphotos.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsphotos.network.MarsApi
import kotlinx.coroutines.launch
import java.io.IOException

// MarsUiState 봉인 인터페이스 : MarsUiState 객체가 가질 수 있는 값이 완전해짐.
sealed interface MarsUiState {
    data class Success(val photos: String) : MarsUiState
    object Error : MarsUiState
    object Loading : MarsUiState
}

class MarsViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    private fun getMarsPhotos() {
        viewModelScope.launch {
            // 네트워크 호출 오류 예외 처리
            marsUiState = try {
                val listResult = MarsApi.retrofitService.getPhotos()
                MarsUiState.Success(
                    "Success: ${listResult.size} Mars photos retrieved"
                )
                // 백엔드 서버에서 받은 결과를 marsUiState(최근의 웹 요청 상태를 나타내는 변경 가능한 상태 객체)에 할당
            } catch (e: IOException) {
                MarsUiState.Error
            }
        }
    }
}
