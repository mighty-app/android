package cc.mightyapp.mighty.data.api.auth

import cc.mightyapp.mighty.data.io.input.LogInWithEmailInput
import cc.mightyapp.mighty.data.io.output.LogInWithEmailResponse

interface AuthService {

    suspend fun logInWithEmail(input: LogInWithEmailInput): LogInWithEmailResponse

    suspend fun validateToken(token: String): Boolean
}