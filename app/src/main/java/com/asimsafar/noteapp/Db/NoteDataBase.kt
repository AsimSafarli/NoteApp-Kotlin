package com.asimsafar.noteapp.Db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asimsafar.noteapp.Daos.NoteDao
import com.asimsafar.noteapp.Module.Note


@Database(entities = [Note::class], version = 1)
abstract class NoteDataBase:RoomDatabase() {
    abstract  fun noteDao():NoteDao
}