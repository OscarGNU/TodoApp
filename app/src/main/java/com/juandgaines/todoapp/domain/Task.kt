package com.juandgaines.todoapp.domain

data class Task (
    val tasks: MutableList<Task> = mutableListOf(),
    val id: String,
    val title: String,
    val description: String?,
    val isCompleted: Boolean = false,
    val category: Category? = null,

)
