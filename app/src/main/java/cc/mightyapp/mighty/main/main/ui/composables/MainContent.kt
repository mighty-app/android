package cc.mightyapp.mighty.main.main.ui.composables

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import cc.mightyapp.mighty.main.exercises.ui.composables.ExercisesContent
import cc.mightyapp.mighty.main.exercises.ui.presenter.ExercisesViewModel
import cc.mightyapp.mighty.main.main.data.entities.MightyTabs
import cc.mightyapp.mighty.main.main.ui.presenter.MainViewModel
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun MainContent(userId: String, token: String) {

    val mainViewModel: MainViewModel = viewModel()
    mainViewModel.mainInit(userId = userId, token = token)

    val exercisesViewModel: ExercisesViewModel = viewModel()

    val (selectedTab, setSelectedTab) = remember { mutableStateOf(MightyTabs.Dashboard) }
    val tabs = MightyTabs.values()

    Scaffold(
        backgroundColor = MaterialTheme.colors.primarySurface,
        topBar = { MightyTopBar() },
        bottomBar = {
            BottomNavigation {
                tabs.forEach { tab ->
                    BottomNavigationItem(
                        icon = { Icon(imageVector = tab.icon, contentDescription = null) },
                        label = { Text(text = stringResource(id = tab.title)) },
                        selected = tab == selectedTab,
                        onClick = { setSelectedTab(tab) },
                    )
                }
            }
        }
    ) {
        when (selectedTab) {
            MightyTabs.Exercises -> ExercisesContent(
                mainViewModel = mainViewModel,
                exercisesViewModel = exercisesViewModel
            )
        }
    }

}
