package ir.SoudehTouraji.skilleducationstore.Components

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.inflationx.viewpump.ViewPumpContextWrapper


open class BaseActivity : AppCompatActivity() {
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this

    }
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.let { ViewPumpContextWrapper.wrap(it) })
    }

    fun checkNetwork(): Boolean {
        var result = false
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cm?.run {
                cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                    result = when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        else -> false
                    }
                }
            }
        }
        else{
            cm?.run {
                cm.activeNetworkInfo?.run {
                    if(type==ConnectivityManager.TYPE_WIFI){
                        result=true
                    }
                    else if(type==ConnectivityManager.TYPE_MOBILE){
                        result=true
                    }
                }
            }
        }
        // false ----> Internet is unavailable ---> Dialog No Internet
        // true ----> Internet is available ---> Home or Login
        return result
    }

    fun getWidthScreen(context: Context):Int{
        val displayMetrics=DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getRealMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }
    fun showToastLong(message:String){
        Toast.makeText(applicationContext,message,Toast.LENGTH_LONG).show()
    }
    fun setLogo(activity: Activity,){

    }
    fun changActivity(cls: Class<*>?){
        val intent = Intent(applicationContext, cls)
        startActivity(intent)
    }
}
