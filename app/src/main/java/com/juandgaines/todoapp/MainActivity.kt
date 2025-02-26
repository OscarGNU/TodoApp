package com.juandgaines.todoapp
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.juandgaines.todoapp.data.FakeTaskLocalDataSource
import com.juandgaines.todoapp.domain.Task
import com.juandgaines.todoapp.presentation.home.HomeScreenRoot
import com.juandgaines.todoapp.presentation.screen.detail.TaskScreen
import com.juandgaines.todoapp.presentation.screen.detail.TaskScreenRoot
import com.juandgaines.todoapp.presentation.screen.detail.TaskScreenState
import com.juandgaines.todoapp.ui.theme.TodoAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppTheme {
                TaskScreenRoot()

            }
        }
    }
}
