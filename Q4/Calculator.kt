package com.example.practice.Q4

class Calculator {
    var sel: Int = 0;
    var curOperation:AbstractOperation = AddOperation();
    lateinit var op:String;


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
            println("=================")
            print(" - 선택 > "); this.sel = readLine()!!.toInt();

            when (sel) {
                1 -> {
                    this.curOperation = AddOperation();
                    op = "덧셈"
                    showData();
                }

                2 -> {
                    this.curOperation = SubstractOperation();
                    op = "뺄셈"
                    showData();
                }

                3 -> {
                    this.curOperation = MultiplyOperation();
                    op = "곱샘"
                    showData();
                }

                4 -> {
                    this.curOperation = DivideOperation();
                    op = "나눗셈"
                    showData();
                }

                0 -> {
                    println("종료...");
                    return
                }
            }
        }
    }

    fun showData(){
        println("<$op>")
        print("X : ")
        var x = readLine()!!.toInt()
        print("Y : ")
        var y = readLine()!!.toInt()
        if(op.equals("나눗셈") && y == 0) {
            println("0으로 나눔!");
            return
        }
        print("$op 값 : " + curOperation.operate(x, y) + "\n");
    }
}