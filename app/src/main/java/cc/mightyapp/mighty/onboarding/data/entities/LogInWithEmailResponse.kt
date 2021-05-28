package cc.mightyapp.mighty.onboarding.data.entities

import cc.mightyapp.mighty.common.data.models.User

data class LogInWithEmailResponse(
    val token: String,
    val user: User
)
