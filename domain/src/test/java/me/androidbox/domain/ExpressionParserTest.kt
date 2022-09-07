package me.androidbox.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionParserTest {

    private lateinit var expressionParser: ExpressionParser

    @Test
    fun `should parse simple operation`() {
        // Arrange
        expressionParser = ExpressionParser("3+5-3x4/3")

        // Act
        val listOfExpressionPart = expressionParser.parse()

        // Assert
        val expected = listOf(
            ExpressionPart.Number(3.0),
            ExpressionPart.CalculationOperation(Operation.ADD),
            ExpressionPart.Number(5.0),
            ExpressionPart.CalculationOperation(Operation.SUBTRACT),
            ExpressionPart.Number(3.0),
            ExpressionPart.CalculationOperation(Operation.MULTIPLY),
            ExpressionPart.Number(4.0),
            ExpressionPart.CalculationOperation(Operation.DIVIDE),
            ExpressionPart.Number(3.0)
        )
        assertThat(expected).isEqualTo(listOfExpressionPart)
    }

    @Test
    fun `should parse complex operation`() {
        // Arrange
        expressionParser = ExpressionParser("4-(4x5)")

        // Act
        val listOfExpressionPart = expressionParser.parse()

        // Assert
        val expected = listOf(
            ExpressionPart.Number(4.0),
            ExpressionPart.CalculationOperation(Operation.SUBTRACT),
            ExpressionPart.Parentheses(ParenthesesType.Opening),
            ExpressionPart.Number(4.0),
            ExpressionPart.CalculationOperation(Operation.MULTIPLY),
            ExpressionPart.Number(5.0),
            ExpressionPart.Parentheses(ParenthesesType.Closing)
        )
        assertThat(expected).isEqualTo(listOfExpressionPart)
    }
}