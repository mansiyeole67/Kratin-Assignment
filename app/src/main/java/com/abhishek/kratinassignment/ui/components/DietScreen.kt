package com.abhishek.kratinassignment.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abhishek.kratinassignment.ui.theme.RobotoMono

@Composable
fun DietScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Follow the diet plan given below!!",
            style = TextStyle(
                fontFamily = RobotoMono,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                letterSpacing = 1.sp
            )

        )
        LazyColumn {
            items(weekDietPlan) { item ->
                DietItem(
                    item = item
                )
            }
        }
    }
}

@Composable
fun DietItem(
    item: DietItem,
    modifier: Modifier = Modifier
) {
    val textStyle = TextStyle(
        fontFamily = RobotoMono,
    )
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Day ${item.day}",
                style = textStyle,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Divider()
            CustomizeText(
                category = "Breakfast",
                content = item.breakfast
            )
            CustomizeText(
                category = "Lunch",
                content = item.lunch
            )
            CustomizeText(
                category = "Dinner",
                content = item.dinner
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Daily Intake",
                style = textStyle,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Divider()
            LazyVerticalGrid(
                modifier = Modifier.height(60.dp),
                columns = GridCells.Fixed(2)
            ) {
                items(item.totalIntake.toList()) { (key, value) ->
                    Row(
                        modifier = Modifier
                            .padding()
                            .padding(end = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = key,
                            style = textStyle,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = value.toString(),
                            style = textStyle
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CustomizeText(
    category: String,
    content: String
) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp
            )) {
                append("$category :  ")
            }
            withStyle(style = SpanStyle(
                fontSize = 16.sp
            )
            ) {
                append(content)
            }
        }
    )
}
data class DietItem(
    val day:String,
    val breakfast: String,
    val lunch: String,
    val dinner: String,
    val totalIntake: Map<String,Int>
)

val weekDietPlan = listOf(
    DietItem(
        day = "1",
        breakfast = "Spinach Omelet",
        lunch = "Green Goddess White Bean Salad",
        dinner = "Creamy Tomato Salmon Skillet",
        totalIntake = mapOf(
            "Calories" to 1511,
            "Fat" to 78,
            "Protein" to 87,
            "Carbohydrate" to 116,
            "fiber" to 30
        )
    ),
    DietItem(
        day = "2",
        breakfast = "Blueberry and Spinach Smoothie",
        lunch = "Sweet Potato, Kale and Chicken Salad with Peanut Dressing",
        dinner = "Chicken & Vegetable Penne with Parsley-Walnut Pesto",
        totalIntake = mapOf(
            "Calories" to 1477,
            "Fat" to 49,
            "Protein" to 86,
            "Carbohydrate" to 183,
            "fiber" to 33
        )
    ),
    DietItem(
        day = "3",
        breakfast = "Low-fat plain yogurt and chopped walnuts",
        lunch = "Green Goddess White Bean Salad",
        dinner = "Vegan Lentil Stew",
        totalIntake = mapOf(
            "Calories" to 1495,
            "Fat" to 56,
            "Protein" to 84,
            "Carbohydrate" to 179,
            "fiber" to 31
        )
    ),
    DietItem(
        day = "4",
        breakfast = "Blueberry and Spinach Smoothie",
        lunch = "Sweet Potato, Kale & Chicken Salad with Peanut Dressing",
        dinner = "Vegetarian Chopped Power Salad with Creamy Cilantro Dressing",
        totalIntake = mapOf(
            "Calories" to 1485,
            "Fat" to 40,
            "Protein" to 69,
            "Carbohydrate" to 219,
            "fiber" to 34
        )
    ),
    DietItem(
        day = "5",
        breakfast = "Low-fat plain yogurt and chopped walnuts",
        lunch = "Guacamole Chopped Salad",
        dinner = "Creamy Tomato Salmon Skillet",
        totalIntake = mapOf(
            "Calories" to 1487,
            "Fat" to 78,
            "Protein" to 91,
            "Carbohydrate" to 119,
            "fiber" to 30
        )
    ),
    DietItem(
        day = "6",
        breakfast = "Spinach Omelet",
        lunch = "Chicken & Kale Soup",
        dinner = "Baked Halibut with Brussels Sprouts & Quinoa",
        totalIntake = mapOf(
            "Calories" to 1477,
            "Fat" to 48,
            "Protein" to 75,
            "Carbohydrate" to 202,
            "fiber" to 41
        )
    ),
    DietItem(
        day = "7",
        breakfast = "Blueberry and Spinach Smoothie",
        lunch = " Chicken & Kale Soup",
        dinner = "Green Shakshuka with Spinach, Chard & Feta",
        totalIntake = mapOf(
            "Calories" to 1506,
            "Fat" to 79,
            "Protein" to 79,
            "Carbohydrate" to 127,
            "fiber" to 30
        )
    )
)

@Preview(showSystemUi = true)
@Composable
fun DietScreenPreview() {
    DietScreen()
}