package net.idik.lessme.feature

import android.os.Bundle
import net.idik.lessme.R
import net.idik.lessme.core.base.BaseActivity
import net.idik.lessme.core.base.annotation.Backable
import net.idik.lib.slimintent.SlimIntent
import net.idik.lib.slimintent.annotations.AutoIntent
import net.idik.lib.slimintent.annotations.IntentArg

@AutoIntent
@Backable
class UserCenterActivity : BaseActivity() {

    @field:IntentArg
    @JvmField
    var userId: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_center)
        SlimIntent.bind(this)
    }

}
