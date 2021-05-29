package cc.mightyapp.mighty.launcher.data.interactor

import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenInput

interface LauncherInteractor {
    suspend fun isValid(input: ValidateTokenInput): Boolean

    suspend fun getUserId(): String

    suspend fun getToken(): String
}