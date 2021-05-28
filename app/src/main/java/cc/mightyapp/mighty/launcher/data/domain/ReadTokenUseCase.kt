package cc.mightyapp.mighty.launcher.data.domain

import cc.mightyapp.mighty.common.data.domain.FlowUseCase
import cc.mightyapp.mighty.common.data.entities.Result
import cc.mightyapp.mighty.di.IoDispatcher
import cc.mightyapp.mighty.launcher.data.repository.DataStoreOperations
import cc.mightyapp.mighty.launcher.data.repository.PreferencesKeys
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadTokenUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreOperations,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, String>(ioDispatcher) {
    override fun execute(parameters: Unit): Flow<Result<String>> =
        dataStoreRepository.readStr(PreferencesKeys.token)
}