package cc.mightyapp.mighty.data.api

import cc.mightyapp.mighty.data.io.input.LogInWithEmailInput
import cc.mightyapp.mighty.data.io.output.LogInWithEmailResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface MightyApi {

    // Auth

    @POST("/auth/login/email")
    suspend fun logInWithEmail(
        @Body input: LogInWithEmailInput
    ): LogInWithEmailResponse

    @POST("/auth/token/validate")
    suspend fun validateToken(
        @Body token: String
    ): Boolean
}