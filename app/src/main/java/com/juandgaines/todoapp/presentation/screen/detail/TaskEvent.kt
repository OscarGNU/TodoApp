package com.juandgaines.todoapp.presentation.screen.detail

sealed class TaskEvent{
    data object TaskCreated : TaskEvent()
}