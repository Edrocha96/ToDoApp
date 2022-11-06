package br.com.example.todoapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.example.todoapp.model.Task

@Dao
interface TaskDao {

    @Insert
    fun create(task: Task): Long

    @Update
    fun update(task: Task): Int

    @Delete
    fun delete(task: Task)

    @Query("SELECT * FROM tb_task")
    fun listAll(): List<Task>

    @Query("SELECT * FROM tb_task WHERE idTask = :id")
    fun listTaskById(id: Int): Task

}