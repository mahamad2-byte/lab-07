package com.example.lab_7


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun DriversScreen(navController: NavController) {
    val drivers = remember {
        mutableStateListOf<String>()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    navController.popBackStack()

                },
                modifier = Modifier.testTag("back_button")
            ) {
                Text(text = "Back")

            }
            Button(
                onClick = {
                    drivers.clear()
                },
                modifier = Modifier.testTag("clearButton")
            ) {
                Text("Clear")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Formula Zero Drivers")

        var driverName by remember {
            mutableStateOf("")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = driverName,
                onValueChange = { driverName = it },
                label = { Text("driverName") },
                modifier = Modifier.weight(1f)
                    .testTag("driverNameInput")

            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    if (driverName.isNotBlank()) {
                        drivers.add(driverName)
                        driverName = ""
                    }
                },
                modifier = Modifier.testTag("addDriverButton")
            ) {
                Text("Add")
            }
        }
        LazyColumn {
            items(drivers) { driver ->
                Text(
                    text = driver,
                    fontSize = 24.sp
                )
            }
        }
    }
}







