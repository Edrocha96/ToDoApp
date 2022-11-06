package br.com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.example.todoapp.adapter.TaskAdapter
import br.com.example.todoapp.databinding.ActivityMyTasksBinding
import br.com.example.todoapp.repository.TaskRepository

class MyTasksActivity : AppCompatActivity() {

    lateinit var binding: ActivityMyTasksBinding
    lateinit var userNameText: TextView
    lateinit var  btnTeste: Button
    lateinit var  adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMyTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingBtnNewTask.setOnClickListener{
            val intent = Intent(this,NewTaskActivity::class.java)
            startActivity(intent)
        }

        userNameText = findViewById(R.id.textViewUsername)
        val dados = getSharedPreferences("dados", MODE_PRIVATE)
        userNameText.text = dados.getString("nome_usuario", "Usuário não encontrado")

        loadRecyclerView()
    }

    private fun loadRecyclerView() {

        var taskRepository = TaskRepository(this)

        adapter = TaskAdapter(taskRepository.findAllTask())
        binding.rvTasks.adapter = adapter
        binding.rvTasks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}