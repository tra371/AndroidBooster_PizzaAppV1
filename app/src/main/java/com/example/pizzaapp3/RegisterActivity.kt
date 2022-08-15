package com.example.pizzaapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import androidx.core.widget.doAfterTextChanged
import com.example.pizzaapp3.databinding.ActivityRegisterBinding
import com.example.pizzaapp3.util.AppSharedPreference
import com.example.pizzaapp3.util.PatternUtils
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private val sharedPref : AppSharedPreference by lazy {
        AppSharedPreference(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkValidate()
        onClick()

        binding.imbToolbarBack.setOnClickListener{
            super.finish()
        }
    }

    private fun onClick(){
        binding.btnRegister.setOnClickListener {
            if(binding.tilConfirmPassword.isErrorEnabled || binding.tilPassword.isErrorEnabled || binding.tilPhNo.isErrorEnabled
                || binding.etName.text.toString().isNullOrBlank() || !binding.chkAgree.isChecked
                || binding.etPhNo.text.isNullOrBlank() || binding.etPassword.text.isNullOrBlank()
                || binding.etPassword.text.isNullOrBlank()){
                Snackbar.make(it,"Fix Correct Data", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else {
                sharedPref.save("IsLogin",true)
                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun checkValidate() {
        binding.etPhNo.doAfterTextChanged { s->
            if(!s.isNullOrEmpty()) {
                if (PhoneNumberUtils.isGlobalPhoneNumber(s.toString())){
                    binding.tilPhNo.isErrorEnabled = false
                }else{
                    binding.tilPhNo.error = "Enter Correct Number"
                    return@doAfterTextChanged
                }
            }
        }
        binding.etPassword.doAfterTextChanged { s->
            if(!s.isNullOrEmpty()){
                val password = PatternUtils.PASSWORD_PATTERN.matcher(s)
                if(!password.matches()){
                    val error = checkError(s.toString())
                    binding.tilPassword.error = error
                    return@doAfterTextChanged
                }else{
                    binding.tilPassword.isErrorEnabled =false
                }
            }
        }
        binding.etConfirmPassword.doAfterTextChanged { s->
            if(binding.etPassword.text.toString().isNullOrBlank()){
                binding.tilConfirmPassword.error = "Enter Password First"
                return@doAfterTextChanged
            }else{
                if(binding.etPassword.text.toString() == s.toString()){
                    binding.tilConfirmPassword.isErrorEnabled = false
                }else{
                    binding.tilConfirmPassword.error = "Password Not Match"
                    return@doAfterTextChanged
                }
            }
        }
    }

    private fun checkError(password: String):String {
        return when {
            /* Rule 1 */
            !password.contains(Regex("[A-Z]")) -> "Password must contain one capital letter"
            /* Rule 2 */
            !password.contains(Regex("[0-9]")) -> "Password must contain one digit"
            /* Rule 3, not counting space as special character */
            !password.contains(Regex("[^a-zA-Z0-9 ]")) -> "Password must contain one special character"

            !password.contains(Regex("\\S+\$"))-> "Password not allowed to add space"
            else -> "Password is too short."
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@RegisterActivity, AccountActivity::class.java)
        startActivity(intent)
        finish()
    }
}