package cc.mightyapp.mighty.launcher.data.repository

import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenInput
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenResponse

interface LauncherRepository {
    suspend fun validateToken(input: ValidateTokenInput): ValidateTokenResponse
}