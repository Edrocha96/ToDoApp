package br.com.example.todoapp.repository

import android.app.GameManager
import android.content.Context
import br.com.example.todoapp.model.Task

class TaskRepository(context: Context) {

    // Obter acesso ao banco de dados
    private val db = TaskDatabase.getDataBase(context).taskDao()

    // Buscar Task por id
    fun findTaskById(id: Int): Task{
        return db.listTaskById(id)
    }
    //Inserir nova tarefa
    fun insert(task: Task):  Long{
        return db.create(task)
    }

    //Listar todas as tarefas
    fun findAllTask(): List<Task>{
        return db.listAll()
    }

    // Deletar task
    fun deleteTask(task: Task){
        db.delete(task)
    }

    // Deletar task
    fun updateTask(task: Task){
        db.update(task)
    }


}