package me.androidbox.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.androidbox.calculator.component.CalculatorButton
import me.androidbox.domain.CalculatorAction

@Composable
fun CalculatorButtonGrid(
    listOfCalculatorUiAction: List<CalculatorUiAction>,
    onAction: (CalculatorAction) -> Unit,
    modifier: Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        userScrollEnabled = false,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
        content = {
            items(listOfCalculatorUiAction) { calculatorUiAction ->
                CalculatorButton(
                    calculatorUiAction = calculatorUiAction,
                    modifier = Modifier.aspectRatio(1F),
                    onClick = {
                        onAction(calculatorUiAction.calculatorAction)
                    })
            }
        })
}