package com.starkindustries.meditationui.Frontend.Compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.starkindustries.meditationui.Data.BottomNavData
import com.starkindustries.meditationui.Data.FeautuesData
import com.starkindustries.meditationui.R
import com.starkindustries.meditationui.Utility.Utility
import com.starkindustries.meditationui.ui.theme.Blue10
import com.starkindustries.meditationui.ui.theme.Blue20
import com.starkindustries.meditationui.ui.theme.Purple40
import kotlin.math.ceil

@Composable
fun GreetingCompose(name:String){
    Row(modifier = Modifier.padding(0.dp,25.dp,0.dp,10.dp)) {
        Column(modifier = Modifier.weight(2f)) {
            Text(text = "Good Morning, $name",
                fontSize = 23.sp,
                color = Color.White,
                fontWeight = FontWeight.W500,
                fontFamily = FontFamily.SansSerif
            )
            Text(text = "We wish you have a good day",
                fontWeight = FontWeight.Light,
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Normal,
                color = Color.White)
        }
        Box(modifier = Modifier.weight(1f),
            contentAlignment = Alignment.CenterEnd){
            Icon(painter = painterResource(id = R.drawable.search), contentDescription = "search",
                modifier = Modifier
                    .size(40.dp)
                    .offset(-10.dp, 0.dp),
                tint = Color.White)
        }
    }

}


@Composable
fun ChipsetCompose(list:List<String>){
    var chipIndex by rememberSaveable {
        mutableStateOf(0)
    }

    LazyRow(modifier = Modifier
        .fillMaxWidth()) {
        items(list.size) {
            Box(modifier = Modifier
                .height(100.dp)
                .width(160.dp)
                .padding(0.dp, 10.dp, 10.dp, 10.dp)
                .clip(RoundedCornerShape(15.dp))
                .clickable {
                    chipIndex = it
                }
                .background(
                    if (chipIndex == it)
                        Blue20
                    else
                        Color.Gray
                ),
                contentAlignment = Alignment.Center
            ){
                Text(text = list.get(it),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W300)
            }
        }
    }

}

@Composable
fun CurrentMeditationCompose(){
    val gradientColors = listOf(
        Color(0xFFEC919F), // Color1
        Color(0xFFE298A0), // Color4
        Color(0xFFE78F9E)
    )
    Box(modifier = Modifier){
        Box(modifier = Modifier
            .height(120.dp)
            .fillMaxSize()
            .padding(top = 10.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Brush.linearGradient(colors = gradientColors))
            .offset(0.dp, 0.dp)){
            Row() {
                Column (modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
                    .weight(2f),
                    verticalArrangement = Arrangement.Center,){
                    Text(text = "Daily Thoughts",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontSize = 27.sp,
                        fontFamily = FontFamily.SansSerif)
                    Text(text = "Meditation . 3-10 min",
                        fontWeight = FontWeight.W400,
                        fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier.padding(top = 10.dp))
                }
                Image(painter = painterResource(id = R.drawable.mx_player_logo), contentDescription = "",
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.CenterVertically)
                        .offset(-10.dp, 0.dp))
            }
        }
    }

}

@Composable
fun FeautureCard(title:String, logo:Int,background:Int){
    Box(modifier = Modifier
        .size(150.dp)
        .padding(5.dp)
        .clip(RoundedCornerShape(15.dp))
    ){
        Image(painter = painterResource(id = background), contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop)
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = title,
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(top = 18.dp, start = 10.dp))
            Row (modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, bottom = 10.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween){
                Image(painter = painterResource(id = logo), contentDescription = "",
                    modifier = Modifier.size(50.dp),
                    colorFilter = ColorFilter.tint(Color.White))

                Button(onClick = { /*TODO*/ },
                    modifier = Modifier.padding(end = 10.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue
                    )
                ) {
                    Text(text = "Start",
                        color = Color.White,
                        fontSize = 16.sp)
                }
            }
        }
    }
}

@Composable
fun FeauturesCompose(){
    LazyVerticalGrid( columns = GridCells.Fixed(2), // Number of columns,
        ) {
        var list = Utility.getFeauturesData()
        items(list.size){
            FeautureCard(title = list.get(it).title, logo = list.get(it).logo, background = list.get(it).background)
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewFunction(){
    val angledBlueGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF0033A0), // Dark Blue
            Color(0xFF3378FF), // Medium Blue
            Color(0xFF99C4FF)  // Light Blue
        ),
        start = Offset(0f, 0f), // Top-left corner
        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY) // Bottom-right corner
    )
    Box(modifier = Modifier
        .background(Blue20)
        .fillMaxSize()
        .background(angledBlueGradient)){
        FeauturesCompose()
    }
}

@Composable
fun BottomNavigationChip(title:String,
                         imageId:Int,
                         isSelected:Boolean,
                         onClick:()->Unit){
        Column (modifier = Modifier
            .size(70.dp)){
            Box(modifier = Modifier
                .padding(top = 10.dp, start = 10.dp)
                .clip(RoundedCornerShape(8.dp))){
                Box(modifier =Modifier.background(
                    if(isSelected)
                        Blue20
                    else
                        Color.Transparent
                ) ){
                    Icon(painter = painterResource(id = imageId), contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(40.dp)
                            .padding(5.dp))
                }
            }
            Text(text = title,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                textAlign = TextAlign.Center,
                fontWeight = if(isSelected)
                    FontWeight.W300
                else
                    FontWeight.Thin,
                fontSize = 13.sp)
        }
}

@Composable
fun BottomNavigationBar(bottomNavFeauturesList:List<BottomNavData>,
                        initialIndex:Int=0){
    var selectedIndex by rememberSaveable {
        mutableStateOf(initialIndex)
    }
    val angledBlueGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF0033A0), // Dark Blue
            Color(0xFF3378FF), // Medium Blue
            Color(0xFF99C4FF)  // Light Blue
        ),
        start = Offset(0f, 0f), // Top-left cornerif(
        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
    )
    val selectedState by rememberSaveable {
        mutableStateOf(0)
    }
    Row(modifier = Modifier.background(Color.Gray)) {
        bottomNavFeauturesList.forEachIndexed{
            index,item->
            BottomNavigationChip(title = item.title, imageId = item.icon, isSelected = index==selectedState,{selectedIndex=index})
        }
    }
    }



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFunctionMark2(){
    BottomNavigationBar(Utility.getBottomNavData())
}
