package leetCode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    /*
        Evaluate the value of an arithmetic expression in Reverse Polish Notation.
        Valid operators are +, -, *, /. Each operand may be an integer or another
        expression.
        Some examples:
        ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
        ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */

    public static void main(String[] args) {
        String[] arr1 = {"2","1","+","3","*"};
        String[] arr2 = {"4","13","5","/","+"};
        System.out.println(evaluate(arr1));
        System.out.println(evalRPN(arr2));
    }

    public static String evaluate(String[] arr) {
        Stack<String> stack = new Stack<>();
        String operators = "+-*/";

        for (String each : arr) {
            if (!operators.contains(each)) {
                stack.push(each);
            } else {
                stack.push(applyOp(stack.pop(), stack.pop(), each));
            }
        }
        return stack.pop();
    }

    private static String applyOp(String s1, String s2, String op) {
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        int result = 0;

        switch (op) {
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n2 - n1;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                result = n2 / n1;
                break;
        }
        return String.valueOf(result);
    }

    public static int evalRPN(String[] tokens) {
        int returnValue;
        String operators = "+-*/";
        Stack<String> stack = new Stack<>();
        for (String t : tokens) {
            if (!operators.contains(t)) {
                stack.push(t);
            } else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int index = operators.indexOf(t);
                switch (index) {
                    case 0:
                        stack.push(String.valueOf(a + b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b - a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a * b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }
        returnValue = Integer.parseInt(stack.pop());
        return returnValue;
    }
}
