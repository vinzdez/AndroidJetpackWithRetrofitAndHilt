package com.vince.myapplication.ui.theme.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import com.vince.myapplication.domain.model.roverUiModelList

@Composable
fun RoverList(
    onClick: (roverName: String) -> Unit
){
    Surface (color = MaterialTheme.colorScheme.background , modifier = Modifier.fillMaxSize()){
        LazyColumn {
            items(count = roverUiModelList.size, itemContent = {
                var rover = roverUiModelList[it]
                Rover(rover.name,
                    rover.img,
                    rover.landingDate,
                    rover.distance,
                    onClick
                    )
            })
        }
    }
}

@Composable
fun Rover(name: String,
          id : Int,
          landingDate : String,
          distance : String,
          onClick: (roverName: String) -> Unit) {
    Card(Modifier.padding(16.dp)
        .clickable { onClick(name) }){
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
    Rover("Perseverance" , R.drawable.perseverance , "18 Feb 2-21" , " 12.56 km" ){}
}