package com.example.practice.Q4

class SubstractOperation: AbstractOperation() {
    override fun operate(x: Int, y: Int) : Double{
        return (x - y).toDouble();
    }
}