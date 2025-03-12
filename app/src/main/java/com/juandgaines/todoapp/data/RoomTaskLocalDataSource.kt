package com.juandgaines.todoapp.data

import com.juandgaines.todoapp.domain.Task
import com.juandgaines.todoapp.domain.TaskLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class RoomTaskLocalDataSource (
    private val taskDao: TaskDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): TaskLocalDataSource {
    override val tasksFlow: Flow<List<Task>>
        get() = TODO("Not yet implemented")

    override suspend fun addTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun updateTask(updatedTask: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun removeTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllTasks() {
        TODO("Not yet implemented")
    }

    override suspend fun getTaskById(taskId: String): Task? {
        TODO("Not yet implemented")
    }

    override suspend fun removeAllTasks() {
        TODO("Not yet implemented")
    }
}