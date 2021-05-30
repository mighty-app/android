package cc.mightyapp.mighty.main.main.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import cc.mightyapp.mighty.main.main.ui.presenter.MainViewModel

//data class MightyViewModels(
//    val mainViewModel: ViewModel,
//    val dashboardViewModel: ViewModel,
//    val historyViewModel: ViewModel,
//    val workoutViewModel: ViewModel,
//    val exercisesViewModel: ViewModel,
//    val settingsViewModel: ViewModel
//)

data class MightyViewModels(
    val mainViewModel: MainViewModel
)

@Composable
fun generateMightyViewModels(userId: String, token: String): MightyViewModels {
    val mainViewModel : MainViewModel = viewModel()
    mainViewModel.mainInit(userId = userId, token = token)

    val user by mainViewModel.user.collectAsState()

    return MightyViewModels(
        mainViewModel = mainViewModel
    )
}