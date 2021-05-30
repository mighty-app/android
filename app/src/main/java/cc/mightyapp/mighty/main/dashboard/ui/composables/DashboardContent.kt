package cc.mightyapp.mighty.main.dashboard.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cc.mightyapp.mighty.main.dashboard.ui.presenter.DashboardViewModel
import cc.mightyapp.mighty.main.main.data.entities.MightyUtil
import cc.mightyapp.mighty.main.main.ui.presenter.MainViewModel
import com.google.accompanist.coil.LocalImageLoader
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun DashboardContent(
    mainViewModel: MainViewModel,
    dashboardViewModel: DashboardViewModel,
    mightyUtil: MightyUtil

) {
    val user by mainViewModel.user.collectAsState()
    val level by dashboardViewModel.level.collectAsState()

    if (user.isLoggedIn.not().or(level.graphic.isEmpty())) return


    Column {
        Row {

            Text("Hey, ${user.firstName}!")
        }

        CompositionLocalProvider(LocalImageLoader provides mightyUtil.imageLoader) {

            Image(
                painter = rememberCoilPainter(
                    request = level.graphic,
                    fadeIn = true,
                ),
                contentDescription = "Level 1",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}