package net.idik.lessme.feature

import android.os.Bundle
import net.idik.lessme.R
import net.idik.lessme.core.base.BaseActivity
import net.idik.lib.slimintent.SlimIntent

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SlimIntent.toUserCenterActivity(this, 23).start()
    }

}
