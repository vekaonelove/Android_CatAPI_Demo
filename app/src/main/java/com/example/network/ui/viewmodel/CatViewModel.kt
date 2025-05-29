package com.example.network.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.data.repositorty.CatRepository
import com.example.network.data.serviceLocator.NetworkModule
import com.example.network.ui.state.CatUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CatViewModel(
    private val repository: CatRepository = CatRepository(NetworkModule.catApiService)
) : ViewModel() {

    private val _uiState = MutableStateFlow(CatUiState())
    val uiState: StateFlow<CatUiState> = _uiState.asStateFlow()

    init {
        loadRandomCats()
    }

    fun loadRandomCats() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)

            repository.getRandomCats().fold(
                onSuccess = { cats ->
                    _uiState.value = _uiState.value.copy(
                        cats = cats,
                        isLoading = false,
                        errorMessage = null
                    )
                },
                onFailure = { exception ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = exception.message ?: "Unknown error occurred"
                    )
                }
            )
        }
    }
}