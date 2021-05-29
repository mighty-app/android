package cc.mightyapp.mighty.common.data.entities

sealed class RequestResult<out Value, out Error> {
    data class Success<Value>(val payload: Value) : RequestResult<Value, Nothing>()
    data class Failure<Error>(val error: Error) : RequestResult<Nothing, Error>()

    fun interface Factory<Error> {
        fun handleError(throwable: Throwable): Error

        fun <Value> createFrom(operation: () -> Value): RequestResult<Value, Error> = try {
            Success(operation())
        } catch (t: Throwable) {
            Failure(handleError(t))
        }
    }
}
