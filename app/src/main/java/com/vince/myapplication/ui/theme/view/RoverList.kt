package com.vince.myapplication.ui.theme.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vince.myapplication.R

@Composable
fun Rover(name: String , id : Int , landingDate : String
          , distance : String) {
    Card(Modifier.padding(16.dp)){
        Column(Modifier.padding(16.dp)) {
            Text(modifier = Modifier.fillMaxWidth(),
                text = name ,
                fontWeight = FontWeight.Bold ,
                fontSize = 24.sp,
                textAlign = TextAlign.Center)
            Image(painter = painterResource(id = id), contentDescription = null)
            Text(text = "Credeit: Nasa/JPM" , fontSize = 8.sp)
            Text(text = "Landing date: $landingDate" , fontSize = 12.sp)
            Text(text = "Distance Travel: $distance" , fontSize = 12.sp)
        }
        
    }
}

@Preview
@Composable
fun RoverPreview() {
    Rover("Perseverance" , R.drawable.perseverance , "18 Feb 2-21" , " 12.56 km" )
}