package com.icolak.shuntingYard;

import java.util.Stack;

public class ShuntingYard {

    public static void main(String[] args) {

        System.out.println(evaluate("10 + 2 * 6"));
        System.out.println(evaluate("100 * 2 + 12"));
        System.out.println(evaluate("100 * ( 2 + 12 )"));
        System.out.println(evaluate("100 * ( 2 + 12 ) / 14"));
        System.out.println(evaluate("100 * ( 12 + 12 * ( 2 + 4 ) ) / 14"));
    }

    public static int evaluate(String expression) {

        char[] tokens = expression.toCharArray();

        // Stack for numbers: 'numberStack'
        Stack<Integer> numberStack = new Stack<>();

        // Stack for operators: 'opsStack'
        Stack<Character> opsStack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            // if current token is a blank
            // then continue
            if (tokens[i] == ' ')
                continue;

            // if current token is a number
            // then push it to numberStack
            if (tokens[i] >= '0' && tokens[i] <= '9') {

                StringBuffer stringBuffer = new StringBuffer();

                // if number has more than one digit
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    stringBuffer.append(tokens[i++]);
                }
                numberStack.push(Integer.parseInt(stringBuffer.toString()));

                //we need to decrease the value of i by 1 to correct the offset.
                i--;

            }

            // if current token is an opening brace,
            // then push it to opsStack
            else if (tokens[i] == '(') {
                opsStack.push(tokens[i]);
            }

            // Closing brace encountered,
            // solve entire brace
            else if (tokens[i] == ')') {
                while (opsStack.peek() != '(') {
                    numberStack.push(applyOp(opsStack.pop(), numberStack.pop(), numberStack.pop()));
                }
                // popping the opening brace
                opsStack.pop();
            }

            // If current token is an operator
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/') {

                // While top of 'ops' has same
                // or greater precedence to current
                // token, which is an operator.
                // Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!opsStack.empty() && hasPrecedence(tokens[i], opsStack.peek())) {
                    numberStack.push(applyOp(opsStack.pop(), numberStack.pop(), numberStack.pop()));
                }
                opsStack.push(tokens[i]);
            }
        }

        // Entire expression has been
        // parsed at this point, apply remaining
        // ops to remaining values
        while (!opsStack.empty()) {
            numberStack.push(applyOp(opsStack.pop(), numberStack.pop(), numberStack.pop()));
        }

        return numberStack.pop();
    }

    // Returns true if 'op2' has higher
    // or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
                (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an
    // operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a) {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException(
                            "Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}















