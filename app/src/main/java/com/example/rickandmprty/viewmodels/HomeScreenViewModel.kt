package com.example.rickandmprty.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.modules.Character
import com.example.domain.useCases.getCharacterPaging
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getCharactersPaging: getCharacterPaging
) : ViewModel() {
    private var _characters = MutableStateFlow<List<Character>?>(null)
    var characters: StateFlow<List<Character>?> = _characters
    init {

    }

    suspend fun getCharacters(pageNumber:Int){
        val newCharactersPage = getCharactersPaging(pageNumber)
        newCharactersPage?.let { newPage ->
            _characters.update { newPage }
        }
    }
}