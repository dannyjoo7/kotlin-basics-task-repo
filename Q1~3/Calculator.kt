package com.example.practice

class Calculator {
    var sel: Int = 0;

    fun start() {
        menu();
    }

    fun menu() {
        while (true) {
            println("=================")
            println("< 계산기 프로그램 >")
            println(" 1. 덧셈 ")
            println(" 2. 뺄셈 ")
            println(" 3. 곱셈 ")
            println(" 4. 나눗셈 \n")
            println(" 0. 종료 \n")
            print(" - 선택 > "); this.sel = readLine()!!.toInt();

            when (sel) {
                1 -> {
                    this.addOperation(AddOperation());
                }

                2 -> {
                    this.subOperation(SubstractOperation());
                }

                3 -> {
                    this.mulOperation(MultiplyOperation());
                }

                4 -> {
                    this.divOperation(DivideOperation());
                }

                0 -> {
                    println("종료...");
                    return
                }
            }
        }
    }

    fun addOperation(op: AddOperation) {
        println("<덧셈>")

        print("X : ")
        var x = readLine()!!.toInt()
        print("Y : ")
        var y = readLine()!!.toInt()
        print("덧셈 값 : " + op.operate(x, y) + "\n")
    }

    fun subOperation(op: SubstractOperation) {
        println("<뺄셈>")

        print("X : ")
        var x = readLine()!!.toInt()
        print("Y : ")
        var y = readLine()!!.toInt()
        print("뺄셈 값 : " + op.operate(x, y) + "\n")
    }

    fun mulOperation(op: MultiplyOperation) {
        println("<곱셈>")

        print("X : ")
        var x = readLine()!!.toInt()
        print("Y : ")
        var y = readLine()!!.toInt()
        print("곱셈 값 : " + op.operate(x, y) + "\n")
    }

    fun divOperation(op: DivideOperation) {
        println("<나눗셈>")
        print("X : ")
        var x = readLine()!!.toInt()
        print("Y : ")
        var y = readLine()!!.toInt()
        if (y == 0) {
            println("Y의 값은 0이 되면 안됨!")
            return
        }
        print("나눗셈 값 : " + op.operate(x, y) + "\n")
    }
}