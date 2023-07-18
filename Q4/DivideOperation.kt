package com.example.practice.Q4

class DivideOperation: AbstractOperation() {
    override fun operate(x: Int, y: Int) : Double{
        return (x.toDouble() / y.toDouble());
    }
}