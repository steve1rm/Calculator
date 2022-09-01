package me.androidbox.domain

/**
 * Uses the following grammer
 * expression : term | term + term | term - term
 * term       : factor | factor * factor | factor / factor | % factor
 * factor     : number | (expression) | + factor | = factor
 */
class ExpressionEvaluator(
    private val expression: List<ExpressionPart>
) {

    fun evaluate(): Double {
        return evalExpression(expression).value
    }

    private fun evalExpression(expression: List<ExpressionPart>): ExpressionResult {
        val result = evalTerm(expression)
        var remaining = result.listOfRemainingExpressionPart
        var sum = result.value

        while (true) {
            when (remaining.firstOrNull()) {
                ExpressionPart.CalculationOperation(Operation.ADD) -> {
                    val term = evalTerm(remaining.drop(1))
                    sum += term.value
                    remaining = term.listOfRemainingExpressionPart
                }
                ExpressionPart.CalculationOperation(Operation.SUBTRACT) -> {
                    val term = evalTerm(remaining.drop(1))
                    sum -= term.value
                    remaining = term.listOfRemainingExpressionPart
                }
                else -> return ExpressionResult(remaining, sum)
            }
        }
    }

    private fun evalTerm(expression: List<ExpressionPart>): ExpressionResult {
        val result = evalFactor(expression)
        var remaining = result.listOfRemainingExpressionPart
        var sum = result.value

        while (true) {
            when (remaining.firstOrNull()) {
                ExpressionPart.CalculationOperation(Operation.MULTIPLY) -> {
                    val factor = evalFactor(remaining.drop(1))
                    sum *= factor.value
                    remaining = factor.listOfRemainingExpressionPart
                }
                ExpressionPart.CalculationOperation(Operation.DIVIDE) -> {
                    val factor = evalFactor(remaining.drop(1))
                    sum /= factor.value
                    remaining = factor.listOfRemainingExpressionPart
                }
                ExpressionPart.CalculationOperation(Operation.PERCENT) -> {
                    val factor = evalFactor(remaining.drop(1))
                    sum *= (factor.value / 100.0)
                    remaining = factor.listOfRemainingExpressionPart
                }
                else -> return ExpressionResult(remaining, sum)
            }
        }
    }

    private fun evalFactor(expression: List<ExpressionPart>): ExpressionResult {
        return when(val part = expression.firstOrNull()) {
            ExpressionPart.CalculationOperation(Operation.ADD) -> {
                evalFactor(expression.drop(1))
            }
            ExpressionPart.CalculationOperation(Operation.SUBTRACT) -> {
                evalFactor(expression.drop(1)).run {
                    ExpressionResult(listOfRemainingExpressionPart, -value)
                }
            }
            ExpressionPart.Parentheses(ParenthesesType.Opening) -> {
                evalExpression(expression.drop(1)).run {
                    ExpressionResult(listOfRemainingExpressionPart.drop(1), value)
                }
            }
            ExpressionPart.CalculationOperation(Operation.PERCENT) -> {
                evalTerm(expression.drop(1))
            }
            is ExpressionPart.Number -> ExpressionResult(
                expression.drop(1), part.number
            )
            else -> throw IllegalMonitorStateException("Invalid expression")
        }
    }

    data class ExpressionResult(
        val listOfRemainingExpressionPart: List<ExpressionPart>,
        val value: Double
    )
}
