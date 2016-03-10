/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author k1317131
 */
public class CVDRiskTest {
    
    public CVDRiskTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateCholPoints method, of class CVDRisk.
     */
    @Test
    public void testCalculateCholPoints() {
        System.out.println("calculateLDLPoints");
        
        boolean male;
        int age;
        double bloodPressure;
        double totalCholesterol;
        String totalCholesterolUnit;
        double hdlCholesterol;
        String hdlCholesterolUnit;
        boolean diabetes;
        boolean smoker;
        int result;
        int expResult;
        
        //Test 1 M
        //mg/dl, smoker, diabetes
        System.out.println("Test 1 M");
        male = true;
        age = 32;
        bloodPressure = 132;
        totalCholesterol = 230;
        totalCholesterolUnit = "mg/dL";
        hdlCholesterol = 55;
        hdlCholesterolUnit = "mg/dL";
        diabetes = true;
        smoker = true;
        result = CVDRisk.calculateCholPoints(age, male, smoker, diabetes, bloodPressure, totalCholesterol, totalCholesterolUnit, hdlCholesterol, hdlCholesterolUnit);
        expResult = 5;
        assertEquals(expResult, result);
        
        //Test 1 F
        //mg/dl, smoker, diabetes
        System.out.println("Test 1 F");
        male = false;
        age = 32;
        bloodPressure = 132;
        totalCholesterol = 230;
        totalCholesterolUnit = "mg/dL";
        hdlCholesterol = 55;
        hdlCholesterolUnit = "mg/dL";
        diabetes = true;
        smoker = true;
        result = CVDRisk.calculateCholPoints(age, male, smoker, diabetes, bloodPressure, totalCholesterol, totalCholesterolUnit, hdlCholesterol, hdlCholesterolUnit);
        expResult = -2;
        assertEquals(expResult, result);
        
        //Test 2 M
        //mmol/L, smoker, diabetes
        System.out.println("Test 2 M");
        male = true;
        age = 32;
        bloodPressure = 132;
        totalCholesterol = 5.16;
        totalCholesterolUnit = "mmol/L";
        hdlCholesterol = 0.98;
        hdlCholesterolUnit = "mmol/L";
        diabetes = true;
        smoker = true;
        result = CVDRisk.calculateCholPoints(age, male, smoker, diabetes, bloodPressure, totalCholesterol, totalCholesterolUnit, hdlCholesterol, hdlCholesterolUnit);
        expResult = 5;
        assertEquals(expResult, result);
        
        //Test 2 F
        //mmol/L, smoker, diabetes
        System.out.println("Test 2 F");
        male = false;
        age = 32;
        bloodPressure = 132;
        totalCholesterol = 5.16;
        totalCholesterolUnit = "mmol/L";
        hdlCholesterol = 0.98;
        hdlCholesterolUnit = "mmol/L";
        diabetes = true;
        smoker = true;
        result = CVDRisk.calculateCholPoints(age, male, smoker, diabetes, bloodPressure, totalCholesterol, totalCholesterolUnit, hdlCholesterol, hdlCholesterolUnit);
        expResult = -1;
        assertEquals(expResult, result);
        
        //Test 3 M
        //mg/dl, diabetes
        System.out.println("Test 3 M");
        male = true;
        age = 32;
        bloodPressure = 132;
        totalCholesterol = 230;
        totalCholesterolUnit = "mg/dL";
        hdlCholesterol = 55;
        hdlCholesterolUnit = "mg/dL";
        diabetes = true;
        smoker = false;
        result = CVDRisk.calculateCholPoints(age, male, smoker, diabetes, bloodPressure, totalCholesterol, totalCholesterolUnit, hdlCholesterol, hdlCholesterolUnit);
        expResult = 3;
        assertEquals(expResult, result);
        
        //Test 3 F
        //mg/dl, diabetes
        System.out.println("Test 3 M");
        male = false;
        age = 32;
        bloodPressure = 132;
        totalCholesterol = 230;
        totalCholesterolUnit = "mg/dL";
        hdlCholesterol = 55;
        hdlCholesterolUnit = "mg/dL";
        diabetes = true;
        smoker = false;
        result = CVDRisk.calculateCholPoints(age, male, smoker, diabetes, bloodPressure, totalCholesterol, totalCholesterolUnit, hdlCholesterol, hdlCholesterolUnit);
        expResult = -4;
        assertEquals(expResult, result);
        
        //Test 4 M
        //mg/dl, smoker
        System.out.println("Test 4 M");
        male = true;
        age = 32;
        bloodPressure = 132;
        totalCholesterol = 230;
        totalCholesterolUnit = "mg/dL";
        hdlCholesterol = 55;
        hdlCholesterolUnit = "mg/dL";
        diabetes = false;
        smoker = true;
        result = CVDRisk.calculateCholPoints(age, male, smoker, diabetes, bloodPressure, totalCholesterol, totalCholesterolUnit, hdlCholesterol, hdlCholesterolUnit);
        expResult = 3;
        assertEquals(expResult, result);

        //Test 4 F
        //mg/dl, smoker
        System.out.println("Test 4 F");
        male = false;
        age = 32;
        bloodPressure = 132;
        totalCholesterol = 230;
        totalCholesterolUnit = "mg/dL";
        hdlCholesterol = 55;
        hdlCholesterolUnit = "mg/dL";
        diabetes = false;
        smoker = true;
        result = CVDRisk.calculateCholPoints(age, male, smoker, diabetes, bloodPressure, totalCholesterol, totalCholesterolUnit, hdlCholesterol, hdlCholesterolUnit);
        expResult = -6;
        assertEquals(expResult, result);
        
        //Test 5 M
        //mg/dl
        System.out.println("Test 5 M");
        male = true;
        age = 32;
        bloodPressure = 132;
        totalCholesterol = 230;
        totalCholesterolUnit = "mg/dL";
        hdlCholesterol = 55;
        hdlCholesterolUnit = "mg/dL";
        diabetes = false;
        smoker = false;
        result = CVDRisk.calculateCholPoints(age, male, smoker, diabetes, bloodPressure, totalCholesterol, totalCholesterolUnit, hdlCholesterol, hdlCholesterolUnit);
        expResult = 1;
        assertEquals(expResult, result);
        
        //Test 5 F
        //mg/dl
        System.out.println("Test 5 F");
        male = false;
        age = 32;
        bloodPressure = 132;
        totalCholesterol = 230;
        totalCholesterolUnit = "mg/dL";
        hdlCholesterol = 55;
        hdlCholesterolUnit = "mg/dL";
        diabetes = false;
        smoker = false;
        result = CVDRisk.calculateCholPoints(age, male, smoker, diabetes, bloodPressure, totalCholesterol, totalCholesterolUnit, hdlCholesterol, hdlCholesterolUnit);
        expResult = -8;
        assertEquals(expResult, result);
        
        //Test 6 M
        //mg/dl
        System.out.println("Test 6 M");
        male = true;
        age = 32;
        bloodPressure = 155;
        totalCholesterol = 230;
        totalCholesterolUnit = "mg/dL";
        hdlCholesterol = 55;
        hdlCholesterolUnit = "mg/dL";
        diabetes = false;
        smoker = false;
        result = CVDRisk.calculateCholPoints(age, male, smoker, diabetes, bloodPressure, totalCholesterol, totalCholesterolUnit, hdlCholesterol, hdlCholesterolUnit);
        expResult = 2;
        assertEquals(expResult, result);
        
        //Test 6 F
        //mg/dl
        System.out.println("Test 6 F");
        male = false;
        age = 32;
        bloodPressure = 155;
        totalCholesterol = 230;
        totalCholesterolUnit = "mg/dL";
        hdlCholesterol = 55;
        hdlCholesterolUnit = "mg/dL";
        diabetes = false;
        smoker = false;
        result = CVDRisk.calculateCholPoints(age, male, smoker, diabetes, bloodPressure, totalCholesterol, totalCholesterolUnit, hdlCholesterol, hdlCholesterolUnit);
        expResult = -6;
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of calculateCVDRiskWithChol method, of class CVDRisk.
     */
    @Test
    public void testCalculateCVDRiskWithChol() {
        System.out.println("calculateCVDRiskWithChol");
        boolean male = true;
        int cholPoints = 5;
        int expResult = 8;
        int result = CVDRisk.calculateCVDRiskWithChol(male, cholPoints);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCholesterolCholPoints method, of class CVDRisk.
     */
    @Test
    public void testGetCholesterolCholPoints() {
        System.out.println("getCholesterolCholPoints");
        boolean male = true;
        double totalCholesterol = 230;
        String totalCholesterolUnit = "mg/dL";
        int expResult = 1;
        int result = CVDRisk.getCholesterolCholPoints(male, totalCholesterol, totalCholesterolUnit);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHDLCholPoints method, of class CVDRisk.
     */
    @Test
    public void testGetHDLCholPoints() {
        System.out.println("getHDLCholPoints");
        boolean male = true;
        double hdlCholesterol = 55;
        String hdlCholesterolUnit = "mg/dL";
        int expResult = 0;
        int result = CVDRisk.getHDLCholPoints(male, hdlCholesterol, hdlCholesterolUnit);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateLDLPoints method, of class CVDRisk.
     */
    @Test
    public void testCalculateLDLPoints() {
        System.out.println("calculateLDLPoints");
        
        boolean male;
        int age;
        double bloodPressure;
        double ldlCholesterol;
        String ldlCholesterolUnit;
        double hdlCholesterol;
        String hdlCholesterolUnit;
        boolean diabetes;
        boolean smoker;
        int result;
        int expResult;
        
        //Test 1 M
        //mg/dl, smoker, diabetes
        System.out.println("Test 1 M");
        male = true;
        age = 32;
        ldlCholesterol = 120;
        ldlCholesterolUnit = "mg/dL";
        hdlCholesterol = 55;
        hdlCholesterolUnit = "mg/dL";
        bloodPressure = 132;
        diabetes = true;
        smoker = true;
        result = CVDRisk.calculateLDLPoints(age, male, smoker, diabetes, bloodPressure, ldlCholesterol, ldlCholesterolUnit, hdlCholesterol, hdlCholesterolUnit);
        expResult = 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateCVDRiskWithLDL method, of class CVDRisk.
     */
    @Test
    public void testCalculateCVDRiskWithLDL() {
        System.out.println("calculateCVDRiskWithLDL");
        boolean male = true;
        int ldlPoints = 4;
        int expResult = 7;
        int result = CVDRisk.calculateCVDRiskWithLDL(male, ldlPoints);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLDLCholesterolPoints method, of class CVDRisk.
     */
    @Test
    public void testGetLDLCholesterolPoints() {
        System.out.println("getLDLCholesterolPoints");
        boolean male = true;
        double ldlCholesterol = 120;
        String ldlCholesterolUnit = "mg/dL";
        int expResult = 0;
        int result = CVDRisk.getLDLCholesterolPoints(male, ldlCholesterol, ldlCholesterolUnit);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHdlLdlPoints method, of class CVDRisk.
     */
    @Test
    public void testGetHdlLdlPoints() {
        System.out.println("getHdlLdlPoints");
        boolean male = true;
        double hdlCholesterol = 55;
        String hdlCholesterolUnit = "mg/dL";
        int expResult = 0;
        int result = CVDRisk.getHdlLdlPoints(male, hdlCholesterol, hdlCholesterolUnit);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSmokerPoints method, of class CVDRisk.
     */
    @Test
    public void testGetSmokerPoints() {
        System.out.println("getSmokerPoints");
        boolean smoker = true;
        int expResult = 2;
        int result = CVDRisk.getSmokerPoints(smoker);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDiabetesPoints method, of class CVDRisk.
     */
    @Test
    public void testGetDiabetesPoints() {
        System.out.println("getDiabetesPoints");
        boolean diabetes = true;
        boolean male = true;
        int expResult = 2;
        int result = CVDRisk.getDiabetesPoints(diabetes, male);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAgePoints method, of class CVDRisk.
     */
    @Test
    public void testGetAgePoints() {
        System.out.println("getAgePoints");
        int age = 32;
        boolean male = true;
        int expResult = -1;
        int result = CVDRisk.getAgePoints(age, male);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBloodPressurePoints method, of class CVDRisk.
     */
    @Test
    public void testGetBloodPressurePoints() {
        System.out.println("getBloodPressurePoints");
        boolean male = true;
        double bloodPressure = 132;
        int expResult = 1;
        int result = CVDRisk.getBloodPressurePoints(male, bloodPressure);
        assertEquals(expResult, result);
    }

    /**
     * Test of comparativeRisk method, of class CVDRisk.
     */
    /*
    @Test
    public void testComparativeRisk() {
        System.out.println("comparativeRisk");
        boolean male = false;
        int age = 0;
        int expResult = 0;
        int result = CVDRisk.comparativeRisk(male, age);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
}
