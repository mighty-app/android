package cc.mightyapp.mighty.data.models

import java.util.*

data class UserToken(
    val name: String,
    val token: String,
    val type: String,
    val user: User,
    val created: Date
)
