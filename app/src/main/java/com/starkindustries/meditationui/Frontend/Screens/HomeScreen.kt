package com.starkindustries.meditationui.Frontend.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.starkindustries.meditationui.Frontend.Activity.Greeting
import com.starkindustries.meditationui.Frontend.Compose.ChipsetCompose
import com.starkindustries.meditationui.Frontend.Compose.CurrentMeditationCompose
import com.starkindustries.meditationui.Frontend.Compose.FeautureCard
import com.starkindustries.meditationui.Frontend.Compose.FeauturesCompose
import com.starkindustries.meditationui.Frontend.Compose.GreetingCompose
import com.starkindustries.meditationui.Utility.Utility
import com.starkindustries.meditationui.ui.theme.Blue20

@Composable
fun HomeScreen(){
    val angledBlueGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF0033A0), // Dark Blue
            Color(0xFF3378FF), // Medium Blue
            Color(0xFF99C4FF)  // Light Blue
        ),
        start = Offset(0f, 0f), // Top-left corner
        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
    )
    Box(modifier = Modifier
        .background(Blue20)
        .fillMaxSize()
        .background(angledBlueGradient)){
        var list:List<String> = listOf("Sweet","Sleep","Insomnia","Depression")
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
            GreetingCompose("Aditya")
            ChipsetCompose(list)
            CurrentMeditationCompose()
            Text(text = "Featured",
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.padding(top=30.dp, bottom = 10.dp),
                fontWeight = FontWeight.Bold
            )
            FeauturesCompose()
        }
    }}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewFunction(){
    HomeScreen()
}