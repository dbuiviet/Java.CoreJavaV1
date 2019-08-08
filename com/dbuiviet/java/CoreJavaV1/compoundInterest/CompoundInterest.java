package com.dbuiviet.java.CoreJavaV1.compoundInterest;

public class CompoundInterest
{
    public static void main(String[] args) {
        final double STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;

        //set interest rates to 10..15%
        double[] irates = new double[NRATES];
        for (int i=0; i<NRATES; i++)
        {
            irates[i] = (STARTRATE + i)/100.0;
        }

        double[][] balances = new double[NYEARS][NRATES];

        for(int j=0; j<balances[0].length; j++)
        {
            balances[0][j] = 10000;
        }

        //compute interest for future years
        for(int i=1; i<balances.length; i++)
        {
            for(int j=0; j<balances[i].length; j++)
            {
                //get last year's balances from previous rows
                double oldBalance = balances[i-1][j];

                //compute interest
                double interest = oldBalance * irates[j];

                //compute this year's balances
                balances[i][j] = oldBalance + interest;
            }
        }

        //print one row of interest rates
        for(int j=0; j<irates.length; j++)
        {
            System.out.printf("%9.0f%%", 100 * irates[j]);
        }

        System.out.println();

        //print balance table
        for(double[] row : balances)
        {
            //print table row
            for(double b : row)
            {
                System.out.printf("%10.2f", b);
            }

            System.out.println();
        }
    }
}