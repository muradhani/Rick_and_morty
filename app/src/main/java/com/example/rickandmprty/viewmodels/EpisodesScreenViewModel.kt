package com.example.rickandmprty.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.modules.Episode
import com.example.domain.useCases.GetCharacterUseCase
import com.example.domain.useCases.GetEpisodesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodesScreenViewModel @Inject constructor(
    private val getEpisodesUseCase: GetEpisodesUseCase
): ViewModel() {
    private var _episodes = MutableStateFlow<List<Episode>?>(null)
    var episodes: StateFlow<List<Episode>?> = _episodes
    fun getEpisodes(episodeIds: List<String>){
        viewModelScope.launch {
            _episodes.value = getEpisodesUseCase(episodeIds)

        }
    }
}