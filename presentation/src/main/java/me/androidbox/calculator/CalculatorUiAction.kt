package me.androidbox.calculator

import androidx.compose.runtime.Composable
import me.androidbox.domain.CalculatorAction

data class CalculatorUiAction(
    val text: String,
    val highLightLeve: HighLightLevel,
    val calculatorAction: CalculatorAction,
    val content: @Composable () -> Unit = {}
)

sealed interface HighLightLevel {
    object Neutral: HighLightLevel
    object SemiHighLighted: HighLightLevel
    object HighLighted: HighLightLevel
    object StronglyHighLighted: HighLightLevel
}
