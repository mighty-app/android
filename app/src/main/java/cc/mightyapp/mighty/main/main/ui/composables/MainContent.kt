package cc.mightyapp.mighty.main.main.ui.composables

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cc.mightyapp.mighty.main.exercises.ui.composables.ExercisesContent
import cc.mightyapp.mighty.main.exercises.ui.presenter.ExercisesViewModel
import cc.mightyapp.mighty.main.main.data.entities.MightyTabs
import cc.mightyapp.mighty.main.main.ui.presenter.MainViewModel
import com.google.accompanist.insets.navigationBarsPadding

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
        backgroundColor = MaterialTheme.colors.background,
        topBar = { MightyTopBar(title = selectedTab.title) },
        bottomBar = {
            BottomNavigation(backgroundColor = MaterialTheme.colors.surface) {
                tabs.forEach { tab ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        },
                        label = { Text(text = stringResource(id = tab.title)) },
                        selected = tab == selectedTab,
                        onClick = { setSelectedTab(tab) },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Gray,
                        modifier = Modifier
                            .navigationBarsPadding()
                            .padding()
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
