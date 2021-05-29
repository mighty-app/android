package cc.mightyapp.mighty.launcher.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import cc.mightyapp.mighty.common.data.entities.RequestResult
import cc.mightyapp.mighty.common.data.entities.Result
import cc.mightyapp.mighty.common.util.Constants.Companion.KeyDoesNotExist
import cc.mightyapp.mighty.common.util.Do
import cc.mightyapp.mighty.launcher.data.entities.DataStoreError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single
import timber.log.Timber
import javax.inject.Inject

class RealDataStoreRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : DataStoreRepository {

    override suspend fun saveStr(
        key: Preferences.Key<String>,
        value: String
    ): RequestResult<Unit, Exception> {
        return try {
            dataStore.edit {
                it[key] = value
            }
            RequestResult.Success(Unit)
        } catch (e: Exception) {
            RequestResult.Failure(e)
        }
    }

    override fun readStr(key: Preferences.Key<String>): Flow<RequestResult<String, Exception>> {
        return dataStore.data.map {
            val value = it[key]

            if (value.isNullOrEmpty()) throw Exception(KeyDoesNotExist)
            else RequestResult.Success(value)

        }.catch {
            val e = Exception(it)
            Timber.d(e)
            RequestResult.Failure(e)
        }
    }
}