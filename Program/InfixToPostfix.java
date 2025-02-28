import java.io.*;
import java.util.*;

public class InfixToPostfix {

    // Checks if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // Returns precedence of operators
    private static int precedence(char c) {
        switch (c) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }

    // Converts infix expression to postfix notation
    public static String convertToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Remove '('
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses in expression");
                }
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(stack.peek()) > precedence(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            } else {
                throw new IllegalArgumentException("Invalid character in expression: " + c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                throw new IllegalArgumentException("Mismatched parentheses in expression");
            }
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String fileName = "input1.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String infix = reader.readLine();
            if (infix == null || infix.trim().isEmpty()) {
                throw new IllegalArgumentException("Input file is empty");
            }
            System.out.println("Infix: " + infix);
            System.out.println("Postfix: " + convertToPostfix(infix));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid Expression: " + e.getMessage());
        }
    }
}