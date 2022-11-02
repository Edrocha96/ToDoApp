package br.com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

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
            val dados = getSharedPreferences("dados", MODE_PRIVATE)
            val email = dados.getString("email_usuario", "Email não encontrado")
            val senha = dados.getString("senha_usuario", "Senha não encontrada")

            if (email == inputTextEmail.text.toString() && senha == inputTextPassword.text.toString()){
                val intent = Intent(this,MyTasksActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Usuário não encontrado, verifique seu e-mail e senha ou realize um cadastro.", Toast.LENGTH_SHORT).show()
            }


        }



    }

}