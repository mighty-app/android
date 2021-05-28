package cc.mightyapp.mighty.common.data.api

import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailInput
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenInput
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailResponse
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface MightyApi {

    // Auth

    @POST("/auth/login/email")
    suspend fun logInWithEmail(
        @Body input: LogInWithEmailInput
    ): LogInWithEmailResponse

    @POST("/auth/validate/token")
    suspend fun validateToken(
        @Body input: ValidateTokenInput
    ): ValidateTokenResponse
}