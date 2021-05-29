package cc.mightyapp.mighty.launcher.data.domain

import cc.mightyapp.mighty.common.data.domain.FlowUseCase
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.di.IoDispatcher
import cc.mightyapp.mighty.launcher.data.repository.PreferencesKeys
import cc.mightyapp.mighty.launcher.data.repository.RealDataStoreRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadTokenUseCase @Inject constructor(
    private val dataStoreRepository: RealDataStoreRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, String>(ioDispatcher) {
    override fun execute(parameters: Unit): Flow<RequestResult<String, Exception>> =
        dataStoreRepository.readStr(PreferencesKeys.token)
}