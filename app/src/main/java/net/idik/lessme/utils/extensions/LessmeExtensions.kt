@file:JvmName("LessmeUtils")

package net.idik.lessme.utils.extensions

import android.database.Cursor
import android.util.TypedValue
import android.widget.EditText
import com.bumptech.glide.Glide
import net.idik.lessme.core.Core
import net.idik.lessme.utils.KeyboardUtils
import net.idik.lib.slimadapter.viewinjector.IViewInjector
import org.jetbrains.anko.displayMetrics
import rebus.bottomdialog.BottomDialog
import java.io.File

/**
 * Created by linshuaibin on 26/02/2017.
 */

val IViewInjector<*>.context by lazy { Core.instance.applicationContext }

fun IViewInjector<*>.image(id: Int, path: String?): IViewInjector<*> {
    Glide.with(context).load(path ?: "").into(findViewById(id))
    return this
}

fun IViewInjector<*>.imageFromAFS(id: Int, path: String?): IViewInjector<*> {
    if (path != null) {
        Glide.with(context).load(File(path)).into(findViewById(id))
    }
    return this
}


fun BottomDialog.withMenu(menuRes: Int, onMenuItemClicked: (Int) -> Unit): BottomDialog {
    inflateMenu(menuRes)
    setOnItemSelectedListener { id ->
        onMenuItemClicked(id)
        true
    }
    return this
}


fun Int.resColor(): Int = Core.instance.resources.getColor(this)
fun Int.resString(): String = Core.instance.getString(this)
fun Int.resString(vararg formatArgs: Any): String = Core.instance.getString(this, *formatArgs)

fun Int.asDp(): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Core.instance.displayMetrics).toInt()

fun EditText.showKeyboard() = KeyboardUtils.showKeyboard(this)

fun EditText.showKeyboardAndSelectAll() = KeyboardUtils.showKeyboardAndSelectAll(this)

fun EditText.showKeyboardAndSelectEnd() = KeyboardUtils.showKeyboardAndSelectEnd(this)

fun Cursor.getString(columnName: String): String {
    return getString(getColumnIndexOrThrow(columnName))
}

fun Cursor.getLong(columnName: String): Long {
    return getLong(getColumnIndexOrThrow(columnName))
}

