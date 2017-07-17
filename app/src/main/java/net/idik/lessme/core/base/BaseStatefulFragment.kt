package net.idik.lessme.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_stateful_base.*
import net.idik.lessme.R

/**
 * Created by linshuaibin on 23/02/2017.
 */
abstract class BaseStatefulFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_stateful_base, container, false)
        statefulViewContainer.addView(onCreateContentView(inflater, statefulViewContainer, savedInstanceState))
        return view
    }

    abstract fun onCreateContentView(inflater: LayoutInflater?, container: ViewGroup, savedInstanceState: Bundle?): View?
}