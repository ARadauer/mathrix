package com.radauer.mathrix.example.at;

import static java.math.MathContext.DECIMAL32;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ApproximationTest
{

    public static void main(String[] args)
    {

        int maxTries = Integer.MIN_VALUE;
        BigDecimal startValue = new BigDecimal(12345);
        for (double nova = 0.01; nova < 0.2d; nova += 0.01)
        {

            for (int i = 0; i < 10000; i++)
            {

                BigDecimal net = startValue.add(new BigDecimal(i).divide(new BigDecimal(100)));

                BigDecimal vatPtc = new BigDecimal(0.2, DECIMAL32);
                BigDecimal spTaxPtc = new BigDecimal(nova, DECIMAL32);

                BigDecimal roundingDif = BigDecimal.ONE;
                BigDecimal factorToAdd = BigDecimal.ZERO;
                BigDecimal gross;

                int tries = 0;
                while (roundingDif.abs().compareTo(new BigDecimal("0.009")) > 0 && tries < 10)
                {
                    tries++;
                    net = net.subtract(factorToAdd);
                    BigDecimal vatAmt = net.multiply(vatPtc, DECIMAL32);
                    BigDecimal spTaxAmt = net.multiply(spTaxPtc, DECIMAL32);
                    gross = net.add(vatAmt).add(spTaxAmt);
                    BigDecimal grossRounded = gross.setScale(0, RoundingMode.HALF_UP);
                    roundingDif = gross.subtract(grossRounded);
                    factorToAdd = roundingDif.divide(new BigDecimal(1.3), 4, RoundingMode.HALF_UP);


          /* System.out.println(roundingDif);
            System.out.println("============");*/


            /*try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }*/
                }
                if (tries > maxTries)
                {
                    maxTries = tries;
                }

                //System.out.println("NET: " + net + " GROSS: " + gross + " dif: "+roundingDif+" count " + tries);
            }
        }
        System.out.println("MAX: " + maxTries);
    }
}
