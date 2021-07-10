package ir.SoudehTouraji.skilleducationstore.Activity.Login

import android.content.Context
import android.os.Bundle
import ir.SoudehTouraji.skilleducationstore.Activity.SignUp.SignUpActivity
import ir.SoudehTouraji.skilleducationstore.Components.BaseActivity
import ir.SoudehTouraji.skilleducationstore.Dialog.NoInternet.NoInternetActivity
import ir.SoudehTouraji.skilleducationstore.databinding.ActivityLoginBinding
import kotlin.text.toRegex as toRegex

class LoginActivity : BaseActivity() {
    private lateinit var context: Context
    private lateinit var binding: ActivityLoginBinding
    private lateinit var email: String
    private lateinit var password: String

    // email pattern example S.touraji66@gmail.com
    private val emailPattern: String = "[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+"
    private val securityPattern: String =
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,20}\$"

    override fun onCreate(savedInstanceState: Bundle?) {
        context = this
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            if (checkNetwork()) {
                // go to login
                sendRequest()
            } else {
                //show no internet dialog
                getIntent(context, NoInternetActivity::class.java)
            }
        }
        binding.tvTitleSignup.setOnClickListener {
            getIntent(context, SignUpActivity::class.java)
        }
    }

    private fun sendRequest() {
        getEmail()
        if (checkEmail()) {
            //true you can check password
            getPassword()
            if (checkPassword()) {
                // true you can send request to server
                showToastLong("اطلاعات صحیح وارد شده است.")
            }
        }
    }

    private fun getEmail() {
        email = binding.etUsernameLogin.text.toString()
    }

    private fun getPassword() {
        password = binding.etPasswordLogin.text.toString()
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
}