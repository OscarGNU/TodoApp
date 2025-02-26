package com.juandgaines.todoapp.presentation.screen.detail

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.juandgaines.todoapp.domain.Category

class TaskItemPreviewProvider: PreviewParameterProvider<TaskScreenState> {
    override val values: Sequence<TaskScreenState>
        get() = sequenceOf(

            TaskScreenState(
                taskName  = TextFieldState("Task 1"),
                taskDescription = TextFieldState("Description 1"),
                isTaskDone = false,
                category = Category.WORDK
            ),

            TaskScreenState(
                taskName = TextFieldState("Task 2"),
                taskDescription = TextFieldState("Description 2"),
                isTaskDone = true,
               category = Category.WORDK
            ),

            TaskScreenState(
                taskName = TextFieldState("Task 3"),
                taskDescription = TextFieldState("Description 3"),
                isTaskDone = false,
                category = Category.OTHER
            ),
            TaskScreenState(
                taskName = TextFieldState("Task 4"),
                taskDescription = TextFieldState("Description 4"),
                isTaskDone = true,
                category = Category.OTHER
            ),
        )

}
