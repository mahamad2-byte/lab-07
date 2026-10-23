package com.example.lab_7

import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class DriverScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testDriverScreen() {

        // Open the Drivers screen
        composeTestRule.setContent {
            val navController = rememberNavController()
            DriversScreen(navController)
        }

        // Find the input field and type Mohammed
        composeTestRule.onNodeWithTag("driverNameInput")
            .performTextInput("Mohammed")
        composeTestRule.onNodeWithTag("addDriverButton")
            .performClick()
        composeTestRule.onNodeWithText("Mohammed")
            .assertExists()
        composeTestRule.onNodeWithTag("clearButton")
            .performClick()
        composeTestRule.onNodeWithText("Mohammed")
            .assertDoesNotExist()
    }
    }
