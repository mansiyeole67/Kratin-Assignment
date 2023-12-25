package com.abhishek.kratinassignment.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek.kratinassignment.R
import com.abhishek.kratinassignment.ui.theme.RobotoMono

@Composable
fun MeditationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        GreetingSection()
        ChipSection(chips = listOf("Sweet Sleep","Insomnia","Anxiety","Stress","Depression"))
        CurrentMediation()
        Text(
            text = "Feature",
            style = textStyle,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        FeaturedSection(features = feature)
    }
}

@Composable
fun GreetingSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = "Good Morning",
            style = textStyle,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "We wish you have a good day !!",
            style = textStyle,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun ChipSection(
    chips : List<String>
){
    var selectedChipIndex by remember{
        mutableIntStateOf(0)
    }
    LazyRow {
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(top = 16.dp, end = 8.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        color = if (selectedChipIndex == it) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer
                    )
                    .padding(16.dp)
            ){
                Text(
                    text = chips[it],
                    style = textStyle,
                    fontWeight = FontWeight.SemiBold,
                    color = if(selectedChipIndex == it) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@Composable
fun CurrentMediation() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ){
        Column {
            Text(
                text = "Daily Thought",
                style = textStyle,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Mediation 3-10 minutes",
                style = textStyle,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .padding(10.dp)
        ){
            Icon(
                imageVector = Icons.Rounded.PlayArrow,
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
fun FeaturedSection(
    features : List<String>
){
    Column(modifier = Modifier.fillMaxWidth()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp , end = 7.5.dp , bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features) {
                FeatureItem(feature = it)
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature : String
){
    Card(
        modifier = Modifier.padding(7.5.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            hoveredElevation = 16.dp
        )
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .clip(RoundedCornerShape(12.dp))
                .aspectRatio(1f)
        ){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ){
                Text(
                    text = feature,
                    style = textStyle,
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    modifier = Modifier.align(Alignment.TopStart),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "Start",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .clickable {

                        }
                        .clip(RoundedCornerShape(10.dp))
                        .align(Alignment.BottomEnd)
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
        }
    }
}


private val feature = listOf(
    "Start Mediation",
    "Tips for sleeping",
    "Night Island",
    "Lo-fi Sound",
    "Yoga Tutorials",
    "Podcast"
)

private val textStyle = TextStyle(
    fontFamily = RobotoMono
)
@Preview(showSystemUi = true)
@Composable
fun MeditationScreenPreview() {
    MeditationScreen()
}