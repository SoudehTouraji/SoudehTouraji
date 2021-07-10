package ir.SoudehTouraji.skilleducationstore.Activity.Splash

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import ir.SoudehTouraji.skilleducationstore.Activity.Login.LoginActivity
import ir.SoudehTouraji.skilleducationstore.Components.BaseActivity
import ir.SoudehTouraji.skilleducationstore.Dialog.NoInternet.NoInternetActivity
import ir.SoudehTouraji.skilleducationstore.R
import ir.SoudehTouraji.skilleducationstore.databinding.ActivitySplashBinding


class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var anim: Animation
    private lateinit var context: Context
    private val TIME_OUT: Long = 6000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding()
        context = this
        defineAnimation()
        setLogo()
        setAnimation()
        showSplash()

    }

    private fun viewBinding() {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun showSplash() {
        Handler().postDelayed({
            if (checkNetwork()) {
                // go to login
                getIntent(context, LoginActivity::class.java)
                finish()
            } else {
                //show no internet dialog
                getIntent(context,NoInternetActivity::class.java)
            }
        }, TIME_OUT)
    }

    private fun defineAnimation() {
        anim = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
    }

    private fun setLogo() {
        Glide.with(this).load(R.drawable.background_splash_screen).into(binding.ivLogoSplash)
    }

    private fun setAnimation() {
        binding.ivLogoSplash.startAnimation(anim)
        binding.tvSloganSplash.startAnimation(anim)
    }

}