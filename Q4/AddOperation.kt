package com.example.practice.Q4

class AddOperation : AbstractOperation() {
    override fun operate(x: Int, y: Int) : Double{
        return (x + y).toDouble();
    }
}