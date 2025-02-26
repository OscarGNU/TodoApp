package com.juandgaines.todoapp.presentation.screen.detail

import com.juandgaines.todoapp.domain.Category

sealed class ActionTask{
    data object  SaveTask: ActionTask()
    data object Back: ActionTask()
    data class ChangeTaskCategory(val category: Category?): ActionTask()
    data class ChangeTaskDone (val isTaskDone: Boolean): ActionTask()
}