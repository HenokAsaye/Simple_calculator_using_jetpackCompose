package com.plcoding.composecalculator

import com.example.simple_calculator_app_using_jetpack_compose.calculatorOperation


sealed class CalculatorActions{
    data class Number(val number: Int) : CalculatorActions()
    object Clear:CalculatorActions()
    object Delete: CalculatorActions()
    object Decimal:CalculatorActions()
    object Calculate:CalculatorActions()
    data class Operation(val operation:calculatorOperation) : CalculatorActions()
}

