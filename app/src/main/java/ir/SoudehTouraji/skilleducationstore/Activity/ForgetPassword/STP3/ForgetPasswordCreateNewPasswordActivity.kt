package ir.SoudehTouraji.skilleducationstore.Activity.ForgetPassword.STP3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.SoudehTouraji.skilleducationstore.databinding.ActivityForgetPasswordCreateNewPasswordBinding

class ForgetPasswordCreateNewPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgetPasswordCreateNewPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        defineBinding()

    }
    private fun defineBinding(){
        binding=ActivityForgetPasswordCreateNewPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}