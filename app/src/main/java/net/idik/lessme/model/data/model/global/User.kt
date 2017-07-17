package net.idik.lessme.model.data.model.global

/**
 * Created by linshuaibin on 23/02/2017.
 */

data class User(

        val id: Long,

        var name: String?,

        var avatar: String?
) {
    fun isGuest() = id == 0L
}
