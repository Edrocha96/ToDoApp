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
        inputTextName = findViewById(R.id.inputTextNameUserRegister)
        inputTextEmail = findViewById(R.id.editTextEmailAddresRegister)
        inputTextPassword = findViewById(R.id.inputTextUserRegisterPassw)
        inputTextConfirmPassword = findViewById(R.id.inputTextUserRegisterConfirmPassw)

        buttonRegister.setOnClickListener{
            val dados = getSharedPreferences("dados", MODE_PRIVATE)

            val edit = dados.edit()
            edit.putString("nome_usuario", inputTextName.text.toString())
            edit.putString("email_usuario", inputTextEmail.text.toString())
            edit.putString("senha_usuario", inputTextPassword.text.toString())

            if (inputTextName.text.toString().equals("")  || inputTextEmail.text.toString().equals("") || inputTextPassword.text.toString().equals("") || inputTextConfirmPassword.text.toString().equals("")){
                Toast.makeText(this, "Preencha todos os campos",Toast.LENGTH_SHORT).show()
            }else{
                if (edit.commit()){
                    Toast.makeText(this, "Cadastrado com Sucesso",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Problema ao cadastrar o usuário",Toast.LENGTH_SHORT).show()
                }
            }

        }

    }

}