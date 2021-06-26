package cc.mightyapp.mighty.launcher.data.domain

import cc.mightyapp.mighty.common.data.domain.SuspendedUseCase
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.di.IoDispatcher
import cc.mightyapp.mighty.launcher.data.repository.PreferencesKeys
import cc.mightyapp.mighty.launcher.data.repository.RealDataStoreRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SaveTokenUseCase @Inject constructor(
    private val dataStoreRepository: RealDataStoreRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendedUseCase<String, RequestResult<Unit, Exception>>(ioDispatcher) {
    override suspend fun execute(parameters: String): RequestResult<Unit, Exception> =
        dataStoreRepository.saveStr(key = PreferencesKeys.token, value = parameters)
}