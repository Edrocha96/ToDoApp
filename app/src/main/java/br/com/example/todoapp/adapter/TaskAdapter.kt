package br.com.example.todoapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.example.todoapp.DetailsTaskActivity
import br.com.example.todoapp.R
import br.com.example.todoapp.databinding.TaskListLayoutBinding
import br.com.example.todoapp.model.Task
import br.com.example.todoapp.repository.TaskRepository

class TaskAdapter(val taskList: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.task_list_layout,parent, false)

        return TaskHolder(view)
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.bind(taskList.get(position))
    }

    override fun getItemCount(): Int {
        return  taskList.size
    }

    class TaskHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = TaskListLayoutBinding.bind(view)
        lateinit var taskRepository: TaskRepository


        fun bind(task: Task){
            binding.textViewNameTaks.text = task.titleTask
            binding.textViewDatetime.text = task.taskDate
            binding.textViewDescription.text = task.descriptionTask

            binding.imageButtonInformation.setOnClickListener{
                val intent = Intent(it.context, DetailsTaskActivity::class.java)
                intent.putExtra("id", task.idTask)
                it.context.startActivity(intent)
            }

        }
    }
}