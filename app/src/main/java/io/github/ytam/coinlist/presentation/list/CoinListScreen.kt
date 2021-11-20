package io.github.ytam.coinlist.presentation.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionResult
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import io.github.ytam.coinlist.R
import io.github.ytam.coinlist.component.CoinListItem
import io.github.ytam.coinlist.navigation.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    var state = viewModel.state.value
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val showButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {

        val (topAppBar, dataList, scrollToTopButton, errorLayout, isLoadingLayout, errorMessageLottie) = createRefs()

        TopAppBar(
            modifier = Modifier.constrainAs(topAppBar) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                height = Dimension.value(56.dp)
            },
            title = {
                Text(
                    text = "Coin List",
                    modifier = Modifier.fillMaxWidth()
                )
            },
            contentColor = MaterialTheme.colors.onSurface
        )

        LazyColumn(
            modifier = Modifier.constrainAs(dataList) {
                top.linkTo(topAppBar.bottom, 56.dp)
                bottom.linkTo(parent.bottom, 8.dp)
                start.linkTo(parent.start, 8.dp)
                end.linkTo(parent.end, 8.dp)
            },
            state = listState
        ) {

            items(state.data) { coinItem ->
                CoinListItem(
                    coin = coinItem,
                    onItemClick = {
                        navController.navigate(Screen.CoinDetailsScreen.route + "/${coinItem.id}")
                    }
                )
            }

        }

        if (state.errorMessage.isNotBlank()) {

            val lottieCompositionResult: LottieCompositionResult =
                rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.error_dialog))

            val progress by animateLottieCompositionAsState(
                lottieCompositionResult.value,
                isPlaying = true,
                iterations = LottieConstants.IterateForever,
                speed = 1.0f
            )

            LottieAnimation(
                composition = lottieCompositionResult.value,
                progress = progress,

                modifier = Modifier.constrainAs(errorMessageLottie) {
                    top.linkTo(topAppBar.bottom, 56.dp)
                    start.linkTo(parent.start, 20.dp)
                    end.linkTo(parent.end, 20.dp)
                    height = Dimension.value(156.dp)
                },
            )

            Text(
                text = state.errorMessage,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(errorLayout) {
                    top.linkTo(errorMessageLottie.bottom, 20.dp)
                    start.linkTo(parent.start, 20.dp)
                    end.linkTo(parent.end, 20.dp)
                }
            )
        }

        if (state.isLoading) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.constrainAs(isLoadingLayout) {
                    top.linkTo(topAppBar.bottom, 56.dp)
                    bottom.linkTo(parent.bottom, 8.dp)
                    start.linkTo(parent.start, 20.dp)
                    end.linkTo(parent.end, 20.dp)
                }
            ) {

                val lottieCompositionResult: LottieCompositionResult =
                    rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))

                val progress by animateLottieCompositionAsState(
                    lottieCompositionResult.value,
                    isPlaying = true,
                    iterations = LottieConstants.IterateForever,
                    speed = 1.0f
                )

                LottieAnimation(
                    composition = lottieCompositionResult.value,
                    progress = progress,
                    modifier = Modifier.padding(all = 30.dp)
                )
            }
        }

        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.constrainAs(scrollToTopButton) {
                bottom.linkTo(parent.bottom, 8.dp)
                start.linkTo(parent.start, 8.dp)
                end.linkTo(parent.end, 8.dp)
            }
        ) {
            ScrollToTopButton(
                onClick = {
                    coroutineScope.launch {
                        listState.animateScrollToItem(index = 0)
                    }
                }
            )
        }
    }
}

@Composable
fun ScrollToTopButton(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Icon(
            painter = painterResource(id = android.R.drawable.arrow_up_float),
            contentDescription = "scroll_to_top"
        )
    }
}

