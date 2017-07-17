package net.idik.lessme.utils

import android.app.Activity
import de.mateware.snacky.Snacky
import net.idik.lessme.R
import net.idik.lessme.utils.hub.SimpleHUD

/**
 * Created by linshuaibin on 07/04/2017.
 */


object T {

    @JvmStatic
    fun error(activity: Activity, message: String) {
        Snacky.builder()
                .setActivty(activity)
                .setText(message)
                .error()
                .show()
    }

    @JvmStatic
    fun error(activity: Activity, throwable: Throwable) {
        val message = when (throwable) {
//            is HttpException,
//            is SocketTimeoutException,
//            is UnknownHostException,
//            is ConnectException -> R.string.net_error.resString()
            else -> throwable.message.toString()
        }
        Snacky.builder()
                .setActivty(activity)
                .setText(message)
                .error()
                .show()
    }

    fun committing(activity: Activity) {
        SimpleHUD.show(activity, R.string.hub_committing, false)
    }

    fun loading(activity: Activity) {
        SimpleHUD.show(activity, R.string.hub_loading, false)
    }

    fun hub(activity: Activity, message: String) {
        SimpleHUD.show(activity, message, false)
    }

    fun dismissHub() {
        SimpleHUD.dismiss()
    }

    fun info(activity: Activity, message: String) {
        Snacky.builder()
                .setActivty(activity)
                .setText(message)
                .info()
                .show()
    }


}

