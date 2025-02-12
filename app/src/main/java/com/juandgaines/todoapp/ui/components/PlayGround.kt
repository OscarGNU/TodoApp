package com.juandgaines.todoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juandgaines.todoapp.ui.theme.TodoAppTheme

@Composable
fun HelloWorld(
    modifier: Modifier = Modifier
){
    Text(
        modifier= modifier
            .background(
                color = Color.Red
            )
            .padding(16.dp)
            ,
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

@Composable
fun ClickableTextExample(
    modifier: Modifier = Modifier,
){ var text by remember {
    mutableStateOf("Click me!")
}
    Text(
        text = text,
        fontSize = 16.sp,
        modifier = modifier
            .clickable {
                text= "This is a new text!"
            }
    )
}

@Preview(
    showBackground = true
)
@Composable
fun  ClickableTextExamplePreview(){
    TodoAppTheme {
        ClickableTextExample()
    }
}

@Composable
fun IconExample(
    modifier: Modifier =Modifier
){
    Icon(
        imageVector = Icons.Default.Favorite,
        contentDescription = "Favorite Icon",
        modifier = modifier
            .size(48.dp)
            .border(
                width = 2.dp,
                Color.Gray,
                shape = CircleShape
            )
            .padding(8.dp)
         )

}

@Preview (showBackground = true)
@Composable
fun IconExamplePreview(){
    TodoAppTheme {
        IconExample()
    }
}

@Composable
fun RowView(
    modifier: Modifier = Modifier
){
    Row (modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp))
    {
        HelloWorld()
        IconExample()
    }

}

@Preview (showBackground = true)
@Composable
fun RowViewPreview(){
    TodoAppTheme {
        RowView()
    }
}

@Composable
fun ColumView(
    modifier: Modifier =Modifier
){
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HelloWorld()
        IconExample()
    }

}

@Preview (showBackground = true)
@Composable
fun ColumViewPreview(){
    TodoAppTheme {
        ColumView()
    }
}