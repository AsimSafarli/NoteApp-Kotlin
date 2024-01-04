package com.asimsafar.noteapp.Di

import com.asimsafar.noteapp.Interfaces.NoteInterface
import com.asimsafar.noteapp.Repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class NoteRepositoryModule {
    @Binds
    abstract  fun bindRepository(prm:NoteRepository):NoteInterface
}