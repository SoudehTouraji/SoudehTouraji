package ir.SoudehTouraji.skilleducationstore.Activity.SignUp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.SoudehTouraji.skilleducationstore.Components.BaseActivity
import ir.SoudehTouraji.skilleducationstore.Dialog.NoInternet.NoInternetActivity
import ir.SoudehTouraji.skilleducationstore.databinding.ActivityNoInternetBinding
import ir.SoudehTouraji.skilleducationstore.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var confirmPassword: String
    private lateinit var context: Context
    private val emailPattern: String = "[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+"
    private val securityPattern: String =
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,20}\$"
    override fun onCreate(savedInstanceState: Bundle?) {
        context=this
        super.onCreate(savedInstanceState)
        defineBinding()
        binding.btnSignUp.setOnClickListener {
            if (checkNetwork()){
                //network is connect
                doSignUp()
            }else{
                // network isn't connect
                getIntent(context,NoInternetActivity::class.java)
            }

        }
    }
    private fun getEmail(){
        email=binding.etInputEmailSignUp.text.toString()
    }

    private fun getPassword(){
        password=binding.etPasswordSignUp.text.toString()
    }

    private fun getConfirmPassword(){
        confirmPassword=binding.etConfirmPasswordSignUp.text.toString()
    }

    private fun defineBinding(){
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

    private fun validateEmail(eml: String): Boolean {
        // true ---> email is valid
        // false ---> email is invalid
        return eml.matches(emailPattern.toRegex())
    }

    private fun checkPasswordSecurity(pwd: String): Boolean {
        // true ---> Password is valid
        // false ---> Password is invalid
        return pwd.matches(securityPattern.toRegex())
    }
    private fun doSignUp(){
        getEmail()
        if(checkEmail()){
            getPassword()
            if(checkPassword()){
                getConfirmPassword()
                if(checkConfirmPassword()){
                    // true ---> do sign up
                    showToastLong("ثبت نام انجام شد.")
                }
                else{
                    showToastLong("کلمه عبور با تائیدیه کلمه عبور مطابقت ندارد.")
                }
            }
        }
    }
}