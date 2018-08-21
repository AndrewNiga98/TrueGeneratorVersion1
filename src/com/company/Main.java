package com.company;
import com.company.SudokuGenerator;

public class Main {

    public static void main(String[] args) {

        SudokuGenerator matrix = new SudokuGenerator();
        matrix.showMatrix();
        matrix.changeMatrix();
        System.out.println("New matrix :\n");
        matrix.showMatrix();

    }
}
