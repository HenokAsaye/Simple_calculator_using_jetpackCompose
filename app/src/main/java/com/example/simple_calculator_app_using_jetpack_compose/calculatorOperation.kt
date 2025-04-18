package com.example.simple_calculator_app_using_jetpack_compose

 sealed class calculatorOperation(val symbol:String) {
     object Add: calculatorOperation("+")
     object Subtract: calculatorOperation("-")
     object Multiply: calculatorOperation("x")
     object Divide: calculatorOperation("/")
}