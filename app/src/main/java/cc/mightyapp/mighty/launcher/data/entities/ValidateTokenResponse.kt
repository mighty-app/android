package cc.mightyapp.mighty.launcher.data.entities

import cc.mightyapp.mighty.common.data.models.User

data class ValidateTokenResponse(
    val user: User = User(),
    val token: String = ""
)
