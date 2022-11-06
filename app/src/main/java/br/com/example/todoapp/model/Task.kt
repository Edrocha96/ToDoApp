package br.com.example.todoapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_task")
class Task {

    @PrimaryKey(autoGenerate = true)
    var idTask: Int = 0

    @ColumnInfo(name = "tile_task")
    var titleTask: String = ""

    @ColumnInfo(name = "description_task")
    var descriptionTask: String = ""

    @ColumnInfo(name = "date_task")
    var taskDate: String = ""


}
