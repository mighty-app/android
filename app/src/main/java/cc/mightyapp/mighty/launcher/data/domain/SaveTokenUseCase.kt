package cc.mightyapp.mighty.launcher.data.domain

import cc.mightyapp.mighty.common.data.domain.SuspendedUseCase
import cc.mightyapp.mighty.di.IoDispatcher
import cc.mightyapp.mighty.launcher.data.repository.DataStoreOperations
import cc.mightyapp.mighty.launcher.data.repository.PreferencesKeys
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SaveTokenUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreOperations,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendedUseCase<String, Unit>(ioDispatcher) {
    override suspend fun execute(parameters: String) =
        dataStoreRepository.saveStr(PreferencesKeys.token, parameters)
}