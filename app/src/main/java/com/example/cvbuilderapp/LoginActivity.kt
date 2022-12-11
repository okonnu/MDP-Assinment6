package com.example.cvbuilderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cvbuilderapp.constants.Constant.IS_LOGGED_IN
import com.example.cvbuilderapp.constants.Constant.SP_NAME
import com.example.cvbuilderapp.constants.Constant.USER_EMAIL
import com.example.cvbuilderapp.constants.Constant.USER_NAME
import com.example.cvbuilderapp.constants.Constant.USER_PASSWORD
import com.example.cvbuilderapp.R

class LoginActivity : AppCompatActivity(), OnClickListener {

    private lateinit var emailText: EditText
    private lateinit var passwordText: EditText
    private lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //initialize shared preference
        val sharedPref = getSharedPreferences(SP_NAME,0)
        if (sharedPref.getBoolean(IS_LOGGED_IN, false)) {
            openMainActivity()
        }else {
            initSharedPreference()
        }

        //initialize views
        emailText = findViewById(R.id.email_edit_text)
        passwordText = findViewById(R.id.password_edit_text)
        loginBtn = findViewById(R.id.login_button)
        loginBtn.setOnClickListener(this)

    }



    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.login_button -> {
                if (validateFields()) {
                    if (checkAuth()) {

                        //set login as true
                        val sharedPref = getSharedPreferences(SP_NAME, 0)
                        val editor = sharedPref.edit()
                        editor.putBoolean(IS_LOGGED_IN, true)
                        editor.apply()

                        openMainActivity()

                    }else {
                        Toast.makeText(this,"Email or Password not match!", Toast.LENGTH_LONG).show()
                    }
                }
            }

            
        }
    }

    private fun checkAuth(): Boolean {
        val sharedPref = getSharedPreferences(SP_NAME,0)
        val email = sharedPref.getString(USER_EMAIL,"")
        val password = sharedPref.getString(USER_PASSWORD,"")
        Log.v("LoginActivity", "$email : $password")
        if (emailText.text.toString().trim() != email || passwordText.text.toString().trim() != password) {
            return false
        }
        return true
    }

    private fun validateFields(): Boolean {
        if (emailText.text.isEmpty()) {
            emailText.error = "Email can not be empty"
            emailText.requestFocus()
            return false
        } else if (passwordText.text.isEmpty()) {
            passwordText.error = "Password can not be empty"
            passwordText.requestFocus()
            return false;
        }

        return true
    }

    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initSharedPreference() {
        val sharedPref = getSharedPreferences(SP_NAME, 0)
        val editor = sharedPref.edit()
        editor.putString(USER_EMAIL, "dokonu@miu.edu")
        editor.putString(USER_PASSWORD, "123456")
        editor.putString(USER_NAME, "Douglas Okonu")
        editor.putBoolean(IS_LOGGED_IN, false)
        editor.apply()
    }
}