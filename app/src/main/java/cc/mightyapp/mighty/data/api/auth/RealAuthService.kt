package cc.mightyapp.mighty.data.api.auth

import cc.mightyapp.mighty.data.api.MightyApi
import cc.mightyapp.mighty.data.io.input.LogInWithEmailInput
import cc.mightyapp.mighty.data.io.output.LogInWithEmailResponse

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RealAuthService @Inject constructor(
    private val api: MightyApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : AuthService {
    override suspend fun logInWithEmail(input: LogInWithEmailInput): LogInWithEmailResponse =
        withContext(ioDispatcher) {
            api.logInWithEmail(input)
        }

    override suspend fun validateToken(token: String): Boolean =
        withContext(ioDispatcher) {
            api.validateToken(token)
        }
}