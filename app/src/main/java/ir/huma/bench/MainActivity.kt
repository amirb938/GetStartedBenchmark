package ir.huma.bench

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.huma.bench.ui.theme.GetStartedBenchMarkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GetStartedBenchMarkTheme {
                MainScreen()

            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    focusRequester: FocusRequester = remember { FocusRequester() }
) {

    val lazyListSate = rememberLazyListState()
//    var contentComposed by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("item_list"),
        state = lazyListSate,
        userScrollEnabled = true
    ) {
        items(100) {
            Movie(title = "Movie name is : $it")
        }
    }
//    ReportDrawnWhen(contentComposed)
}

@Composable
fun Movie(modifier: Modifier = Modifier, title: String) {
    var focus by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .focusable(true)
            .onFocusChanged { focusState ->
                focus = focusState.hasFocus
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            color = if (focus) Color.Red else Color.Black
        )
    }
}

@Preview
@Composable
fun MainScreenPreview(modifier: Modifier = Modifier) {
    GetStartedBenchMarkTheme {
        MainScreen()
    }
}