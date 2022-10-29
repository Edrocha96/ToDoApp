package br.com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.Toast
import br.com.example.todoapp.databinding.ActivityMyTasksBinding

class MyTasksActivity : AppCompatActivity() {

    lateinit var binding: ActivityMyTasksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMyTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingBtnNewTask.setOnClickListener{
            val intent = Intent(this,NewTaskActivity::class.java)
            startActivity(intent)
        }
    }
}