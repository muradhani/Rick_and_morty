package com.example.rickandmprty.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.useCases.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsScreenViewModel @Inject constructor(
    private val getCharacter: GetCharacterUseCase
): ViewModel() {
    private val _userData = MutableStateFlow<com.example.domain.modules.Character?>(null)
    val userData: StateFlow<com.example.domain.modules.Character?> = _userData

    fun getCharacterDetails(characterId: Int){
        viewModelScope.launch {
            getCharacter(characterId)?.let {
                _userData.value = it
            }
        }
    }

}