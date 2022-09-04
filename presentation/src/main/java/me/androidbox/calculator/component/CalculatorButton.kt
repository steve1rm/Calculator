package me.androidbox.calculator.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import me.androidbox.calculator.CalculatorUiAction
import me.androidbox.calculator.HighLightLevel
import me.androidbox.domain.CalculatorAction

@Composable
fun CalculatorButton(
    calculatorUiAction: CalculatorUiAction,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(
                when (calculatorUiAction.highLightLevel) {
                    HighLightLevel.HighLighted -> MaterialTheme.colorScheme.tertiary
                    HighLightLevel.Neutral -> MaterialTheme.colorScheme.surfaceVariant
                    HighLightLevel.SemiHighLighted -> MaterialTheme.colorScheme.inverseSurface
                    HighLightLevel.StronglyHighLighted -> MaterialTheme.colorScheme.primary
                }
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center) {

        if(calculatorUiAction.text != null) {
            Text(
                text = calculatorUiAction.text,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                color = when(calculatorUiAction.highLightLevel) {
                    is HighLightLevel.Neutral -> MaterialTheme.colorScheme.inverseOnSurface
                    is HighLightLevel.SemiHighLighted -> MaterialTheme.colorScheme.tertiary
                    is HighLightLevel.HighLighted -> MaterialTheme.colorScheme.onSurfaceVariant
                    is HighLightLevel.StronglyHighLighted -> MaterialTheme.colorScheme.onPrimary
                })
        }
        else {
            calculatorUiAction.content()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewCalculatorButton() {
    CalculatorButton(
        calculatorUiAction = CalculatorUiAction(
            "6",
            highLightLevel = HighLightLevel.HighLighted,
            calculatorAction = CalculatorAction.Calculate
        ),
        modifier = Modifier,
        onClick = {}
    )
}