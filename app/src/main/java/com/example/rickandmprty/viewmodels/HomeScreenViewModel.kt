package com.example.rickandmprty.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.modules.Character
import com.example.domain.useCases.GetCharacterPagingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getCharactersPaging: GetCharacterPagingUseCase
) : ViewModel() {
    private var _characters = MutableStateFlow<List<Character>?>(null)
    var characters: StateFlow<List<Character>?> = _characters
    private var pageNumber = 1

     fun getCharacters(pageNumber:Int){
        viewModelScope.launch{
            val newCharactersPage = getCharactersPaging(pageNumber)
            newCharactersPage?.let { newPage ->
                _characters.update { newPage }
            }
        }
    }
    fun getNextCharactersPage(){
        viewModelScope.launch{
            pageNumber += 1
            val newCharactersPage = getCharactersPaging(pageNumber)
            newCharactersPage?.let { newPage ->
                _characters.update { currentList ->
                    val updatedList = currentList.orEmpty() + newPage
                    updatedList
                }
            }
        }
    }
}