package cc.mightyapp.mighty.launcher.data.interactor

import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.common.util.coroutineName
import cc.mightyapp.mighty.di.IoDispatcher
import cc.mightyapp.mighty.launcher.data.entities.ValidateTokenInput
import cc.mightyapp.mighty.launcher.data.repository.PreferencesKeys
import cc.mightyapp.mighty.launcher.data.repository.RealDataStoreRepository
import cc.mightyapp.mighty.launcher.data.repository.RealLauncherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RealLauncherInteractor @Inject constructor(
    private val launcherRepository: RealLauncherRepository,
    private val dataStoreRepository: RealDataStoreRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : LauncherInteractor {

    private val coroutineContext = ioDispatcher + coroutineName()

    override suspend fun isValid(input: ValidateTokenInput): Boolean =
        withContext(coroutineContext) { launcherRepository.validateToken(input) } is RequestResult.Success

    override suspend fun getToken(): String = withContext(coroutineContext) {
        dataStoreRepository.readStr(PreferencesKeys.token)
            .collect { if (it is RequestResult.Success) it.payload }.toString()
    }

    override suspend fun getUserId(): String = withContext(coroutineContext) {
        dataStoreRepository.readStr(PreferencesKeys.userId)
            .collect { if (it is RequestResult.Success) it.payload }.toString()

    }
}