package br.com.example.todoapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import br.com.example.todoapp.databinding.ActivityNewTaskBinding
import br.com.example.todoapp.model.Task
import br.com.example.todoapp.repository.TaskRepository
import java.text.SimpleDateFormat
import java.util.*

class NewTaskActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


   /* lateinit var editTextDate: EditText*/
/*    lateinit var dateTerefa: TextView*/
    lateinit var binding: ActivityNewTaskBinding
    lateinit var taskRepository: TaskRepository
    lateinit var task: Task
    private val calendar = Calendar.getInstance()
    private val formatter = SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ROOT)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewDateTask.setOnClickListener{
            DatePickerDialog(this,this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        //Inicializar o repository
        taskRepository = TaskRepository(this)

        binding.btnRegisterNewTask.setOnClickListener(){
            saveTask()
        }

    }

    private fun saveTask() {
        task = Task()
        task.apply {
            titleTask = binding.inputTextNameTask.text.toString()
            descriptionTask = binding.inputTextTaskDescriptionNewTask.text.toString()
            taskDate = binding.textViewDateTask.text.toString()
        }

        taskRepository.insert(task)
        Toast.makeText(this, "Nova tarefa cadastrada com sucesso", Toast.LENGTH_SHORT).show()
        val intent = Intent(this,MyTasksActivity::class.java)
        startActivity(intent)

    }

    fun btnRegisterNewTask(view: View) {
        Toast.makeText(this, "Nova tarefa cadastrada com sucesso", Toast.LENGTH_SHORT).show()
        val intent = Intent(this,MyTasksActivity::class.java)
        startActivity(intent)
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        Log.e("Calendar", "$year -- $month -- $dayOfMonth")
        calendar.set(year,month,dayOfMonth)
        displayFormattedDate(calendar.timeInMillis)
        TimePickerDialog(this,
            this,
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            false
        ).show()
    }

    private fun displayFormattedDate(timestamp: Long){
        findViewById<TextView>(R.id.textViewDateTask).text = formatter.format(timestamp)
        Log.i("Formatado",timestamp.toString())
    }

    override fun onTimeSet(p0: TimePicker?, hourOfDay: Int, minute: Int) {
        calendar.apply {
            set(Calendar.HOUR_OF_DAY, hourOfDay)
            set(Calendar.MINUTE, minute)
        }
        displayFormattedDate(calendar.timeInMillis)
    }
}