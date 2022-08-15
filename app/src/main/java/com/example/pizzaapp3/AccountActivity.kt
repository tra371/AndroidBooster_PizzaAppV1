package com.example.pizzaapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.example.pizzaapp3.databinding.ActivityAccountBinding
import com.example.pizzaapp3.util.AppSharedPreference
import com.google.android.material.snackbar.Snackbar

class AccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccountBinding
    private lateinit var sharedPref : AppSharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener{
            val intent = Intent(this@AccountActivity, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.bottomNavigationAccount.selectedItemId = R.id.account

        binding.bottomNavigationAccount.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                    val intent = Intent(this@AccountActivity, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                }
                R.id.shoppingCart->{
                    val intent = Intent(this@AccountActivity, CartActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                }
                R.id.account->{
                }
            }
            true
        }

        sharedPref = AppSharedPreference(this)
        val isLogin = sharedPref.getValueBoolean("IsLogin",false)
        if (isLogin){
            val intent = Intent(this@AccountActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        checkValidate()
        binding.btnLogin.setOnClickListener {
            val phoneNumber = binding.etPhNo.text.toString()
            val password = binding.etPassword.text.toString()
            if(phoneNumber.isNullOrEmpty()){
                binding.tilPhNo.error = "Enter Phone Number"
                binding.tilPhNo.isErrorEnabled=true
                return@setOnClickListener
            }
            if(password.isNullOrEmpty()){
                binding.tilPassword.error="Enter Password"
                binding.tilPassword.isErrorEnabled = true
                return@setOnClickListener
            }
            if(phoneNumber.length<8){
                binding.tilPhNo.error = "Enter Correct Phone Number"
                binding.tilPhNo.isErrorEnabled=true
                return@setOnClickListener
            }
            if(phoneNumber == "09795014119" && password == "abc123"){
                sharedPref.save("IsLogin",true)
                Toast.makeText(this@AccountActivity, "Welcome", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@AccountActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Snackbar.make(binding.root,"Enter Correct Phone Number and Correct Password",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

        }

    }

    private fun checkValidate(){
        binding.etPhNo.doAfterTextChanged { s->
            if(!s.isNullOrEmpty()){
                if(s.length >8){
                    binding.tilPhNo.isErrorEnabled = false
                }
            }
        }
        binding.etPassword.doAfterTextChanged { s->
            if(!s.isNullOrEmpty()){
                binding.tilPassword.isErrorEnabled = false
            }
        }
    }

}