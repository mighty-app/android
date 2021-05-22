package cc.mightyapp.mighty.domain.launcher

import cc.mightyapp.mighty.data.repository.datastore.DataStoreOperations
import cc.mightyapp.mighty.data.repository.datastore.PreferencesKeys
import cc.mightyapp.mighty.di.IoDispatcher
import cc.mightyapp.mighty.domain.FlowUseCase
import cc.mightyapp.mighty.domain.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OnboardingCompletedUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreOperations,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, Boolean>(ioDispatcher) {
    override fun execute(parameters: Unit): Flow<Result<Boolean>> =
        dataStoreRepository.readBool(PreferencesKeys.onboardingIsCompleted)
}