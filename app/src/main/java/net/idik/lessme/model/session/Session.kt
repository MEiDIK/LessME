package net.idik.lessme.model.session

import android.content.Context
import io.paperdb.Paper
import net.idik.lessme.model.data.model.global.User
import net.idik.lessme.utils.LessmeIO
import net.idik.lessme.utils.extensions.md5Encode

/**
 * Created by linshuaibin on 23/02/2017.
 */
class Session private constructor(val user: User, val sessionKey: String = user.id.toString().md5Encode()!!) {

    val db by lazy { Paper.book("SESSION_BOOK_$sessionKey") }

    val io: LessmeIO by lazy {
        LessmeIO(sessionKey)
    }

    fun close(): Boolean {
        current = null
        return true
    }

    companion object {

        var current: Session? = null

        fun open(user: User): Session {
            current?.apply {
                if (this.user != user) {
                    this.close()
                    current = null
                }
            }
            if (current == null) {
                current = Session(user)
            }
            return current!!
        }

        fun with(user: User): Session {
            return if (current?.user == user) current!! else Session(user)
        }

    }

}

val Context.session: Session?
    get() = Session.current

