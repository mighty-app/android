package cc.mightyapp.mighty.main.startworkout.ui.presenter

import androidx.lifecycle.ViewModel
import cc.mightyapp.mighty.common.data.fakes.FakeRoutines
import cc.mightyapp.mighty.common.data.models.Routine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class StartWorkoutViewModel @Inject constructor(

) : ViewModel() {

    private val _routines = MutableStateFlow(listOf(FakeRoutines.StrongLiftsA))
    val routines : StateFlow<List<Routine>>
        get() = _routines
}