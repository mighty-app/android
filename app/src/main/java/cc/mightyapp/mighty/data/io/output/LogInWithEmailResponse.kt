package cc.mightyapp.mighty.data.io.output

import cc.mightyapp.mighty.data.models.User

data class LogInWithEmailResponse(
    val token: String,
    val user: User
)
