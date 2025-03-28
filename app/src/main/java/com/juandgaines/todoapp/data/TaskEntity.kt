package com.juandgaines.todoapp.data

import android.icu.text.CaseMap.Title
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.juandgaines.todoapp.domain.Task
import java.lang.invoke.TypeDescriptor
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@Entity(tableName = "task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val title: String,
    val description: String?,
    @ColumnInfo (name = "is_completed")
    val isCompleted: Boolean,
    val date: Long
){
    fun toTask(): Task{
        return Task(
            id= id,
            title = title,
            description = description,
            isCompleted = isCompleted,
            date = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(date),
                ZoneId.systemDefault()
            )
        )
    }
    companion object{
        fun fromTask(task: Task): TaskEntity{
            return TaskEntity(
                id= task.id,
                title = task.title,
                description = task.description,
                isCompleted = task.isCompleted,
                date = task.date
                    .atZone(
                        ZoneId.systemDefault()
                    ).toInstant()
                    .toEpochMilli()
            )
        }
    }
}