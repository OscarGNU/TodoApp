package com.juandgaines.todoapp.presentation.screens.home

import android.icu.text.DateFormat
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juandgaines.todoapp.data.FakeTaskLocalDataSource
import com.juandgaines.todoapp.presentation.screens.home.HomeScreenAction.OnAddTask
import com.juandgaines.todoapp.presentation.screens.home.HomeScreenAction.OnDeleteAllTasks
import com.juandgaines.todoapp.presentation.screens.home.HomeScreenAction.OnDeleteTask
import com.juandgaines.todoapp.presentation.screens.home.HomeScreenAction.OnToggleTask
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class HomeScreenViewModel:ViewModel() {

    private val taskLocalDataSource = FakeTaskLocalDataSource

    var state by   mutableStateOf(HomeDataState())
        private set

    init {

        state = state.copy(
            date = LocalDate.now().let {
                DateTimeFormatter.ofPattern("EEEE, MMMM dd yyyy").format(it)
            }
        )

        taskLocalDataSource.tasksFlow.onEach {
            val completedTasks = it.filter { task -> task.isCompleted }
            val pendingTasks = it.filter { task -> !task.isCompleted }

            state = state.copy(
                date = state.date,
                summary = pendingTasks.size.toString(),
                completedTask = completedTasks,
                pendingTask = pendingTasks
            )
        }.launchIn(viewModelScope)

    }


    fun onAction(action:HomeScreenAction){
        viewModelScope.launch {
            when(action){
                OnAddTask -> {
                    //TODO: Navigate to AddTaskScreen
                }
                is OnDeleteTask -> {
                    taskLocalDataSource.removeTask(action.task)
                }
                is OnToggleTask -> {
                    val updatedTask = action.task.copy(isCompleted = !action.task.isCompleted)
                    taskLocalDataSource.updateTask(updatedTask)
                }

                OnDeleteAllTasks -> {
                    taskLocalDataSource.removeAllTasks()
                }
            }
        }
    }

}