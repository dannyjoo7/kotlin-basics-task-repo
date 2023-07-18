package com.example.practice.Q4

class MultiplyOperation : AbstractOperation(){
    override fun operate(x: Int, y: Int) : Double{
        return (x * y).toDouble();
    }
}