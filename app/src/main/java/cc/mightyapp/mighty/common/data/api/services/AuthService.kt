package cc.mightyapp.mighty.common.data.api.services

import cc.mightyapp.mighty.common.data.entities.MightyError
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenInput
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenResponse
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailInput
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailResponse

interface AuthService {

    suspend fun logInWithEmail(input: LogInWithEmailInput): RequestResult<LogInWithEmailResponse, Exception>

    suspend fun validateToken(input: ValidateTokenInput): RequestResult<ValidateTokenResponse, Exception>
}