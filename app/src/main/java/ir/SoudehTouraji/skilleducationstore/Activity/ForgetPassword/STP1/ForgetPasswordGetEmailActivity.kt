package ir.SoudehTouraji.skilleducationstore.Activity.ForgetPassword.STP1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.SoudehTouraji.skilleducationstore.databinding.ActivityForgetPasswordGetEmailBinding
import ir.SoudehTouraji.skilleducationstore.databinding.ActivitySignUpBinding

class ForgetPasswordGetEmailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgetPasswordGetEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        defineBinding()
    }
    private fun defineBinding(){
        binding= ActivityForgetPasswordGetEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}