package cc.mightyapp.mighty.launcher.data.repository

import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenInput
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenResponse

interface LauncherRepository {
    suspend fun validateToken(input: ValidateTokenInput): RequestResult<ValidateTokenResponse, Exception>
}