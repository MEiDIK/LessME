package net.idik.lessme.utils

import com.marcinmoskala.kotlinpreferences.PreferenceHolder
import net.idik.lessme.R
import net.idik.lessme.utils.extensions.resString

/**
 * Created by linshuaibin on 30/03/2017.
 */
object LessmePrefs : PreferenceHolder() {

    var mirrorMode: Boolean by bindToPreferenceField(false, R.string.pkey_anyme_mirror_mode.resString())

}

