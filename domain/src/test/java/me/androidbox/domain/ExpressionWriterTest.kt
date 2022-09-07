package me.androidbox.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionWriterTest {

    private lateinit var expressionWriter: ExpressionWriter

    @Test
    fun `initial parentheses parsed`() {
        // Arrange
        expressionWriter = ExpressionWriter()
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Number(5))
        expressionWriter.processAction(CalculatorAction.Operations(Operation.ADD))
        expressionWriter.processAction(CalculatorAction.Number(4))
        expressionWriter.processAction(CalculatorAction.Parentheses)

        // Act & Assert
        assertThat(expressionWriter.expression).isEqualTo("(5+4)")
    }

    @Test
    fun `closing parentheses at the start are not parsed`() {
        // Arrange
        expressionWriter = ExpressionWriter()
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Parentheses)

        // Act & Assert
        assertThat(expressionWriter.expression).isEqualTo("((")
    }

    @Test
    fun `parentheses around a number are parsed`() {
        // Arrange
        expressionWriter = ExpressionWriter()
        expressionWriter.processAction(CalculatorAction.Parentheses)
        expressionWriter.processAction(CalculatorAction.Number(6))
        expressionWriter.processAction(CalculatorAction.Parentheses)

        // Act & Assert
        assertThat(expressionWriter.expression).isEqualTo("(6)")
    }

}
