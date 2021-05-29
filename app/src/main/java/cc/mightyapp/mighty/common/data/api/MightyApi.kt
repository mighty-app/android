package cc.mightyapp.mighty.common.data.api

import cc.mightyapp.mighty.common.data.entities.MightyError
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenInput
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenResponse
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailInput
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface MightyApi {

    // Auth

    @POST("/auth/login/email")
    suspend fun logInWithEmail(
        @Body input: LogInWithEmailInput
    ): RequestResult<LogInWithEmailResponse, Exception>

    @POST("/auth/validate/token")
    suspend fun validateToken(
        @Body input: ValidateTokenInput
    ): RequestResult<ValidateTokenResponse, Exception>
}