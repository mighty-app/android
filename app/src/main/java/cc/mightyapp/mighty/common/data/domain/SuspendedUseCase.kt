package cc.mightyapp.mighty.common.data.domain

import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.common.data.entities.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber

abstract class SuspendedUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {
    suspend operator fun invoke(parameters: P): RequestResult<R, Exception> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let {
                    RequestResult.Success(it)
                }
            }
        } catch (e: Exception) {
            Timber.d(e)
            RequestResult.Failure(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}
