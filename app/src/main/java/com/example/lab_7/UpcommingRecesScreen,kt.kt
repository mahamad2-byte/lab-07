package com.example.lab_7



import android.R.attr.onClick
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.foundation.lazy.items


@Composable
fun UpcomingRacesScreen(navController: NavController) {
    var location by remember { mutableStateOf("") }
    val races = remember {
        mutableStateListOf<String>()
    }
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = 50.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)

    ) {
        Button(
            onClick = {
                println("Back button clicked")
                navController.popBackStack()
            },
            modifier = Modifier.testTag("back_button")
        ) {
            Text(text = "Back")
        }



        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Upcoming Races",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextField(
                value = location, onValueChange = { location = it },
                label = { Text(text = "Race Location") },
                modifier = Modifier
                    .weight(1f)
                    .testTag("locationInput")

            )



            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    if (location.isNotEmpty()) {
                        races.add(location)
                        location = ""
                    }
                },
                modifier = Modifier.testTag("add_button")
            ) {

                Text(text = "Add")

            }
        }


            LazyColumn {
                items(races) { race ->
                    Text(text = race)
                }


            }
        }
    }
