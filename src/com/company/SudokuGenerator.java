package com.company;

public class SudokuGenerator {

    private int[][] matrix = new int[9][9];

    public SudokuGenerator(int [][] matrix)
    {
        this.matrix = matrix;
    }

    public SudokuGenerator()
    {

        //here u generate 1st row
        for(int i=0;i<9;i++)
        {
            this.matrix[0][i] = (int) (Math.random()*10);
            if(matrix[0][i]==0)
            {
                while (matrix[0][i]==0)
                {
                    matrix[0][i] = (int)(Math.random()*10);
                }
            }
            int j;
            for(j=i;j>=0;j--) //just check if there are same numbers in the row
            {
                if(i==0)
                    break;
                if(matrix[0][j]==matrix[0][i])
                {
                    matrix[0][i]=(int)(Math.random()*10);
                    if(matrix[0][i]==0)
                    {
                        while (matrix[0][i]==0)
                        {
                            matrix[0][i] = (int)(Math.random()*10);
                        }
                    }
                    j=i;
                }
            }

        }


        //here u sort first row to make it clear
        for(int i=0;i<9;i=i+3)
        {
            int index=i+1;
            for(int j=i+1;j<9;j++)
            {

                if(matrix[0][i]==matrix[0][j]+3 || matrix[0][i]==matrix[0][j]+6 || matrix[0][i]==matrix[0][j]-3 || matrix[0][i]==matrix[0][j]-6)
                {
                    int temp = matrix[0][j];
                    matrix[0][j] = matrix[0][index];
                    matrix[0][index] = temp;
                    index+=1;
                }
            }
        }
        int increaser = (int) (Math.random()*9);         //here we initialize a number that will be plused
        boolean success = true;
        while(success)
        {
            if(increaser == 0 || increaser == 1 || increaser%3==0)  //no sense to plus 0 or 1 or 3
                increaser = (int) (Math.random()*9);
            else
                success = false;
        }

        for(int i=1;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                matrix[i][j]=matrix[i-1][j] + increaser;
                if(matrix[i][j]>9)
                    matrix[i][j]-=9;
            }
        }
    }

    void showMatrix()
    {
        System.out.print("____________________\n");
        int  line1=0, line2 = 0;
        for(int i=0;i<9;i++)
        {
            System.out.print("|");
            for(int j=0;j<9;j++)
            {

                System.out.print(matrix[i][j] + " ");
                line2+=1;
                if(line2%3==0)
                    System.out.print("|");
            }
            System.out.print("\n");
            line1+=1;
            if(line1%3==0)
                System.out.println("----------------------");
        }
    }




}
