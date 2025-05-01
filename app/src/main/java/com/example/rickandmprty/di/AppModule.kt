package com.example.rickandmprty.di

import com.example.domain.interfaces.CharacterRepository
import com.example.domain.useCases.GetCharacterUseCase
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
}