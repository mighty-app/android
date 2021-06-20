package cc.mightyapp.mighty.main.workout.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import cc.mightyapp.mighty.common.ui.theme.MightyTheme
import cc.mightyapp.mighty.main.workout.ui.composables.WorkoutNavGraph
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WorkoutFragment : Fragment() {

    @ExperimentalFoundationApi
    @ExperimentalAnimationApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {
            setContent {
                MightyTheme {
                    WorkoutNavGraph()
                }
            }
        }
    }
}