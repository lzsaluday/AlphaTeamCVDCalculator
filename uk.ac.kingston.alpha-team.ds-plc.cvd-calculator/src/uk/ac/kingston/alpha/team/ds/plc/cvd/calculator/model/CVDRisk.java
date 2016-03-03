/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.model;

/**
 *
 * @author k1357811
 */
public class CVDRisk
{   
    public static int calculateCholPoints(int age, boolean male, boolean smoker, 
            boolean diabetes, double bloodPressure, String bloodPressureType,
            double totalCholesterol, String totalCholesterolUnit, 
            double hdlCholesterol, String hdlCholesterolUnit)
    {
        int points = 0;
        points += getAgeCholPoints(age, male);
        points += getSmokerPoints(smoker);
        points += getDiabetesPoints(diabetes, male);
        
        return points;
    }
    
    public static int getAgeCholPoints(int age, boolean male)
    {
        int points = 0;
        //If male
        if(male)
        {
            //Age
            if(30 <= age && age <35)
            {
                points -= 1;
            }
            else if(age < 40)
            {
                points += 0;
            }
            else if(age < 45)
            {
                points += 1;
            }
            else if(age < 50)
            {
                points += 2;
            }
            else if(age < 55)
            {
                points += 3;
            }
            else if(age < 60)
            {
                points += 4;
            }
            else if(age < 65)
            {
                points += 5;
            }
            else if(age < 70)
            {
                points += 6;
            }
            else if(age < 75)
            {
                points += 7;
            }
        }
        //If female
        else 
        {
            //Age
            if(30 <= age && age <35)
            {
                points -= 9;
            }
            else if(age < 40)
            {
                points -= 4;
            }
            else if(age < 45)
            {
                points += 0;
            }
            else if(age < 50)
            {
                points += 3;
            }
            else if(age < 55)
            {
                points += 6;
            }
            else if(age < 60)
            {
                points += 7;
            }
            else if(age < 65)
            {
                points += 8;
            }
            else if(age < 70)
            {
                points += 8;
            }
            else if(age < 75)
            {
                points += 8;
            }
        }
        return points;
    }
    
    /**
     * Smoking results in same amount of ldl and chol points 
     * for both males and females.
     * @param smoker
     * @return 
     */
    public static int getSmokerPoints(boolean smoker)
    {
        int points = 0;
        if(smoker)
        {
            points += 2;
        }
        return points;
    }
    
    /**
     * Diabetes gives the same amount of ldl and chol points
     * but it depends on the gender.
     * @param diabetes
     * @param male
     * @return 
     */
    public static int getDiabetesPoints(boolean diabetes, boolean male)
    {
        int points = 0;
        if(diabetes)
        {
            if(male)
            {
                points += 2;
            }
            else
            {
                points +=4;
            }
        }
        return points;
    }
    
    public static int calculateLDLPoints(int age, boolean male, boolean smoker, 
            boolean diabetes, double bloodPressure, String bloodPressureType,
            double ldlCholesterol, String ldlCholesterolUnit, 
            double hdlCholesterol, String hdlCholesterolUnit)
    {
        return 0;
    }
    
    public static int calculateCVDRiskWithChol(int cholPoints)
    {
        
        return 0;
    }
    
    public static int calculateCVDRiskWithLDL()
    {
        return 0;
    }
    
    public static String comparativeRisk()
    {
        
        return null;
    }
}
