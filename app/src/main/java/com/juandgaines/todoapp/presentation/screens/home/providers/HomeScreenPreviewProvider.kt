package com.juandgaines.todoapp.presentation.screens.home.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.juandgaines.todoapp.domain.Category
import com.juandgaines.todoapp.domain.Task

class HomeScreenPreviewProvider:PreviewParameterProvider<com.juandgaines.todoapp.presentation.screens.home.HomeDataState> {
    override val values: Sequence<com.juandgaines.todoapp.presentation.screens.home.HomeDataState>
        get() = sequenceOf(
            _root_ide_package_.com.juandgaines.todoapp.presentation.home.HomeDataState(
                date = "March 9, 2024",
                summary = "5 incomplete, 5 completed",
                completedTask = completedTask,
                pendingTask = pendingTask
            )
        )
}

val completedTask = mutableListOf<Task>()
    .apply {
        repeat(20){
            add(
                Task(
                    id = it.toString(),
                    title = "Task $it",
                    description = "Description $it",
                    category = Category.WORDK,
                    isCompleted = false
                )
            )
        }
    }

val pendingTask = mutableListOf<Task>()
    .apply {
        repeat(20){
            add(
                Task(
                    id = (it+30).toString(),
                    title = "Task $it",
                    description = "Description $it",
                    category = Category.OTHER,
                    isCompleted = true
                )
            )
        }
    }