package net.idik.lessme.core.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.gturedi.views.StatefulLayout
import net.idik.lessme.R

import org.jetbrains.anko.find

/**
 * Created by linshuaibin on 28/02/2017.
 */
abstract class BaseStatefulActivity : BaseActivity() {

    val statefulLayout by lazy { find<StatefulLayout>(R.id.stateful_layout) }
    private val statefulViewContainer by lazy { find<FrameLayout>(R.id.stateful_view_container) }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_stateful_base)
    }

    override fun setContentView(layoutResID: Int) {
        statefulViewContainer.apply {
            removeAllViews();
            addView(layoutInflater.inflate(layoutResID, statefulViewContainer, false))
        }
    }

    override fun setContentView(view: View?) {
        statefulViewContainer.apply {
            removeAllViews();
            addView(view)
        }
    }

    override fun setContentView(view: View?, params: ViewGroup.LayoutParams?) {
        statefulViewContainer.apply {
            removeAllViews();
            addView(view, params)
        }
    }

}