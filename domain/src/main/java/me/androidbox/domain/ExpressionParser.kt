package me.androidbox.domain

class ExpressionParser(private val calculation: String) {

    fun parse(): List<ExpressionPart> {
        val result = mutableListOf<ExpressionPart>()
        var index = 0

        while (index < calculation.length) {
            val currentChar = calculation[index]
            when {
                currentChar in operationSymbols -> {
                    result.add(
                        ExpressionPart.CalculationOperation(operationFromSymbol(currentChar))
                    )
                }
                currentChar.isDigit() -> {
                    index = parseNumber(index, result)
                    continue
                }
                currentChar in "()" -> {
                    parseParentheses(currentChar, result)
                }
            }

            index++
        }

        return result
    }

    private fun parseNumber(startIndex: Int, result: MutableList<ExpressionPart>): Int {
        var index = startIndex
        val numberAsString = buildString {
            while (index < calculation.length && calculation[index] in "0123456789.") {
                append(calculation[index])
                index++
            }
        }

        result.add(ExpressionPart.Number(numberAsString.toDouble()))

        return index
    }

    private fun parseParentheses(currentChar: Char, result: MutableList<ExpressionPart>) {
        result.add(
            ExpressionPart.Parentheses(
                type = when(currentChar) {
                    '(' -> ParenthesesType.Opening
                    ')' -> ParenthesesType.Closing
                    else -> throw IllegalArgumentException("Invalid character [$currentChar]")
                }
            )
        )
    }
}