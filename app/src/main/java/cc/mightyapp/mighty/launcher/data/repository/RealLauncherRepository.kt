package cc.mightyapp.mighty.launcher.data.repository

import cc.mightyapp.mighty.common.data.api.services.AuthService
import cc.mightyapp.mighty.common.data.entities.MightyError
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenInput
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenResponse
import javax.inject.Inject

class RealLauncherRepository @Inject constructor(
    private val authService: AuthService
) : LauncherRepository {
    override suspend fun validateToken(input: ValidateTokenInput): RequestResult<ValidateTokenResponse, Exception> =
        authService.validateToken(input)
}