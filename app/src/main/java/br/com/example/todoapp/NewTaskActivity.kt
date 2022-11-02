package br.com.example.todoapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class NewTaskActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    lateinit var buttonRegisterNewTask: Button
   /* lateinit var editTextDate: EditText*/
    lateinit var dateTerefa: TextView
    private val calendar = Calendar.getInstance()
    private val formatter = SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ROOT)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)

        buttonRegisterNewTask = findViewById(R.id.btnRegisterNewTask)
        dateTerefa = findViewById(R.id.textViewDateTask)

        dateTerefa.setOnClickListener{
            DatePickerDialog(this,this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show()
        }
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