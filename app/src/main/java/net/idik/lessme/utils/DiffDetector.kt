package net.idik.lessme.utils

import com.google.gson.Gson

/**
 * Created by linshuaibin on 15/02/2017.
 */

class DiffDetector(vararg targets: Any?) {

    private var value: String

    init {
        this.value = gson.toJson(targets.map { it ?: "" })
    }

    operator fun invoke(vararg newTargets: Any?): Boolean {
        val newValue = gson.toJson(newTargets.map { it ?: "" })
        return value != newValue
    }

    override fun toString(): String {
        return "DiffDetector(value='$value')"
    }

    companion object {
        val gson = Gson()
    }


}
