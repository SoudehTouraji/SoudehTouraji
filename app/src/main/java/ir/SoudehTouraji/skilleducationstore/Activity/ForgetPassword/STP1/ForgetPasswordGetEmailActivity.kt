package ir.SoudehTouraji.skilleducationstore.Activity.ForgetPassword.STP1

import android.content.Context
import android.os.Bundle
import ir.SoudehTouraji.skilleducationstore.Activity.ForgetPassword.STP2.ForgetPasswordVerifyEmailActivity
import ir.SoudehTouraji.skilleducationstore.Components.BaseActivity
import ir.SoudehTouraji.skilleducationstore.Dialog.NoInternet.NoInternetActivity
import ir.SoudehTouraji.skilleducationstore.databinding.ActivityForgetPasswordGetEmailBinding

class ForgetPasswordGetEmailActivity : BaseActivity() {
    private lateinit var binding: ActivityForgetPasswordGetEmailBinding
    private lateinit var context: Context
    private lateinit var email: String
    private val emailPattern: String = "[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        context = this
        super.onCreate(savedInstanceState)
        defineBinding()
        binding.btnGetVerificationCode.setOnClickListener {
            if(checkNetwork()){
                getEmail()
                if(checkEmail()){
                    // true --> send verification code to user's email
                    sendVerificationCode()
                }
            }else{
                changActivity(NoInternetActivity::class.java)
            }
        }
    }

    private fun defineBinding() {
        binding = ActivityForgetPasswordGetEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getEmail() {
        email = binding.etInputEmailForgetPassword.text.toString()
    }

    private fun validateEmail(eml:String): Boolean {
        return (eml.matches(emailPattern.toRegex()))
    }
    private fun checkEmail(): Boolean {
        if (email.length == 0) {
            // error ---> email is null
            showToastLong("لطفا ایمیل خود را وارد نمایید.")
            return false
        } else {
            if (validateEmail(email)) {
                // true ---> email is valid
                return true
            } else {
                // false ---> email is invalid
                showToastLong("ایمیل وارد شده صحیح نمی باشد.")
                return false
            }
        }
    }
    private fun sendVerificationCode(){
        changActivity(ForgetPasswordVerifyEmailActivity::class.java)
    }
}