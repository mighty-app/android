package cc.mightyapp.mighty.main.main.ui.composables

import android.content.Context
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
import cc.mightyapp.mighty.main.dashboard.ui.composables.DashboardContent
import cc.mightyapp.mighty.main.dashboard.ui.presenter.DashboardViewModel
import cc.mightyapp.mighty.main.exercises.ui.composables.ExercisesContent
import cc.mightyapp.mighty.main.exercises.ui.presenter.ExercisesViewModel
import cc.mightyapp.mighty.main.main.data.entities.MightyTabs
import cc.mightyapp.mighty.main.main.data.entities.MightyUtil
import cc.mightyapp.mighty.main.main.data.util.generateMightyUtil
import cc.mightyapp.mighty.main.main.ui.presenter.MainViewModel
import coil.ImageLoader
import coil.decode.SvgDecoder
import com.google.accompanist.insets.navigationBarsPadding

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun MainContent(userId: String, token: String, context: Context) {

    val mainViewModel: MainViewModel = viewModel()
    mainViewModel.mainInit(userId = userId, token = token)

    val user by mainViewModel.user.collectAsState()

    val exercisesViewModel: ExercisesViewModel = viewModel()

    val dashboardViewModel: DashboardViewModel = viewModel()
    dashboardViewModel.dashboardInit(levelId = user.level)

    val (selectedTab, setSelectedTab) = remember { mutableStateOf(MightyTabs.Dashboard) }
    val tabs = MightyTabs.values()

    val mightyUtil = generateMightyUtil(context = context)

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
            MightyTabs.Dashboard -> DashboardContent(
                mainViewModel = mainViewModel,
                dashboardViewModel = dashboardViewModel,
                mightyUtil = mightyUtil
            )

            MightyTabs.Exercises -> ExercisesContent(
                mainViewModel = mainViewModel,
                exercisesViewModel = exercisesViewModel
            )
        }
    }

}
