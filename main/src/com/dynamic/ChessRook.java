package com.dynamic;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ChessRook {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/freddie/Desktop/ChessRook"));
        int numberOfInadmissibleBlocks = Integer.valueOf(br.readLine());
        int[][] chessboard = new int[9][9];
        chessboard[1][1] = 1;
        for (int i = 0; i < numberOfInadmissibleBlocks; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), ",");
            chessboard[Integer.parseInt(stringTokenizer.nextToken())][Integer.parseInt(stringTokenizer.nextToken())] = -1;
        }
        System.out.println(calcNumberOfPathsToEndBlock(chessboard));
    }

    private static int calcNumberOfPathsToEndBlock(int[][] chessBoard) {
        for (int i = 1; i < chessBoard.length; i++) {
            for (int j = 1; j < chessBoard.length; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (chessBoard[i - 1][j] != -1 && chessBoard[i][j - 1] != -1) {
                    chessBoard[i][j] = chessBoard[i - 1][j] + chessBoard[i][j - 1];
                } else if (chessBoard[i - 1][j] == -1) {
                    chessBoard[i][j] = chessBoard[i][j - 1];
                } else if (chessBoard[i][j - 1] == -1) {
                    chessBoard[i][j] = chessBoard[i - 1][j];
                }
            }
        }
        return chessBoard[8][8];
    }
}
