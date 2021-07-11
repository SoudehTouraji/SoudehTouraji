package ir.SoudehTouraji.skilleducationstore.Activity.ForgetPassword.STP2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.SoudehTouraji.skilleducationstore.databinding.ActivityForgetPasswordVerifyEmailBinding

class ForgetPasswordVerifyEmailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgetPasswordVerifyEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        defineBinding()

    }
    private fun defineBinding(){
        binding=ActivityForgetPasswordVerifyEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}