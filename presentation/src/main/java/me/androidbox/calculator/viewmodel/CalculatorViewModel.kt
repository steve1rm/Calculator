package me.androidbox.calculator.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import me.androidbox.domain.CalculatorAction
import me.androidbox.domain.ExpressionWriter

class CalculatorViewModel(
    private val expressionWriter: ExpressionWriter = ExpressionWriter()
) : ViewModel() {

    var expressionState by mutableStateOf("")
        private set

    fun onAction(calculatorAction: CalculatorAction) {
        expressionWriter.processAction(calculatorAction)
        this.expressionState = expressionWriter.expression
    }
}