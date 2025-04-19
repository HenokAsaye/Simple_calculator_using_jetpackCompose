package com.example.simple_calculator_app_using_jetpack_compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.plcoding.composecalculator.CalculatorActions

class CalculatorViewModel:ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set
    fun onAction(action: CalculatorActions){
        when(action){
            is CalculatorActions.Number -> enterNumber(action.number)
            is CalculatorActions.Decimal -> enterDecimal()
            is CalculatorActions.Clear -> state = CalculatorState()
            is CalculatorActions.Operation -> enterOperation(action.operation)
            is CalculatorActions.Calculate -> performCalculation()
            is CalculatorActions.Delete -> performDeletion()
        }

    }

    private fun performDeletion(){
        when{
            state.Number2.isNotBlank() -> state = state.copy(
                Number2 = state.Number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )

            state.Number1.isNotBlank() -> state = state.copy(
                Number1 = state.Number1.dropLast(1)
            )

        }

    }
    private fun enterOperation(calculatorOperation: calculatorOperation){
        if(state.Number1.isNotBlank()){
            state = state.copy(operation = calculatorOperation)
        }
    }
    private fun performCalculation() {
        val number1 = state.Number1.toDoubleOrNull()
        val number2 = state.Number2.toDoubleOrNull()
        if(number1 != null && number2 != null){
            val result = when(state.operation){
                is calculatorOperation.Add -> number1 + number2
                is calculatorOperation.Subtract -> number1 - number2
                is calculatorOperation.Multiply -> number1 * number2
                is calculatorOperation.Divide -> number1 / number2
                null -> return
            }
        }
    }

    private fun enterDecimal() {
        if(state.operation == null && !state.Number1.contains(".") && state.Number1.isNotBlank()){
            state = state.copy(
                Number1 = state.Number1 + "."
            )
            return
        }
        if(!state.Number2.contains(".") && state.Number2.isNotBlank()){
            state = state.copy(
                Number1 = state.Number2 + "."
            )
        }
    }
    private fun enterNumber(number: Int){
        if(state.operation == null){
            if(state.Number1.length >= MAX_NUM_LENGTH){
                return
            }
            state  = state.copy(
                Number1 = state.Number1  + number
            )
            return
        }
        if(state.Number2.length >= MAX_NUM_LENGTH){
            return
        }
        state = state.copy(
            Number2 = state.Number2 + number
        )
    }

    companion object{
        private const val MAX_NUM_LENGTH = 8
    }






}