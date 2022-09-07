package me.androidbox.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionEvaluatorTest {

    private lateinit var expressionEvaluator: ExpressionEvaluator

    @Test
    fun `simple evaluate expression properly`() {
        // Arrange
        expressionEvaluator = ExpressionEvaluator(listOf(
            ExpressionPart.Number(4.0),
            ExpressionPart.CalculationOperation(Operation.ADD),
            ExpressionPart.Number(5.0),
            ExpressionPart.CalculationOperation(Operation.SUBTRACT),
            ExpressionPart.Number(3.0),
            ExpressionPart.CalculationOperation(Operation.MULTIPLY),
            ExpressionPart.Number(5.0),
            ExpressionPart.CalculationOperation(Operation.DIVIDE),
            ExpressionPart.Number(3.0)
        ))

        // Act & Assert
        assertThat(expressionEvaluator.evaluate()).isEqualTo(4.0)
    }

    @Test
    fun `simple decimals evaluate expression properly`() {
        // Arrange
        expressionEvaluator = ExpressionEvaluator(listOf(
            ExpressionPart.Number(4.5),
            ExpressionPart.CalculationOperation(Operation.ADD),
            ExpressionPart.Number(5.5),
            ExpressionPart.CalculationOperation(Operation.SUBTRACT),
            ExpressionPart.Number(3.5),
            ExpressionPart.CalculationOperation(Operation.MULTIPLY),
            ExpressionPart.Number(5.5),
            ExpressionPart.CalculationOperation(Operation.DIVIDE),
            ExpressionPart.Number(3.5)
        ))

        // Act & Assert
        assertThat(expressionEvaluator.evaluate()).isEqualTo(4.5)
    }

    @Test
    fun `simple evaluate expression properly with parentheses`() {
        // Arrange
        expressionEvaluator = ExpressionEvaluator(listOf(
            ExpressionPart.Number(4.0),
            ExpressionPart.CalculationOperation(Operation.ADD),
            ExpressionPart.Parentheses(ParenthesesType.Opening),
            ExpressionPart.Number(5.0),
            ExpressionPart.CalculationOperation(Operation.SUBTRACT),
            ExpressionPart.Number(3.0),
            ExpressionPart.Parentheses(ParenthesesType.Closing),
            ExpressionPart.CalculationOperation(Operation.MULTIPLY),
            ExpressionPart.Number(5.0),
            ExpressionPart.CalculationOperation(Operation.DIVIDE),
            ExpressionPart.Number(4.0)
        ))

        // Act & Assert
        assertThat(expressionEvaluator.evaluate()).isEqualTo(6.5)
    }
}