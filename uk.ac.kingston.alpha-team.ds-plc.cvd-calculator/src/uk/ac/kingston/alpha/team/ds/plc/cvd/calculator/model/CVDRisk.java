/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author k1357811
 */
public class CVDRisk
{   
    
    public static int calculateCholPoints(int age, boolean male, boolean smoker, 
            boolean diabetes, double bloodPressure,
            double totalCholesterol, String totalCholesterolUnit, 
            double hdlCholesterol, String hdlCholesterolUnit)
    {
        int points = 0;
        points += getAgePoints(age, male);
        points += getSmokerPoints(smoker);
        points += getDiabetesPoints(diabetes, male);
        points += getBloodPressurePoints(male, bloodPressure);
        points += getCholesterolCholPoints(male, totalCholesterol, totalCholesterolUnit);
        points += getHDLCholPoints(male, hdlCholesterol, hdlCholesterolUnit);
        return points;
    }
    
    public static int calculateCVDRiskWithChol(boolean male, int cholPoints)
    {
        int cvdRisk = 0;
        //If male
        if(male)
        {
            if(cholPoints <= -1)
            {
                cvdRisk = 2;
            }
            else if(cholPoints == 0 || cholPoints == 1)
            {
                cvdRisk = 3;
            }
            else if(cholPoints == 2)
            {
                cvdRisk = 4;
            }
            else if(cholPoints == 3)
            {
                cvdRisk = 5;
            }
            else if(cholPoints == 4)
            {
                cvdRisk = 7;
            }
            else if(cholPoints == 5)
            {
                cvdRisk = 8;
            }
            else if(cholPoints == 6)
            {
                cvdRisk = 10;
            }
            else if(cholPoints == 7)
            {
                cvdRisk = 13;
            }
            else if(cholPoints == 8)
            {
                cvdRisk = 16;
            }
            else if(cholPoints == 9)
            {
                cvdRisk = 20;
            }
            else if(cholPoints == 10)
            {
                cvdRisk = 25;
            }
            else if(cholPoints == 11)
            {
                cvdRisk = 31;
            }
            else if(cholPoints == 12)
            {
                cvdRisk = 37;
            }
            else if(cholPoints == 13)
            {
                cvdRisk = 45;
            }
            else if(14 <= cholPoints)
            {
                cvdRisk = 53;
            }
        }
        //If female
        else
        {
            if(cholPoints <= -2)
            {
                cvdRisk = 1;
            }
            else if(cholPoints == -1 || cholPoints == 0 || cholPoints == 1)
            {
                cvdRisk = 2;
            }
            else if(cholPoints == 2 || cholPoints == 3)
            {
                cvdRisk = 3;
            }
            else if(cholPoints == 4 || cholPoints == 5)
            {
                cvdRisk = 4;
            }
            else if(cholPoints == 6)
            {
                cvdRisk = 5;
            }
            else if(cholPoints == 7)
            {
                cvdRisk = 6;
            }
            else if(cholPoints == 8)
            {
                cvdRisk = 7;
            }
            else if(cholPoints == 9)
            {
                cvdRisk = 8;
            }
            else if(cholPoints == 10)
            {
                cvdRisk = 10;
            }
            else if(cholPoints == 11)
            {
                cvdRisk = 11;
            }
            else if(cholPoints == 12)
            {
                cvdRisk = 13;
            }
            else if(cholPoints == 13)
            {
                cvdRisk = 15;
            }
            else if(cholPoints == 14)
            {
                cvdRisk = 18;
            }
            else if(cholPoints == 15)
            {
                cvdRisk = 20;
            }
            else if(cholPoints == 16)
            {
                cvdRisk = 24;
            }
            else if(17 <= cholPoints)
            {
                cvdRisk = 27;
            }
        }
        return cvdRisk;
    }
    
