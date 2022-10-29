package br.com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UserRegisterActivity : AppCompatActivity() {

    lateinit var buttonRegister: Button
    lateinit var inputTextName: EditText
    lateinit var inputTextEmail: EditText
    lateinit var inputTextPassword: EditText
    lateinit var inputTextConfirmPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)

        buttonRegister = findViewById(R.id.btnRegisterUser)
        inputTextName = findViewById(R.id.inputTextPersonName)
        inputTextEmail = findViewById(R.id.editTextEmailAddressEsqueceu)
        inputTextPassword = findViewById(R.id.inputTextUserRegisterPassw)
        inputTextConfirmPassword = findViewById(R.id.inputTextUserRegisterConfirmPassw)

    }

    fun btnConfirmRegister(view: View) {
        Toast.makeText(this, "Cadastrado com Sucesso",Toast.LENGTH_SHORT).show()
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }

}