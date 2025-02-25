package com.juandgaines.todoapp.presentation.screen.detail

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.juandgaines.todoapp.domain.Category

class TaskItemPreviewProvider: PreviewParameterProvider<TaskScreenState> {
    override val values: Sequence<TaskScreenState>
        get() = sequenceOf(

            TaskScreenState(
                taskName  = "Task 1",
                taskDescription = "Description 1",
                isTaskDone = false,
                category = Category.WORDK
            ),

            TaskScreenState(
                taskName = "Task 2",
                taskDescription = "Description 2",
                isTaskDone = true,
               category = Category.WORDK
            ),

            TaskScreenState(
                taskName = "Task 3",
                taskDescription = "Description 3",
                isTaskDone = false,
                category = Category.OTHER
            ),
            TaskScreenState(
                taskName = "Task 4",
                taskDescription = "Description 4",
                isTaskDone = true,
                category = Category.OTHER
            ),
        )

}
