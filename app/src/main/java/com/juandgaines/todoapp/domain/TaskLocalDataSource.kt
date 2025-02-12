package com.juandgaines.todoapp.domain

interface TaskLocalDataSource {
    fun addTask(task: Task)
    fun updateTask (task: Task)
    fun removeTask (task: Task)
    fun deleAllTask (task: Task)
}