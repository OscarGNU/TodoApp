package com.juandgaines.todoapp.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juandgaines.todoapp.data.FakeTaskLocalDataSource
import com.juandgaines.todoapp.presentation.home.HomeScreenAction.OnDeleteAllTasks
import com.juandgaines.todoapp.presentation.home.HomeScreenAction.OnDeleteTask
import com.juandgaines.todoapp.presentation.home.HomeScreenAction.OnToggleTask
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HomeScreenViewModel:ViewModel() {
    private val taskLocalDataSource = FakeTaskLocalDataSource

    var state by   mutableStateOf(HomeDataState())
        private set
    private val eventChannel = Channel<HomeScreenEvent> ()
    val events = eventChannel.receiveAsFlow()

    init {
        state = state.copy(
            date = LocalDate.now().let {
                DateTimeFormatter.ofPattern("EEEE, MMMM, dd, yyyy").format(it)
            }
        )
        taskLocalDataSource.tasksFlow.onEach {
            val completedTask = it
                .filter { task -> task.isCompleted  }
                .sortedByDescending { task->
                    task.date
                }
            val pendingTask = it
                .filter { task -> !task.isCompleted  }
                .sortedByDescending {task->
                    task.date
                }


            state = state.copy(

                summary = pendingTask.size.toString(),
                completedTask = completedTask,
                pendingTask = pendingTask,
            )
        }.launchIn(viewModelScope)
    }
    fun onAction(action:HomeScreenAction){
        viewModelScope.launch {
            when(action){

                is OnDeleteTask -> {
                    taskLocalDataSource.removeTask(action.task)
                    eventChannel.send(HomeScreenEvent.DeletedTask)
                }
                is OnToggleTask -> {
                    val updatedTask = action.task.copy(isCompleted = !action.task.isCompleted)
                    taskLocalDataSource.updateTask(updatedTask)
                    eventChannel.send(HomeScreenEvent.UpdatedTask)
                }

                OnDeleteAllTasks -> {
                    taskLocalDataSource.removeAllTasks()
                    eventChannel.send(HomeScreenEvent.UpdatedTask)
                }

                else-> Unit
            }
        }
    }

}