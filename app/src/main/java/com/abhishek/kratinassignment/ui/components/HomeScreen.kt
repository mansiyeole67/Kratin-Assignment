package com.abhishek.kratinassignment.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek.kratinassignment.ui.theme.RobotoMono

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun HomeScreen() {
    var query by remember {
        mutableStateOf("")
    }

    val textStyle = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.SemiBold
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 12.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = {
                query = it
            },
            label = {
                Text(
                    text = "Ask me anything",
                    style = textStyle,
                    fontSize = 18.sp
                )
            },
            placeholder = {
                Text(
                    text = "Type your question here",
                    fontSize = 18.sp
                )
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            maxLines = 5
        )
        Button(onClick = {
        }) {
            Text(
                text = "Submit",
                style = textStyle,
                fontSize = 16.sp
            )
        }
        Text(
            text = "Answer : ",
            style = textStyle,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
        )
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    shape = RoundedCornerShape(15),
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary
                )
                .padding(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Response",
                style = textStyle,
                fontSize = 16.sp,
                letterSpacing = 2.sp
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun DefaultHomeScreen() {
    HomeScreen()
}
