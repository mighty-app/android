package cc.mightyapp.mighty.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.*

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun MainContent(userId: String, token: String) {
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
