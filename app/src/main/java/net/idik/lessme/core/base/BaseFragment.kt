package net.idik.lessme.core.base

import android.os.Bundle
import android.view.View
import net.idik.lessme.core.base.annotation.AutoHideKeyboard
import net.idik.lessme.core.base.rx.RxFragment
import net.idik.lessme.utils.KeyboardUtils
import org.jetbrains.anko.AnkoLogger

/**
 * Created by linshuaibin on 23/02/2017.
 */
abstract class BaseFragment() : RxFragment(), AnkoLogger {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (this::class.java.isAnnotationPresent(AutoHideKeyboard::class.java)) {
            KeyboardUtils.setupAutoHideKeyboard(activity, view)
        }
    }
}