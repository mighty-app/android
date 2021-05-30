package cc.mightyapp.mighty.main.main.ui.composables

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import cc.mightyapp.mighty.main.exercises.ui.presenter.ExercisesViewModel
import cc.mightyapp.mighty.main.main.ui.composables.MightyViewModels
import cc.mightyapp.mighty.main.main.ui.composables.generateMightyViewModels
import cc.mightyapp.mighty.main.main.ui.presenter.MainViewModel

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun MainContent(userId: String, token: String) {

    val mainViewModel: MainViewModel = viewModel()
    mainViewModel.mainInit(userId = userId, token = token)

    val exercisesViewModel: ExercisesViewModel = viewModel()

    val user by mainViewModel.user.collectAsState()

    if (user.isLoggedIn.not()) {
        return Column {
            Text("Mighty")
            Text("Token = $token")
            Text("User Id = $userId")
        }
    }

    if (user.isLoggedIn) {
        return Column {
            Text(user.firstName)
            Text(user.lastName)
        }
    }


//    val viewModels: RealViewModels = GetViewModels(userId = userId, token = token)
//
//    val isLoading: Boolean by viewModels.mainViewModel.isLoading.collectAsState()
//    val state: MainViewState by viewModels.mainViewModel.state.collectAsState()
//
//    val (selectedTab, setSelectedTab) = remember { mutableStateOf(MightyTabs.Dashboard) }
//    val tabs = MightyTabs.values()
//
//    Scaffold(
//        backgroundColor = MaterialTheme.colors.primarySurface,
//        topBar = { MightyTopBar() },
//        bottomBar = {
//            BottomNavigation {
//                tabs.forEach { tab ->
//                    BottomNavigationItem(
//                        icon = { Icon(imageVector = tab.icon, contentDescription = null) },
//                        label = { Text(text = stringResource(id = tab.title)) },
//                        selected = tab == selectedTab,
//                        onClick = { setSelectedTab(tab) },
//                        modifier = Modifier.navigationBarsPadding()
//                    )
//                }
//            }
//        }
//    ) {
//        when (selectedTab) {
//            MightyTabs.Dashboard -> DashboardContent(viewModel = viewModels.dashboardViewModel)
//            MightyTabs.Exercises -> ExercisesContent(viewModel = viewModels.exercisesViewModel)
//        }
//    }
}
