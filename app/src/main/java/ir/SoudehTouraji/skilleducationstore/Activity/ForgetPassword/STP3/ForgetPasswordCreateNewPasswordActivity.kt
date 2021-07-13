package ir.SoudehTouraji.skilleducationstore.Activity.ForgetPassword.STP3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.SoudehTouraji.skilleducationstore.Activity.Login.LoginActivity
import ir.SoudehTouraji.skilleducationstore.Components.BaseActivity
import ir.SoudehTouraji.skilleducationstore.Dialog.NoInternet.NoInternetActivity
import ir.SoudehTouraji.skilleducationstore.databinding.ActivityForgetPasswordCreateNewPasswordBinding

class ForgetPasswordCreateNewPasswordActivity : BaseActivity() {
    private lateinit var binding: ActivityForgetPasswordCreateNewPasswordBinding
    private lateinit var context:Context
    private lateinit var password: String
    private lateinit var confirmPassword: String
    private val securityPattern: String =
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,20}\$"
    override fun onCreate(savedInstanceState: Bundle?) {
        context=this
        super.onCreate(savedInstanceState)
        defineBinding()
        binding.btnConfirmNewPassword.setOnClickListener {
            if(checkNetwork()){
                getPassword()
                if(checkPassword()){
                    getConfirmPassword()
                    if(checkConfirmPassword()){
                        // true --> send new password to server
                        submitNewPassword()
                    }
                }
            }else{
                changActivity(NoInternetActivity::class.java)
            }
            
        }

    }
    private fun defineBinding(){
        binding=ActivityForgetPasswordCreateNewPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getPassword(){
        password=binding.etInputNewPassword.text.toString()
    }

    private fun getConfirmPassword(){
        confirmPassword=binding.etInputConfirmNewPassword.text.toString()
    }

    private fun checkPasswordSecurity(pwd: String): Boolean {
        // true ---> Password is valid
        // false ---> Password is invalid
        return pwd.matches(securityPattern.toRegex())
    }

    private fun checkPassword(): Boolean {
        if (password.length == 0) {
            //error password is empty
            showToastLong("لطفا کلمه عبور را وارد نمایید.")
            return false
        } else {
            if (password.length >= 8) {
                // min length password id ok
                if (checkPasswordSecurity(password)) {
                    return true
                } else {
                    showToastLong(
                        "کلمه عبور باید شامل حداقل یک حرف بزرگ، یک حرف کوچک و دیگر کارکترها باشد"
                    )
                    return false
                }

            } else {
                // error ---> password length is too short
                showToastLong("کلمه عبور کوتاه می باشد. ")
                return false

            }

        }
    }

    private fun checkConfirmPassword():Boolean{
        if(confirmPassword.length==0){
            // error ---> confirm password is empty
            showToastLong("لطفا تائیدیه کلمه عبور را وارد نمائید.")
            return false
        }
        else{
            return password.equals(confirmPassword)
        }
    }

    private fun submitNewPassword(){
        changActivity(LoginActivity::class.java)
    }
}