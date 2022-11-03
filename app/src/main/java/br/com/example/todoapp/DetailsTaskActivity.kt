package br.com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class DetailsTaskActivity : AppCompatActivity() {

    lateinit var buttonEdit: ImageButton
    lateinit var buttonSave: Button
    lateinit var buttonDelete: Button
    lateinit var textViewNameTask: TextView
    lateinit var textViewDate: TextView
    lateinit var textViewDescriptionTask: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_details_task)
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

    }
}