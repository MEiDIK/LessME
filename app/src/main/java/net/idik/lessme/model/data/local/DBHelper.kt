package net.idik.lessme.model.data.local

import android.content.Context
import io.paperdb.Paper

/**
 * Created by linshuaibin on 23/02/2017.
 */

val Context.db by lazy { Paper.book("GLOBAL_BOOK") }
