# Programming-Assignment-3-ADT


### Description

This program converts an infix mathematical expression into its equivalent postfix notation using a **stack-based approach**. It reads the infix expression from a file (`input1.txt`), processes each character, and correctly applies operator precedence and associativity rules to generate the corresponding postfix expression. The program ensures proper handling of parentheses and detects any invalid expressions.

### Installation

1. Ensure you have **Java** installed on your system.
2. Download or copy the `InfixToPostfix.java` file.
3. Create an `input1.txt` file in the same directory and insert a valid infix expression.
4. Compile the program using:
   ```sh
   javac InfixToPostfix.java
   ```
5. Run the program:
   ```sh
   java InfixToPostfix
   ```

### Usage

- The program reads an infix expression from `input1.txt`.
- It validates the expression, ensuring correct use of operators and parentheses.
- It converts the infix expression to postfix notation using a **stack-based approach**.
- The converted postfix expression is displayed on the console.

### Features

- **Operator Handling**: Supports `+`, `-`, `*`, `/`, and `^` operators.
- **Parentheses Support**: Correctly processes expressions with `(` and `)`.
- **Error Handling**: Detects invalid characters and mismatched parentheses.
- **File Input**: Reads expressions from an external file.
- **Stack-Based Processing**: Efficient conversion using a stack for operators.
- **User-Friendly Output**: Displays both the input infix expression and the resulting postfix expression.

