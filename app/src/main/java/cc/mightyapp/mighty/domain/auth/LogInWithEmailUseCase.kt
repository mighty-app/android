package cc.mightyapp.mighty.domain.auth

import cc.mightyapp.mighty.data.io.input.LogInWithEmailInput
import cc.mightyapp.mighty.data.io.output.LogInWithEmailResponse
import cc.mightyapp.mighty.data.repository.auth.RealAuthRepository
import cc.mightyapp.mighty.di.IoDispatcher
import cc.mightyapp.mighty.domain.SuspendedUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LogInWithEmailUseCase @Inject constructor(
    private val authRepository: RealAuthRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendedUseCase<LogInWithEmailInput, LogInWithEmailResponse>(ioDispatcher){
    override suspend fun execute(parameters: LogInWithEmailInput): LogInWithEmailResponse {
        return authRepository.logInWithEmail(parameters)
    }
}