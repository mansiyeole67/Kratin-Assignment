package com.abhishek.kratinassignment.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek.kratinassignment.ui.theme.RobotoMono
import java.util.concurrent.Flow


@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun TodoScreen() {
    var showDialog by remember {
        mutableStateOf(false)
    }
    val textStyle = TextStyle( fontFamily = RobotoMono, fontWeight = FontWeight.SemiBold )

    val todoList by remember {
        mutableStateOf(initialList)
    }

    var task by remember {
        mutableStateOf("")
    }
    Scaffold(
        floatingActionButton = {
            IconButton(
                onClick = {
                    showDialog = true
                },
                colors = IconButtonDefaults.filledIconButtonColors(),
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))

            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Task",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    ) { it ->
        Box(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
        ) {
            LazyColumn(
                modifier = Modifier.padding(top=16.dp)
            ) {
                item {
                    FlowRow(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Complete your daily task and\nmaintain health",
                            style = textStyle,
                            fontSize = 18.sp,
                            letterSpacing = 1.sp
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(12.dp))
                }
                items(todoList) {task ->
                    TodoItem(todo = task)
                }
            }

            if(showDialog) {
                AlertDialog(
                    onDismissRequest = {
                    },
                    dismissButton = {
                        Button(onClick = {
                            showDialog = false
                        }) {
                            Text(
                                text = "DISCARD",
                                style = textStyle,
                                fontSize = 16.sp
                            )
                        }
                    },
                    confirmButton = {
                        Button(onClick = {
                            showDialog = false
                            todoList.add(task)
                        }) {
                            Text(
                                text = "ADD",
                                style = textStyle,
                                fontSize = 16.sp
                            )
                        }
                    },
                    text = {
                        OutlinedTextField(
                            value = task,
                            onValueChange = { task = it },
                            label = {
                                Text(
                                    text = "Task",
                                    style = textStyle,
                                    fontSize = 16.sp
                                )
                            },
                            placeholder = {
                                Text(
                                    text = "Enter task title",
                                    style = textStyle,
                                    fontSize = 16.sp
                                )
                            },
                            shape = RoundedCornerShape(10),
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    shape = RoundedCornerShape(12),
                    containerColor = AlertDialogDefaults.containerColor,
                    tonalElevation = AlertDialogDefaults.TonalElevation,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@Composable
fun TodoItem(
    todo: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle( fontFamily = RobotoMono, fontWeight = FontWeight.SemiBold )
) {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { isChecked = !isChecked }
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.inverseOnSurface,
                shape = RoundedCornerShape(8.dp)
            )
            .background(MaterialTheme.colorScheme.surface),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            modifier = Modifier.padding(end = 16.dp)
        )
        Text(text = todo, style = textStyle)
    }
}

val initialList = mutableListOf(
    "Walk for 30 minutes",
    "Drink 3 liters of water",
    "Morning sun bath"
)

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    TodoScreen()
}