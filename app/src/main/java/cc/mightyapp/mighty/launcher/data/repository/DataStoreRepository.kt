package cc.mightyapp.mighty.launcher.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import cc.mightyapp.mighty.common.data.entities.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : DataStoreOperations {

    override suspend fun saveBool(key: Preferences.Key<Boolean>, value: Boolean) {
        dataStore.edit {
            it[key] = value
        }
    }

    override suspend fun saveStr(key: Preferences.Key<String>, value: String) {
        dataStore.edit {
            it[key] = value
        }
    }

    override fun readBool(key: Preferences.Key<Boolean>): Flow<Result<Boolean>> {
        return dataStore.data.map {
            Result.Success(it[key] ?: false)
        }
    }

    override fun readStr(key: Preferences.Key<String>): Flow<Result<String>> {
        return dataStore.data.map { Result.Success(it[key]!!) }
    }
}