package cc.mightyapp.mighty.data.repository.auth

import cc.mightyapp.mighty.data.io.input.LogInWithEmailInput
import cc.mightyapp.mighty.data.io.output.LogInWithEmailResponse

interface AuthRepository {

    suspend fun logInWithEmail(input: LogInWithEmailInput): LogInWithEmailResponse

    suspend fun validateToken(token: String): Boolean
}