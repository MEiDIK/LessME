package net.idik.lessme.utils

import android.os.Environment
import net.idik.lessme.R
import net.idik.lessme.core.Core
import java.io.File

class LessmeIO(val key: String) {

    private val DATA = String.format("iDIK/%s/%s/data", Core.instance.getString(R.string.app_name), key)
    private val CACHE = String.format("iDIK/%s/%s/cache", Core.instance.getString(R.string.app_name), key)

    val dataDir: File
        get() {
            val dir = File(Environment.getExternalStorageDirectory(), DATA)
            if (!dir.exists()) {
                dir.mkdirs()
            }
            return dir
        }

    val cacheDir: String
        get() {
            val dir = File(Environment.getExternalStorageDirectory(), CACHE)
            if (!dir.exists()) {
                dir.mkdirs()
            }

            return dir.absolutePath
        }

    val tmpDir: String
        get() {
            val dir = File(cacheDir, "tmp")
            if (!dir.exists()) {
                dir.mkdirs()
            }
            return dir.absolutePath
        }
}
