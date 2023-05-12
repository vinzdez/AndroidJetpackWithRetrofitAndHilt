package com.vince.myapplication.ui.theme.view

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vince.myapplication.R
import com.vince.myapplication.domain.model.RoverManifestUiModel
import com.vince.myapplication.domain.model.roverUiModelList


@Composable
fun ManifestList(
    roverManifestUiModel: List<RoverManifestUiModel>,
    roverName : String,
    onClick: (roverName: String , sol: String) -> Unit
){
    Surface(color = MaterialTheme.colorScheme.background , modifier = Modifier.fillMaxSize()) {
        LazyColumn{
            items( count = roverManifestUiModel.size , itemContent = {
                    Manifest(roverManifestUiModel = roverManifestUiModel[it] , roverName , onClick)
            })
        }
    }
}

@Composable
fun Manifest(
    roverManifestUiModel: RoverManifestUiModel,
    roverName : String,
    onClick: (roverName: String , sol: String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable {
                onClick(roverName, roverManifestUiModel.sol)
            }) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = stringResource(id = R.string.sol , roverManifestUiModel.sol))
            Text(text = stringResource(id = R.string.earth_date , roverManifestUiModel.earthDate))
            Text(text = stringResource(id = R.string.number_of_photo ,roverManifestUiModel.photoNumber))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ManifestPreview(){
    Manifest(roverManifestUiModel = RoverManifestUiModel("4","2022=03-05","34"),"") { _, _ -> }
}