package com.asimsafar.noteapp.Db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.asimsafar.noteapp.Daos.NoteDao
import com.asimsafar.noteapp.Module.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        private var database : AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase {
            if(database != null) {
                return database!!
            } else {
                synchronized(this) {
                    database = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "demodb").build()
                    return database!!
                }
            }
        }
    }
}