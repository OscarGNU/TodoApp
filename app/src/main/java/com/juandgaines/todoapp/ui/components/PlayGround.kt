package com.juandgaines.todoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juandgaines.todoapp.ui.theme.TodoAppTheme

@Composable
fun HelloWorld(
    modifier: Modifier = Modifier
){
    Text(
        modifier= modifier
            .padding(16.dp)
            .background(
                color= Color.Red
            ),
        text = "Hello World!",
        fontWeight = FontWeight.Bold,
        color =  Color.Blue,

    )
}

@Preview (showBackground = true)
@Composable
fun helloWorldPreview(){
    TodoAppTheme {
        HelloWorld()
    }

}