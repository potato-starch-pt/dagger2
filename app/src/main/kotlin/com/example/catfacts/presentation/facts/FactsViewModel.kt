package com.example.catfacts.presentation.facts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catfacts.domain.model.Fact
import com.example.catfacts.domain.repository.CatFactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FactsViewModel @Inject constructor(
    private val repository: CatFactsRepository
) : ViewModel() {
    private val _state = MutableStateFlow(FactsState())
    val state: StateFlow<FactsState> = _state.asStateFlow()

    init {
        loadFacts()
    }

    private fun loadFacts() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                repository.getFacts().collect { facts ->
                    _state.value = _state.value.copy(
                        facts = facts,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    error = e.message,
                    isLoading = false
                )
            }
        }
    }
}

data class FactsState(
    val facts: List<Fact> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)