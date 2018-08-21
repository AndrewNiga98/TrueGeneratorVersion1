package com.company;

import java.util.Random;

public class SudokuGenerator {

    private int[][] matrix = new int[9][9];


    public SudokuGenerator()
    {
        // generates first row
        for(int i=0;i<9;i++)
        {
            matrix[0][i] = i+1;
        }
        int index1, temp1;
        Random random = new Random();
        for(int i=8;i>0;i--)
        {
            index1 = random.nextInt(i+1);
            temp1 = matrix[0][index1];
            matrix[0][index1] = matrix[0][i];
            matrix[0][i] = temp1;
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

    void changeMatrix()
    {
        int amount = (int) (Math.random()*20) + 8; //generates the number of changes
        int change[] = new int[amount]; //and numbers of those changes
        for(int i=0;i<amount;i++)
        {
            change[i] = (int) (Math.random()*3) +1;
            if(change[i]==1)
            {
                //here we change rows
                int changingRow = (int) (Math.random()*9);
                switch (changingRow) //according to number of row we choose different way of sort
                {
                    case 0:
                    case 3:
                    case 6:
                    {

                        int rand = (int) (Math.random()*2)+1; //change 1st and 2nd or 3rd row of the sector
                        for (int k = 0; k < 9; k++)
                        {
                            int temp = matrix[changingRow][k];
                            matrix[changingRow][k] = matrix[changingRow + rand][k];
                            matrix[changingRow + rand][k] = temp;
                        }
                    }break;
                    case 1:
                    case 4:
                    case 7:
                    {
                        int rand = (int) (Math.random()*2);//2nd and 1 or 3rd depending on rand
                        if(rand == 0)
                        {
                            for(int k=0;k<9;k++)
                            {
                                int temp = matrix[changingRow][k];
                                matrix[changingRow][k] = matrix[changingRow - 1][k];
                                matrix[changingRow - 1][k] = temp;
                            }
                        }
                        if(rand == 1)
                        {
                            for(int k=0;k<9;k++)
                            {
                                int temp = matrix[changingRow][k];
                                matrix[changingRow][k] = matrix[changingRow + 1][k];
                                matrix[changingRow + 1][k] = temp;
                            }
                        }
                    }break;
                    case 2:
                    case 5:
                    case 8:
                    {
                        int rand = (int) (Math.random()*2) -2;//3rd and 1st or 2nd
                        for (int k = 0; k < 9; k++)
                        {
                            int temp = matrix[changingRow][k];
                            matrix[changingRow][k] = matrix[changingRow + rand][k];
                            matrix[changingRow + rand][k] = temp;
                        }
                    }break;
                }



            }
            if(change[i]==2)
            {
                //same acts with column
                int changingColumn = (int) (Math.random()*9);
                switch (changingColumn)
                {
                    case 0:
                    case 3:
                    case 6:
                    {
                        int rand = (int)(Math.random()*2)+1;
                        for(int k=0;k<9;k++)
                        {
                            int temp=matrix[k][changingColumn];
                            matrix[k][changingColumn] = matrix[k][changingColumn+rand];
                            matrix[k][changingColumn+rand] = temp;
                        }
                    }break;
                    case 1:
                    case 4:
                    case 7:
                    {
                        int rand = (int) (Math.random()*2);
                        if(rand == 0)
                        {
                            for(int k=0;k<9;k++)
                            {
                                int temp=matrix[k][changingColumn];
                                matrix[k][changingColumn] = matrix[k][changingColumn - 1];
                                matrix[k][changingColumn - 1] = temp;
                            }
                        }
                        if(rand == 1)
                        {
                            for(int k=0;k<9;k++)
                            {
                                int temp=matrix[k][changingColumn];
                                matrix[k][changingColumn] = matrix[k][changingColumn+rand];
                                matrix[k][changingColumn+rand] = temp;
                            }
                        }
                    }break;
                    case 2:
                    case 5:
                    case 8:
                    {
                        int rand = (int) (Math.random()*2)-2;
                        for(int k=0;k<9;k++)
                        {
                            int temp=matrix[k][changingColumn];
                            matrix[k][changingColumn] = matrix[k][changingColumn+rand];
                            matrix[k][changingColumn+rand] = temp;
                        }
                    }break;

                }

            }

            if(change[i]==3)
            {
                //transpose the matrix *columns are rows*
                int changeMatrix[][] = new int [9][9];
                for(int k=0;k<9;k++)
                {
                    for(int j=0;j<9;j++)
                    {
                        changeMatrix[k][j] = matrix[j][k];
                    }
                }
                for(int k=0;k<9;k++)
                {
                    for(int j=0;j<9;j++)
                    {
                        matrix[k][j] = changeMatrix[k][j];
                    }
                }

            }
        }


    }




}
