package net.idik.lessme.core

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.marcinmoskala.kotlinpreferences.PreferenceHolder
import io.paperdb.Paper
import net.idik.lessme.model.session.session

/**
 * Created by linshuaibin on 23/02/2017.
 */
class Core : Application(), AppLifecycleManager.IAppLifecycleListener {

    override fun onCreate() {
        super.onCreate()
        _instance = this
        Paper.init(this)
        AppLifecycleManager.init(this)
        AppLifecycleManager.registerListener(this)
        PreferenceHolder.setContext(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onBecomeForegroundRunning() {
    }

    override fun onBecomeBackgroundRunning() {
        if (!AppLifecycleManager.isRunningForeground) {
            session?.close()
            AppLifecycleManager.exitApp()
        }
    }

    companion object {
        private var _instance: Core? = null
        val instance: Core
            get() = _instance!!
    }

}