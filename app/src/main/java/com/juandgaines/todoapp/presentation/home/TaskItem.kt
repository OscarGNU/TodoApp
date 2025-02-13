package com.juandgaines.todoapp.presentation.home

import android.service.autofill.OnClickAction
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.juandgaines.todoapp.domain.Task

@Composable
fun taskItem (
    modifier: Modifier = Modifier,
    onClickItem: (String) -> Unit,
    onDeleteItem: (String) -> Unit,
    onToggleCompletion: (Task) -> Unit,
    task: Task,
){
    Row (
        modifier = modifier
            .clickable {
                onClickItem(task.id)
            }
            .background(
                color = MaterialTheme.colorScheme.surfaceContainer,
            )
            .padding(8.dp)
    ) {
        Checkbox(
            checked = task.isCompleted,
            onCheckedChange = {
                onToggleCompletion(task)
            }
        )

        Column (
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(8.dp)
                .weight(1f)
        ) {
            Text(
                text= task.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleSmall.copy(
                    textDecoration =  if (task.isCompleted) TextDecoration.LineThrough else TextDecoration.None
                ),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            if (!task.isCompleted){
                task.description?.let{
                    Text(
                        text = it,
                        maxLines =2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.inverseOnSurface
                    )
                }
            }

        }

    }

}