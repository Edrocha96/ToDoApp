package br.com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    lateinit var buttonLogin: Button
    lateinit var buttonCreateAccont: Button
    lateinit var textViewForgotPassword: TextView
    lateinit var inputTextEmail: EditText
    lateinit var inputTextPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide() //double bang

       textViewForgotPassword = findViewById(R.id.textViewForgotPassword)
       buttonCreateAccont = findViewById(R.id.btnRegister)
       buttonLogin = findViewById(R.id.BtnLogin)
       inputTextEmail= findViewById(R.id.inputTextEmailAddressLogin)
       inputTextPassword = findViewById(R.id.inputTextPasswordLogin)

       textViewForgotPassword.setOnClickListener {
            val intent = Intent(this,ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

       buttonCreateAccont.setOnClickListener {
           val intent = Intent(this,UserRegisterActivity::class.java)
           startActivity(intent)
       }

        buttonLogin.setOnClickListener {
            val intent = Intent(this,MyTasksActivity::class.java)
            startActivity(intent)
        }



    }

}