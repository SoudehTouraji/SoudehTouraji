package ir.SoudehTouraji.skilleducationstore.Dialog.NoInternet

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.media.audiofx.BassBoost
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import android.provider.Settings.ACTION_WIFI_SETTINGS
import ir.SoudehTouraji.skilleducationstore.Components.BaseActivity
import ir.SoudehTouraji.skilleducationstore.databinding.ActivityNoInternetBinding

class NoInternetActivity : BaseActivity() {
    private lateinit var binding: ActivityNoInternetBinding
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        context = this
        binding = ActivityNoInternetBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)
        defineDialog()
        binding.btnData.setOnClickListener { goToMobileData() }
        binding.btnWifi.setOnClickListener { goToWifi() }

    }

    fun defineDialog() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }

        val mWidth: ViewGroup.LayoutParams = binding.clRootNoInternet.layoutParams
        mWidth.width = getWidthScreen(context) - 100
        binding.clRootNoInternet.layoutParams = mWidth

    }

    fun goToWifi() {
        /* arad sheybak codes don't work and I this code. It's just one line code!
        val intent = Intent(Intent.ACTION_MAIN, null)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)
        val cn = ComponentName("com.android.settings","com.android.settings.wifi.WifiSettings")
        intent.component = cn
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startService(intent)
        startActivity(intent)*/
        startActivity(Intent(android.provider.Settings.ACTION_WIFI_SETTINGS))
    }

    fun goToMobileData() {
        val intent = Intent()
        intent.component = ComponentName(
            "com.android.settings",
            "com.android.settings.Settings\$DataUsageSummaryActivity"
        )
        startActivity(intent)

    }
}