    //Specific to chol points calculation
    public static int getCholesterolCholPoints(boolean male, double totalCholesterol, String totalCholesterolUnit)
    {
        int points = 0;
        //If male
        if(male)
        {
            switch (totalCholesterolUnit) 
            {
                case "mg/dL":
                    if(totalCholesterol < 160)
                    {
                        points -= 3;
                    }
                    else if(totalCholesterol < 200)
                    {
                        points += 0;
                    }
                    else if(totalCholesterol < 240)
                    {
                        points += 1;
                    }
                    else if(totalCholesterol < 280)
                    {
                        points += 2;
                    }
                    else if(280 <= totalCholesterol)
                    {
                        points += 3;
                    }
                    break;
                case "mmol/L":
                    if(totalCholesterol < 4.14)
                    {
                        points -= 3;
                    }
                    else if(totalCholesterol < 5.18)
                    {
                        points += 0;
                    }
                    else if(totalCholesterol < 6.22)
                    {
                        points += 1;
                    }
                    else if(totalCholesterol < 7.25)
                    {
                        points += 2;
                    }
                    else if(7.25 <= totalCholesterol)
                    {
                        points += 3;
                    }
                    break;
            }
        }
        //If female
        else
        {
            switch (totalCholesterolUnit) 
            {
                case "mg/dL":
                    if(totalCholesterol < 160)
                    {
                        points -= 2;
                    }
                    else if(totalCholesterol < 200)
                    {
                        points += 0;
                    }
                    else if(totalCholesterol < 240)
                    {
                        points += 1;
                    }
                    else if(totalCholesterol < 280)
                    {
                        points += 1;
                    }
                    else if(280 <= totalCholesterol)
                    {
                        points += 3;
                    }
                    break;
                case "mmol/L":
                    if(totalCholesterol < 4.14)
                    {
                        points -= 2;
                    }
                    else if(totalCholesterol < 5.18)
                    {
                        points += 0;
                    }
                    else if(totalCholesterol < 6.22)
                    {
                        points += 1;
                    }
                    else if(totalCholesterol < 7.25)
                    {
                        points += 1;
                    }
                    else if(7.25 <= totalCholesterol)
                    {
                        points += 3;
                    }
                    break;
            }
        }
        return points;
    }
    
    //Specific to chol points calculation
    public static int getHDLCholPoints(boolean male, double hdlCholesterol, String hdlCholesterolUnit)
    {
        int points = 0;
        //If male
        if(male)
        {
            switch (hdlCholesterolUnit) 
            {
                case "mg/dL":
                    if(hdlCholesterol < 35)
                    {
                        points += 2;
                    }
                    else if(hdlCholesterol < 45)
                    {
                        points += 1;
                    }
                    else if(hdlCholesterol < 50)
                    {
                        points += 0;
                    }
                    else if(hdlCholesterol < 60)
                    {
                        points += 0;
                    }
                    else if(60 <= hdlCholesterol)
                    {
                        points -= 2;
                    }
                    break;
                case "mmol/L":
                    if(hdlCholesterol < 0.90)
                    {
                        points += 2;
                    }
                    else if(hdlCholesterol < 1.17)
                    {
                        points += 1;
                    }
                    else if(hdlCholesterol < 1.30)
                    {
                        points += 0;
                    }
                    else if(hdlCholesterol < 1.56)
                    {
                        points += 0;
                    }
                    else if(1.56 <= hdlCholesterol)
                    {
                        points -= 2;
                    }
                    break;
            }
        }
        //If female
        else
        {
            switch (hdlCholesterolUnit) 
            {
                case "mg/dL":
                    if(hdlCholesterol < 35)
                    {
                        points += 5;
                    }
                    else if(hdlCholesterol < 45)
                    {
                        points += 2;
                    }
                    else if(hdlCholesterol < 50)
                    {
                        points += 1;
                    }
                    else if(hdlCholesterol < 60)
                    {
                        points += 0;
                    }
                    else if(60 <= hdlCholesterol)
                    {
                        points -= 3;
                    }
                    break;
                case "mmol/L":
                    if(hdlCholesterol < 0.90)
                    {
                        points += 5;
                    }
                    else if(hdlCholesterol < 1.17)
                    {
                        points += 2;
                    }
                    else if(hdlCholesterol < 1.30)
                    {
                        points += 1;
                    }
                    else if(hdlCholesterol < 1.56)
                    {
                        points += 0;
                    }
                    else if(1.56 <= hdlCholesterol)
                    {
                        points -= 3;
                    }
                    break;
            }
        }
        return points;
    }
    
