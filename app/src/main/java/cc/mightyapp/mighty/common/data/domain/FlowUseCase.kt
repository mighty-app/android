package cc.mightyapp.mighty.common.data.domain

import cc.mightyapp.mighty.common.data.entities.RequestResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    operator fun invoke(parameters: P): Flow<RequestResult<R, Exception>> = execute(parameters)
        .catch { e -> emit(RequestResult.Failure(Exception(e))) }
        .flowOn(coroutineDispatcher)

    protected abstract fun execute(parameters: P): Flow<RequestResult<R, Exception>>
}