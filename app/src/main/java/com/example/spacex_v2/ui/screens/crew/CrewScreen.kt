package com.example.spacex_v2.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.spacex_v2.data.CrewModel
import com.example.spacex_v2.ui.baseElements.VerticalSpacer
import com.example.spacex_v2.viewmodels.MainViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CrewScreen(vm: MainViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        LazyVerticalGrid(
            cells = GridCells.Adaptive(150.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            items(vm.crew.value) {
                CrewCard(astrounaut = it)
            }
        }
    }
}

@Composable
fun CrewCard(astrounaut: CrewModel.CrewModelItem) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1 / 1f)
                    .clip(RoundedCornerShape(32.dp))
                    .border(BorderStroke(1.dp, color = Color.Black),
                        RoundedCornerShape(32.dp)),
                model = astrounaut.image,
                contentDescription = "Astronaut Image",
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
        }
        VerticalSpacer(size = 8)
        Text(
            text = astrounaut.name,
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center
        )
        Text(
            text = astrounaut.agency,
            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center
        )
//        VerticalSpacer(16)
    }
}