    public static int calculateLDLPoints(int age, boolean male, boolean smoker, 
            boolean diabetes, double bloodPressure,
            double ldlCholesterol, String ldlCholesterolUnit, 
            double hdlCholesterol, String hdlCholesterolUnit)
    {
        int points = 0;
        points += getAgePoints(age, male);
        points += getSmokerPoints(smoker);
        points += getDiabetesPoints(diabetes, male);
        points += getBloodPressurePoints(male, bloodPressure);
        points += getLDLCholesterolPoints(male, ldlCholesterol, ldlCholesterolUnit);
        points += getHdlLdlPoints(male, hdlCholesterol, hdlCholesterolUnit);
        return points;
    }
    
    public static int calculateCVDRiskWithLDL(boolean male, int ldlPoints)
    {
        int chdRisk = 0;
        //If male
        if(male)
        {
            if(ldlPoints <= -3)
            {
                chdRisk = 1;
            }
            else if(ldlPoints == -2 || ldlPoints == -1)
            {
                chdRisk = 2;
            }
            else if(ldlPoints == 0)
            {
                chdRisk = 3;
            }
            else if(ldlPoints == 1 || ldlPoints == 2)
            {
                chdRisk = 4;
            }
            else if(ldlPoints == 3)
            {
                chdRisk = 6;
            }
            else if(ldlPoints == 4)
            {
                chdRisk = 7;
            }
            else if(ldlPoints == 5)
            {
                chdRisk = 9;
            }
            else if(ldlPoints == 6)
            {
                chdRisk = 11;
            }
            else if(ldlPoints == 7)
            {
                chdRisk = 14;
            }
            else if(ldlPoints == 8)
            {
                chdRisk = 18;
            }
            else if(ldlPoints == 9)
            {
                chdRisk = 22;
            }
            else if(ldlPoints == 10)
            {
                chdRisk = 27;
            }
            else if(ldlPoints == 11)
            {
                chdRisk = 33;
            }
            else if(ldlPoints == 12)
            {
                chdRisk = 40;
            }
            else if(ldlPoints == 13)
            {
                chdRisk = 47;
            }
            else if(14 <= ldlPoints)
            {
                chdRisk = 56;
            }
        }
        //If female
        else
        {
            if(ldlPoints <= -2)
            {
                chdRisk = 1;
            }
            else if(ldlPoints == -1 || ldlPoints == 0 || ldlPoints == 1)
            {
                chdRisk = 2;
            }
            else if(ldlPoints == 2 || ldlPoints == 3)
            {
                chdRisk = 3;
            }
            else if(ldlPoints == 4)
            {
                chdRisk = 4;
            }
            else if(ldlPoints == 5)
            {
                chdRisk = 5;
            }
            else if(ldlPoints == 6)
            {
                chdRisk = 6;
            }
            else if(ldlPoints == 7)
            {
                chdRisk = 7;
            }
            else if(ldlPoints == 8)
            {
                chdRisk = 8;
            }
            else if(ldlPoints == 9)
            {
                chdRisk = 9;
            }
            else if(ldlPoints == 10)
            {
                chdRisk = 11;
            }
            else if(ldlPoints == 11)
            {
                chdRisk = 13;
            }
            else if(ldlPoints == 12)
            {
                chdRisk = 15;
            }
            else if(ldlPoints == 13)
            {
                chdRisk = 17;
            }
            else if(ldlPoints == 14)
            {
                chdRisk = 20;
            }
            else if(ldlPoints == 15)
            {
                chdRisk = 24;
            }
            else if(ldlPoints == 16)
            {
                chdRisk = 27;
            }
            else if(17 <= ldlPoints)
            {
                chdRisk = 32;
            }
        }
        return chdRisk;
    }
    
