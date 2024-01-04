package com.asimsafar.noteapp.Di

import android.content.Context
import androidx.room.Room
import com.asimsafar.noteapp.Daos.NoteDao
import com.asimsafar.noteapp.Db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
   @Singleton
    @Provides
   fun providerNoteDao(appDatabase : AppDatabase) : NoteDao {
    return appDatabase.noteDao()
}

    @Singleton
    @Provides
    fun providerAppDatabase(@ApplicationContext context : Context) : AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "demodb").build()
    }
}