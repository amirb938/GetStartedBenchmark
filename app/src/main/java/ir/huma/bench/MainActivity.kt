package ir.huma.bench

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ir.huma.bench.ui.main.ListInList
import ir.huma.bench.ui.theme.GetStartedBenchMarkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GetStartedBenchMarkTheme {
                ListInList()
            }
        }
    }
}

