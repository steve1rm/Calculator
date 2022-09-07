package me.androidbox.calculator

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import me.androidbox.domain.CalculatorAction
import me.androidbox.domain.Operation

val listOfCalculatorAction = listOf(
    CalculatorUiAction(
        text = "AC",
        highLightLevel = HighLightLevel.HighLighted,
        calculatorAction = CalculatorAction.Clear
    ),
    CalculatorUiAction(
        text = "()",
        highLightLevel = HighLightLevel.SemiHighLighted,
        calculatorAction = CalculatorAction.Parentheses
    ),
    CalculatorUiAction(
        text = "%",
        highLightLevel = HighLightLevel.SemiHighLighted,
        calculatorAction = CalculatorAction.Operations(Operation.PERCENT)
    ),
    CalculatorUiAction(
        text = "÷",
        highLightLevel = HighLightLevel.SemiHighLighted,
        calculatorAction = CalculatorAction.Operations(Operation.DIVIDE)
    ),
    CalculatorUiAction(
        text = "7",
        highLightLevel = HighLightLevel.Neutral,
        calculatorAction = CalculatorAction.Number(7)
    ),
    CalculatorUiAction(
        text = "8",
        highLightLevel = HighLightLevel.Neutral,
        calculatorAction = CalculatorAction.Number(8)
    ),
    CalculatorUiAction(
        text = "9",
        highLightLevel = HighLightLevel.Neutral,
        calculatorAction = CalculatorAction.Number(9)
    ),
    CalculatorUiAction(
        text = "x",
        highLightLevel = HighLightLevel.SemiHighLighted,
        calculatorAction = CalculatorAction.Operations(Operation.MULTIPLY)
    ),
    CalculatorUiAction(
        text = "4",
        highLightLevel = HighLightLevel.Neutral,
        calculatorAction = CalculatorAction.Number(4)
    ),
    CalculatorUiAction(
        text = "5",
        highLightLevel = HighLightLevel.Neutral,
        calculatorAction = CalculatorAction.Number(5)
    ),
    CalculatorUiAction(
        text = "6",
        highLightLevel = HighLightLevel.Neutral,
        calculatorAction = CalculatorAction.Number(6)
    ),
    CalculatorUiAction(
        text = "-",
        highLightLevel = HighLightLevel.SemiHighLighted,
        calculatorAction = CalculatorAction.Operations(Operation.SUBTRACT)
    ),
    CalculatorUiAction(
        text = "1",
        highLightLevel = HighLightLevel.Neutral,
        calculatorAction = CalculatorAction.Number(1)
    ),
    CalculatorUiAction(
        text = "2",
        highLightLevel = HighLightLevel.Neutral,
        calculatorAction = CalculatorAction.Number(2)
    ),
    CalculatorUiAction(
        text = "3",
        highLightLevel = HighLightLevel.Neutral,
        calculatorAction = CalculatorAction.Number(3)
    ),
    CalculatorUiAction(
        text = "+",
        highLightLevel = HighLightLevel.SemiHighLighted,
        calculatorAction = CalculatorAction.Operations(Operation.ADD)
    ),
    CalculatorUiAction(
        text = "0",
        highLightLevel = HighLightLevel.Neutral,
        calculatorAction = CalculatorAction.Number(0)
    ),
    CalculatorUiAction(
        text = ".",
        highLightLevel = HighLightLevel.Neutral,
        calculatorAction = CalculatorAction.Decimal
    ),
    CalculatorUiAction(
        text = null,
        content = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        highLightLevel = HighLightLevel.Neutral,
        calculatorAction = CalculatorAction.Delete
    ),
    CalculatorUiAction(
        text = "=",
        highLightLevel = HighLightLevel.StronglyHighLighted,
        calculatorAction = CalculatorAction.Calculate
    ),
)