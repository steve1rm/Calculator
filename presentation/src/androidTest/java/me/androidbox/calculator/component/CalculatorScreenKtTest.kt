package me.androidbox.calculator.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import me.androidbox.calculator.MainActivity
import me.androidbox.calculator.viewmodel.CalculatorViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorScreenKtTest {

    @get:Rule
    val composeRule = createAndroidComposeRule(MainActivity::class.java)
    private lateinit var calculatorViewModel: CalculatorViewModel

    @Before
    fun setUp() {
        calculatorViewModel = CalculatorViewModel()
    }

    @Test
    fun enterExpression_correct_result_displays() {
        // Arrange & Act
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("2").performClick()
        composeRule.onNodeWithText("x").performClick()
        composeRule.onNodeWithText("3").performClick()
        composeRule.onNodeWithText("-").performClick()
        composeRule.onNodeWithText("5").performClick()
        composeRule.onNodeWithText("=").performClick()

        // Assert
        composeRule.onNodeWithText("2.0").assertIsDisplayed()
    }
}