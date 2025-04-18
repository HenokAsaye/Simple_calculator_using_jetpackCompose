package com.example.simple_calculator_app_using_jetpack_compose

data class CalculatorState(
    val Number1:String = "",
    val Number2:String = "",
    val operation: calculatorOperation ?= null
){

}

