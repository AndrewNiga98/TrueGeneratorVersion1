package com.company;
import com.company.SudokuGenerator;

public class Main {

    public static void main(String[] args) {

        SudokuGenerator matrix = new SudokuGenerator();
        matrix.showMatrix();
        matrix.changeMatrix();
        System.out.println("\nNew matrix : \n");
        matrix.showMatrix();
    }
}
