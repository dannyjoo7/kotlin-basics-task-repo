package com.example.practice.Q4

class Calculator {
    var sel: Int = 0;
    lateinit var curOperation: AbstractOperation;
    lateinit var op: String;

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
            println(" 5. 수식 입력 \n")
            print(" 0. 종료 \n")
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

                5 -> {
                    performArithmeticOperation()
                }

                0 -> {
                    println("종료...");
                    return
                }

                else -> {
                    println("다시 선택!");
                }
            }
        }
    }

    fun performArithmeticOperation() {
        println("<수식 입력>")
        print(" > : ");
        var expression = readLine().toString();

        if (expressionCheck(expression)) {
            println("완벽한 수식");
        } else {
            println("틀린 수식"); return;
        }

        expression = relocation(expression.replace(" ", ""));
        var expressionToArray = ArrayList(expression.split(" "));
        println("결과값 : ${calculateResult(expressionToArray, 0)}");
    }

    fun showData() {
        println("<$op>")
        print("X : ")
        var x = readLine()!!.toInt()
        print("Y : ")
        var y = readLine()!!.toInt()
        if (op.equals("나눗셈") && y == 0) {
            println("0으로 나눔!");
            return
        }
        print("$op 값 : " + curOperation.operate(x, y) + "\n");
    }

    fun expressionCheck(expression: String): Boolean {
        var bracketCount: Int = 0;
        var isOp: Boolean = false;

        for (char in expression) {
            when (char) {
                '(' -> {
                    bracketCount++;
                }

                ')' -> {
                    bracketCount--;
                }

                '+', '-', '*', '/' -> {
                    if (isOp) return false;
                    isOp = true;
                }

                else -> {
                    isOp = false;
                }
            }
        }

        // 마지막이 연산자로 끝났을 시...
        if (isOp) return false

        // 괄호의 갯수가 만족했을 시...
        return bracketCount == 0
    }

    fun relocation(expression: String): String {
        var strRelocate: String = "";
        for (i: Int in expression.indices) {
            when (expression[i]) {
                '+', '-', '*', '/', ')' -> {
                    strRelocate += " ${expression[i]} "
                }

                '(' -> {
                    if (i == 0) {
                        strRelocate += " ${expression[i]} "; continue;
                    }
                    strRelocate += if (expression[i - 1] in '1'..'9') {
                        " * ${expression[i]} "
                    } else
                        " ${expression[i]} "
                }

                else -> {
                    strRelocate += expression[i];
                }
            }
        }
        return strRelocate;
    }

    fun calculateResult(expression: ArrayList<String>, startIndex: Int = 0): String? {
        var index = startIndex // index 변수를 루프 외부에서 선언

        while (index < expression.size) { // for-in 대신 while 루프 사용

            when (expression[index]) {
                "(" -> {
                    index++
                    calculateResult(expression, index)
                }

                ")" -> {
                    // 결과값 받아오기
                    var result = cal(ArrayList(expression.subList(startIndex, index)))


                    // (1 +5) * 2(2+3)
                    expression.add(startIndex - 1, result);

                    for (i: Int in startIndex..index + 1) {
                        expression.removeAt(startIndex);
                    }
                    return null;
                }

                // 다른 경우에 대한 처리 로직

                else -> {
                    index++
                }
            }
        }
        return cal(expression);
    }


    fun cal(block: ArrayList<String>): String {
        var index = 0

        // 공백 제거
        block.removeIf { it.isBlank() }

        // *, / 먼저 계산
        while (index < block.size) {
            when (block[index]) {
                "*" -> {
                    val result = block[index - 1].toInt() * block[index + 1].toInt()
                    block[index - 1] = result.toString() // 연산 결과를 삽입
                    block.removeAt(index) // '*' 제거
                    block.removeAt(index) // 다음 피연산자 제거
                }

                "/" -> {
                    val result = block[index - 1].toInt() / block[index + 1].toInt()
                    block[index - 1] = result.toString() // 연산 결과를 삽입
                    block.removeAt(index) // '/' 제거
                    block.removeAt(index) // 다음 피연산자 제거
                }

                else -> {
                    index++
                }
            }
        }

        index = 0
        while (index < block.size) {
            when (block[index]) {
                "+" -> {
                    val result = block[index - 1].toInt() + block[index + 1].toInt()
                    block[index - 1] = result.toString() // 연산 결과를 삽입
                    block.removeAt(index) // '+' 제거
                    block.removeAt(index) // 다음 피연산자 제거
                }

                "-" -> {
                    val result = block[index - 1].toInt() - block[index + 1].toInt()
                    block[index - 1] = result.toString() // 연산 결과를 삽입
                    block.removeAt(index) // '-' 제거
                    block.removeAt(index) // 다음 피연산자 제거
                }

                else -> {
                    index++
                }
            }
        }

        return block.joinToString("");
    }
}