package com.example.rickandmprty.di

import com.example.domain.interfaces.CharacterRepository
import com.example.domain.interfaces.EpisodesRepository
import com.example.domain.useCases.GetCharacterUseCase
import com.example.domain.useCases.GetEpisodesUseCase
import com.example.domain.useCases.GetCharacterPagingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideGetCharacterUseCase(
        repository: CharacterRepository
    ): GetCharacterUseCase {
        return GetCharacterUseCase(repository)
    }

    @Provides
    fun provideGetEpisodesUseCase(
        repository: EpisodesRepository
    ): GetEpisodesUseCase {
        return GetEpisodesUseCase(repository)
    }

    @Provides
    fun provideGetEpisodesPagingUseCase(
        repository: CharacterRepository
    ): GetCharacterPagingUseCase {
        return GetCharacterPagingUseCase(repository)
    }
}