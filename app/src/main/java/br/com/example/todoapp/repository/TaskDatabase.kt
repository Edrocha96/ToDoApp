package br.com.example.todoapp.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.example.todoapp.dao.TaskDao
import br.com.example.todoapp.model.Task
import java.security.AccessControlContext

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object{

        private lateinit var instance: TaskDatabase

        //Singleton
        fun getDataBase(context: Context) : TaskDatabase {
            if (!::instance.isInitialized){
                instance = Room.databaseBuilder(
                    context,
                    TaskDatabase::class.java,
                    "ToDoApp_db")
                    .allowMainThreadQueries()
                    .build()
            }
        return instance
        }
    }

}