    public static int getLDLCholesterolPoints(boolean male, double ldlCholesterol, String ldlCholesterolUnit)
    {
        int points = 0;
        //If male
        if(male)
        {
            switch(ldlCholesterolUnit)
            {
                case "mg/dl":
                    if(ldlCholesterol < 100)
                    {
                        points -= 3;
                    }
                    else if(ldlCholesterol < 160)
                    {
                        points += 0;
                    }
                    else if(ldlCholesterol < 190)
                    {
                        points += 1;
                    }
                    else if(190 <= ldlCholesterol)
                    {
                        points += 2;
                    }
                    break;
                case "mmol/L":
                    if(ldlCholesterol < 2.59)
                    {
                        points -= 3;
                    }
                    else if(ldlCholesterol < 4.15)
                    {
                        points += 0;
                    }
                    else if(ldlCholesterol < 4.92)
                    {
                        points += 1;
                    }
                    else if(4.92 <= ldlCholesterol)
                    {
                        points += 2;
                    }
                    break;
            }
        }
        //If female
        else
        {
            switch(ldlCholesterolUnit)
            {
                case "mg/dl":
                    if(ldlCholesterol < 100)
                    {
                        points -= 2;
                    }
                    else if(ldlCholesterol < 160)
                    {
                        points += 0;
                    }
                    else if(160 <= ldlCholesterol)
                    {
                        points += 2;
                    }
                    break;
                case "mmol/L":
                    if(ldlCholesterol < 2.59)
                    {
                        points -= 2;
                    }
                    else if(ldlCholesterol < 4.15)
                    {
                        points += 0;
                    }
                    else if(4.15 <= ldlCholesterol)
                    {
                        points += 2;
                    }
                    break;
            }
        }
        return points;
    }
    
    public static int getHdlLdlPoints(boolean male, double hdlCholesterol, String hdlCholesterolUnit)
    {
        int points = 0;
        //If male
        if(male)
        {
            switch (hdlCholesterolUnit) 
            {
                case "mg/dL":
                    if(hdlCholesterol < 35)
                    {
                        points += 2;
                    }
                    else if(hdlCholesterol < 45)
                    {
                        points += 1;
                    }
                    else if(hdlCholesterol < 50)
                    {
                        points += 0;
                    }
                    else if(hdlCholesterol < 60)
                    {
                        points += 0;
                    }
                    else if(60 <= hdlCholesterol)
                    {
                        points -= 1;
                    }
                    break;
                case "mmol/L":
                    if(hdlCholesterol < 0.90)
                    {
                        points += 2;
                    }
                    else if(hdlCholesterol < 1.17)
                    {
                        points += 1;
                    }
                    else if(hdlCholesterol < 1.30)
                    {
                        points += 0;
                    }
                    else if(hdlCholesterol < 1.56)
                    {
                        points += 0;
                    }
                    else if(1.56 <= hdlCholesterol)
                    {
                        points -= 1;
                    }
                    break;
            }
        }
        //If female
        else
        {
            switch (hdlCholesterolUnit) 
            {
                case "mg/dL":
                    if(hdlCholesterol < 35)
                    {
                        points += 5;
                    }
                    else if(hdlCholesterol < 45)
                    {
                        points += 2;
                    }
                    else if(hdlCholesterol < 50)
                    {
                        points += 1;
                    }
                    else if(hdlCholesterol < 60)
                    {
                        points += 0;
                    }
                    else if(60 <= hdlCholesterol)
                    {
                        points -= 2;
                    }
                    break;
                case "mmol/L":
                    if(hdlCholesterol < 0.90)
                    {
                        points += 5;
                    }
                    else if(hdlCholesterol < 1.17)
                    {
                        points += 2;
                    }
                    else if(hdlCholesterol < 1.30)
                    {
                        points += 1;
                    }
                    else if(hdlCholesterol < 1.56)
                    {
                        points += 0;
                    }
                    else if(1.56 <= hdlCholesterol)
                    {
                        points -= 2;
                    }
                    break;
            }
        }
        return points;
    }
    
