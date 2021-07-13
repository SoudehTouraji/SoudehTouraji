package ir.SoudehTouraji.skilleducationstore.Activity.ForgetPassword.STP2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.SoudehTouraji.skilleducationstore.Activity.ForgetPassword.STP3.ForgetPasswordCreateNewPasswordActivity
import ir.SoudehTouraji.skilleducationstore.Components.BaseActivity
import ir.SoudehTouraji.skilleducationstore.Dialog.NoInternet.NoInternetActivity
import ir.SoudehTouraji.skilleducationstore.databinding.ActivityForgetPasswordVerifyEmailBinding

class ForgetPasswordVerifyEmailActivity : BaseActivity() {
    private lateinit var binding: ActivityForgetPasswordVerifyEmailBinding
    private lateinit var context:Context
    private lateinit var password: String
    override fun onCreate(savedInstanceState: Bundle?) {
        context=this
        super.onCreate(savedInstanceState)
        defineBinding()
        binding.btnGetVerifyCode.setOnClickListener {
            if (checkNetwork()){
                getPassword()
                if(checkPassword()){
                    sendCodeForValidation()
                }
            }else{
                changActivity(NoInternetActivity::class.java)
            }

        }

    }
    private fun defineBinding(){
        binding=ActivityForgetPasswordVerifyEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun getPassword() {
        password = binding.etInputVerificationCode.text.toString()
    }
    private fun checkPassword(): Boolean {
        if (password.length == 0) {
            //error password is empty
            showToastLong("لطفا کد تائیدیه را وارد نمایید.")
            return false
        } else {
            if (password.length == 8) {
                // min length password id ok
                return true
            } else {
                // error ---> password length is too short
                showToastLong("کد تائیدیه کوتاه می باشد. ")
                return false

            }

        }
    }
    private fun sendCodeForValidation(){
        changActivity(ForgetPasswordCreateNewPasswordActivity::class.java)
    }

}