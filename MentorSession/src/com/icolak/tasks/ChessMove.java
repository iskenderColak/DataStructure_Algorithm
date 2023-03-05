package com.icolak.tasks;

public class ChessMove {

    public static void main(String[] args) {

        System.out.println(run("5h", 11, 25));
        System.out.println(run("2b", 3, 2));

    }

    public static String run(String startPosition, int R, int C) {
        int row = startPosition.charAt(0) + (R % 8);
        int column = startPosition.charAt(1) + (C % 8);
        if (column - 96 > 8) {
            column = column - 8;
        }
        return (char) row + "" + (char) column;
    }
}

/*
The chessboard bellow has 64 squares, 8 rows and 8 columns. Each row is labeled from 1 to 8 and each column is labeled from a to h (lowercase).
A square is located at the intersection of a row and of a column, like square 2C it's the intersection of the row 2 and column C.



Positioning a pawn to a starting square, you need to find out where it will be the end square after moving it R times (rows) vertically to the top and
C times (columns) horizontally to the right. If during the moves the pawn reaches the end of the board,
it will start again from the opposite direction like in the examples below.

INPUT
string    StartPosition
number    R
number    C

OUTPUT
string    EndPosition

EXAMPLE 1
Input
StartPosition: 2b, R: 3, C: 2

Output
5d

EXAMPLE 2
Input
StartPosition: 5h, R: 11, C: 25

Output
8a
 */
