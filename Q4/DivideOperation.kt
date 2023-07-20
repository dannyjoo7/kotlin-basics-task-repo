package com.example.practice.Q4

class DivideOperation : AbstractOperation() {
    override fun operate(x: Int, y: Int): Double? {
        if (y == 0) {
            println("0으로 나눔!"); return null
        }
        return (x.toDouble() / y.toDouble());
    }
}