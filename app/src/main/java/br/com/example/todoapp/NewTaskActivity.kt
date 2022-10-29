package br.com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class NewTaskActivity : AppCompatActivity() {

    lateinit var buttonRegisterNewTask: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)

        buttonRegisterNewTask = findViewById(R.id.btnRegisterNewTask)
    }

    fun btnRegisterNewTask(view: View) {
        Toast.makeText(this, "Nova tarefa cadastrada com sucesso", Toast.LENGTH_SHORT).show()
        val intent = Intent(this,MyTasksActivity::class.java)
        startActivity(intent)
    }
}