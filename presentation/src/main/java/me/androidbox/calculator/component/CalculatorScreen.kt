package me.androidbox.calculator.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import me.androidbox.calculator.CalculatorButtonGrid
import me.androidbox.calculator.CalculatorDisplay
import me.androidbox.calculator.listOfCalculatorAction
import me.androidbox.calculator.viewmodel.CalculatorViewModel

@Composable
fun CalculatorScreen(
     calculatorViewModel: CalculatorViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CalculatorDisplay(
                expression = calculatorViewModel.expressionState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 25.dp,
                            bottomEnd = 25.dp
                        )
                    )
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .padding(
                        vertical = 64.dp,
                        horizontal = 16.dp
                    )
            )
            Spacer(modifier = Modifier.height(8.dp))

            CalculatorButtonGrid(
                listOfCalculatorUiAction = listOfCalculatorAction,
                onAction = { calculatorAction ->
                    calculatorViewModel.onAction(calculatorAction)
                },
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}