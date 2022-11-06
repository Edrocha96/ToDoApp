package br.com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import br.com.example.todoapp.databinding.ActivityDetailsTaskBinding
import br.com.example.todoapp.databinding.ActivityMyTasksBinding
import br.com.example.todoapp.databinding.ActivityNewTaskBinding
import br.com.example.todoapp.model.Task
import br.com.example.todoapp.repository.TaskRepository

class DetailsTaskActivity : AppCompatActivity() {

    lateinit var buttonEdit: ImageButton
    lateinit var buttonSave: Button
    lateinit var buttonDelete: Button
    lateinit var textViewNameTask: TextView
    lateinit var textViewDate: TextView
    lateinit var textViewDescriptionTask: TextView
    lateinit var taskRepository: TaskRepository
    lateinit var task: Task
    lateinit var binding: ActivityDetailsTaskBinding
    var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       /* *//**//*setContentView(R.layout.activity_details_task)*/

        binding = ActivityDetailsTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Inicializar o repository
        taskRepository = TaskRepository(this)

        textViewNameTask = findViewById(R.id.inputTextNameTaskDetails)
        textViewDate = findViewById(R.id.textViewDateTaskDetails)
        textViewDescriptionTask = findViewById(R.id.inputTextTaskDescriptionDetails)
        buttonEdit = findViewById(R.id.imageButtonEditTask)
        buttonSave = findViewById(R.id.btnSaveEdit)
        buttonDelete = findViewById(R.id.btnDelete)

        buttonEdit.setOnClickListener{
            textViewNameTask.isEnabled = true
            textViewDate.isEnabled = true
            textViewDescriptionTask.isEnabled = true
            buttonSave.isEnabled  = true
            buttonDelete.isEnabled = true
        }

        id = intent.getIntExtra("id", 0)
        if (id > 0){
            loadTask()
        }

        binding.btnDelete.setOnClickListener{
            if (id > 0){
                task = taskRepository.findTaskById(id)
                taskRepository.deleteTask(task)
                Toast.makeText(this, "Tarefa Apagada", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,MyTasksActivity::class.java)
                startActivity(intent)
            }

        }
        binding.btnSaveEdit.setOnClickListener(){
            updateTask()
        }

    }

    private fun updateTask() {
        task.titleTask = binding.inputTextNameTaskDetails.text.toString()
        task.descriptionTask = binding.inputTextTaskDescriptionDetails.text.toString()
        task.taskDate = binding.textViewDateTaskDetails.text.toString()
        taskRepository.updateTask(task)
        Toast.makeText(this, "Tarefa Atualizada", Toast.LENGTH_SHORT).show()
        val intent = Intent(this,MyTasksActivity::class.java)
        startActivity(intent)
    }

    private fun loadTask() {
        task = taskRepository.findTaskById(id)
        with(binding){
            inputTextNameTaskDetails.setText(task.titleTask)
            textViewDateTaskDetails.setText(task.taskDate)
            inputTextTaskDescriptionDetails.setText(task.descriptionTask)

        }
    }
}