package ir.SoudehTouraji.skilleducationstore.Components

import android.R
import android.app.Application
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump


class Base :Application(){
    override fun onCreate() {
        super.onCreate()
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/lalezar.ttf")
                            .setFontAttrId(R.attr.font)
                            .build()
                    )
                )
                .build()
        )
    }
}