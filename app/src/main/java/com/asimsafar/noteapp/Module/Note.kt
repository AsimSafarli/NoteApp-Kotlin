package com.asimsafar.noteapp.Module

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Note(
  @PrimaryKey(autoGenerate = true)val id:Int,
    @ColumnInfo(name = "note_title") val noteTitle:String,
  @ColumnInfo(name = "note_descrb") val noteDescrb:String,


  ):Parcelable{

  }