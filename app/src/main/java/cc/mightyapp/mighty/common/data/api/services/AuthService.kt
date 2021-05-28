package cc.mightyapp.mighty.common.data.api.services

import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenInput
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenResponse
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailInput
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailResponse

interface AuthService {

    suspend fun logInWithEmail(input: LogInWithEmailInput): LogInWithEmailResponse

    suspend fun validateToken(input: ValidateTokenInput): ValidateTokenResponse
}