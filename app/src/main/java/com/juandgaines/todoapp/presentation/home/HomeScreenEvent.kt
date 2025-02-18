package com.juandgaines.todoapp.presentation.home

sealed class HomeScreenEvent {
    data object UpdatedTasks:HomeScreenEvent()
    data object DeletedTask:HomeScreenEvent()
    data object AllTaskDeleted:HomeScreenEvent()
}