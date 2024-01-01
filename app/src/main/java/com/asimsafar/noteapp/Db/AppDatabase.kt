package com.asimsafar.noteapp.Db

import androidx.room.Database
import com.asimsafar.noteapp.Module.Note


@Database(entities = [Note::class], version = 1)
abstract class AppDatabase {
}