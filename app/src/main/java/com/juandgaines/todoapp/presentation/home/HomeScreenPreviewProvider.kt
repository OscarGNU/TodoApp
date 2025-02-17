package com.juandgaines.todoapp.presentation.home

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.juandgaines.todoapp.domain.Category
import com.juandgaines.todoapp.domain.Task

class HomeScreenPreviewProvider: PreviewParameterProvider<HomeDataState> {
    override val values: Sequence<HomeDataState>
        get() {
            return sequenceOf(
                HomeDataState(
                    date = "Febrero 17, 2025",
                    summary = "5 incomplete, 5 completed",
                    completedTask = completedTask,
                    pendingTask = pendingTask
                )
            )
        }
    val completedTask = mutableListOf<Task>()
        .apply {
            repeat(20){
                add(Task(
                        id = it.toString(),
                        title =  "Task $it",
                        description = "Description $it",
                        category = Category.WORDK,
                        isCompleted = false
                        )
                )
            }
        }
    val pendingTask = mutableListOf<Task>()
        .apply {
            repeat (20){
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

}