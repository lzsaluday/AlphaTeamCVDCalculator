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
public class CSVPatient 
{
    private String name;
    private int age;
    private boolean male;
    private boolean smoker;
    private boolean diabetes;
    private double bloodPressure;
    private String cholesterolType;
    private double cholesterolValue;
    private String cholesterolUnit;
    private double hdlCholesterolValue;
    private String hdlCholesterolUnit;
    private int cvdRisk;
    
    public CSVPatient()
    {
        
    }
    
    public CSVPatient(String csvString)
    {
        String[] attributes = csvString.split(",");
        int i =0;
        for(String s: attributes)
        {
            switch(i)
            {
                case 0:
                    this.name = s;
                    break;
                case 1:
                    this.age = Integer.parseInt(s);
                    break;
                case 2:
                    this.male = getMaleBoolean(s);
                    break;
                case 3:
                    this.smoker = getSmokerBoolean(s);
                    break;
                case 4: 
                    this.diabetes = getDiabetesBoolean(s);
                    break;
                case 5:
                    this.bloodPressure = Double.parseDouble(s);
                    break;
                case 6:
                    this.cholesterolType = s;
                    break;
                case 7:
                    this.cholesterolValue = Double.parseDouble(s);
                    break;
                case 8:
                    this.cholesterolUnit = s;
                    break;
                case 9:
                    this.hdlCholesterolValue = Double.parseDouble(s);
                    break;
                case 10:
                    this.hdlCholesterolUnit = s;
            }
            i++;
        }
        this.cvdRisk = 0;
        
    }
    
    public static boolean getMaleBoolean(String s)
    {
        boolean male = true;
        switch(s)
        {
            case "Male":
                male = true;
                break;
            case "Female":
                male = false;
        }
        return male;
    }
    
    public static boolean getSmokerBoolean(String s)
    {
        boolean smoker = true;
        switch(s)
        {
            case "Yes":
                smoker = true;
                break;
            case "No":
                smoker = false;
        }
        return smoker;
    }
    
    public static boolean getDiabetesBoolean(String s)
    {
        boolean diabetes = true;
        switch(s)
        {
            case "Yes":
                diabetes = true;
                break;
            case "No":
                diabetes = false;
        }
        return diabetes;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getCholesterolType() {
        return cholesterolType;
    }

    public void setCholesterolType(String cholesterolType) {
        this.cholesterolType = cholesterolType;
    }

    public double getCholesterolValue() {
        return cholesterolValue;
    }

    public void setCholesterolValue(double cholesterolValue) {
        this.cholesterolValue = cholesterolValue;
    }

    public String getCholesterolUnit() {
        return cholesterolUnit;
    }

    public void setCholesterolUnit(String cholesterolUnit) {
        this.cholesterolUnit = cholesterolUnit;
    }

    public double getHdlCholesterolValue() {
        return hdlCholesterolValue;
    }

    public void setHdlCholesterolValue(double hdlCholesterolValue) {
        this.hdlCholesterolValue = hdlCholesterolValue;
    }

    public String getHdlCholesterolUnit() {
        return hdlCholesterolUnit;
    }

    public void setHdlCholesterolUnit(String hdlCholesterolUnit) {
        this.hdlCholesterolUnit = hdlCholesterolUnit;
    }
    
    public int getCvdRisk() {
        return cvdRisk;
    }

    public void setCvdRisk(int cvdRisk) {
        this.cvdRisk = cvdRisk;
    }
    
    //Print Method
    @Override
    public String toString()
    {
       
        return getName() + "\t" +
               getAge() + "\t" +
               isMale() + "\t" +
               isSmoker() + "\t" +
               isDiabetes() + "\t" +
               getCvdRisk() + "\n";
    
    }  
}
