package cc.mightyapp.mighty.common.data.api.services

import cc.mightyapp.mighty.common.data.api.MightyApi
import cc.mightyapp.mighty.common.data.entities.MightyError
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenInput
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenResponse
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailInput
import cc.mightyapp.mighty.onboarding.data.entities.LogInWithEmailResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RealAuthService @Inject constructor(
    private val api: MightyApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : AuthService {
    override suspend fun logInWithEmail(input: LogInWithEmailInput): RequestResult<LogInWithEmailResponse, Exception> =
        withContext(ioDispatcher) {
            api.logInWithEmail(input)
        }

    override suspend fun validateToken(input: ValidateTokenInput): RequestResult<ValidateTokenResponse, Exception> =
        withContext(ioDispatcher) {
            api.validateToken(input)
        }
}