    /**
     * Smoking results in the same amount of ldl and chol points 
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
    
    /**
     * Age gives same amount of ldl and chol points
     * but it depends on the gender.
     * @param age
     * @param male
     * @return 
     */
    public static int getAgePoints(int age, boolean male)
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
     * Blood pressure gives the same amount of ldl and chol points
     * but it depends on the gender.
     * @param male
     * @param bloodPressure
     * @return 
     */
    public static int getBloodPressurePoints(boolean male, double bloodPressure)
    {
        int points = 0;
        //If male
        if(male)
        { 
            if(bloodPressure < 120)
            {
                points += 0;
            }
            else if(bloodPressure < 130)
            {
                points += 0;
            }
            else if(bloodPressure < 140)
            {
                points += 1;
            }
            else if(bloodPressure < 160)
            {
                points += 2;
            }
            else if(160 <= bloodPressure)
            {
                points += 3;
            }             
        }
        //If female
        else
        {
            if(bloodPressure < 120)
            {
                points -= 3;
            }
            else if(bloodPressure < 130)
            {
                points += 0;
            }
            else if(bloodPressure < 140)
            {
                points += 0;
            }
            else if(bloodPressure < 160)
            {
                points += 2;
            }
            else if(160 <= bloodPressure)
            {
                points += 3;
            }              
        }
        return points;
    }
    
    public static int comparativeRisk(boolean male, int age)
    {
        int comparativeRisk = 0;
        if(male)
        {
            if(age <= 34)
            {
                comparativeRisk = 3;
            }
            else if(age <= 39)
            {
                comparativeRisk = 5;
            }
            else if(age <= 44)
            {
                comparativeRisk = 7;
            }
            else if(age <= 49)
            {
                comparativeRisk = 11;
            }
            else if(age <= 54)
            {
                comparativeRisk = 14;
            }
            else if(age <= 59)
            {
                comparativeRisk = 16;
            }
            else if(age <= 64)
            {
                comparativeRisk = 21;
            }
            else if(age <= 69)
            {
                comparativeRisk = 25;
            }
            else if(age <= 74)
            {
                comparativeRisk = 30;
            }
        }
        else
        {
            if(age <= 39)
            {
                comparativeRisk = 1;
            }
            else if(age <= 44)
            {
                comparativeRisk = 2;
            }
            else if(age <= 49)
            {
                comparativeRisk = 5;
            }
            else if(age <= 54)
            {
                comparativeRisk = 8;
            }
            else if(age <= 64)
            {
                comparativeRisk = 12;
            }
            else if(age <= 69)
            {
                comparativeRisk = 13;
            }
            else if(age <= 74)
            {
                comparativeRisk = 14;
            }
        }
        return comparativeRisk;
    }
    
    public static CSVPatient[] getPatientsFromFile(File[] selectedFiles)
    {
        final int MAX_PATIENTS = 50;
        CSVPatient[] patients = new CSVPatient[MAX_PATIENTS];
        int i = 0;
        
        for(File f: selectedFiles)
        {
            BufferedReader br;
            try 
            {
                br = new BufferedReader(new FileReader(f));
                
                String firstLine = br.readLine(); //read and ignore firstline.
                String nextLine;
                
                while((nextLine = br.readLine()) != null && i < MAX_PATIENTS)
                {
                    CSVPatient p = new CSVPatient(nextLine);
                    
                    patients[i] = p;
                    
                    i++;
                }
            } 
            catch (Exception e) 
            {
                System.err.println("calculateRiskFromFile:: error with file "
                        + f + ": " + e.getMessage());
            }
        }
        return patients;
    }
}
