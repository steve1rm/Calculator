package me.androidbox.domain

import java.lang.IllegalArgumentException

enum class Operation(val symbol: Char) {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('x'),
    DIVIDE('/'),
    PERCENT('%')
}

val operationSymbols = Operation.values().map { operation ->
    operation.symbol
}.joinToString("")

fun operationFromSymbol(symbol: Char): Operation {
    return Operation.values().firstOrNull { operation ->
        operation.symbol == symbol
    } ?: throw IllegalArgumentException("This symbol [ $symbol ] does not exist")
}
