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
        System.out.println("calculateCholPoints");
        int age = 42;
        boolean male = true;
        boolean smoker = true;
        boolean diabetes = true;
        double bloodPressure = 120.0;
        double totalCholesterol = 165.0;
        String totalCholesterolUnit = "mg/dL";
        double hdlCholesterol = 37.0;
        String hdlCholesterolUnit = "mg/dL";
        int expResult = 5;
        int result = CVDRisk.calculateCholPoints(age, male, smoker, diabetes, bloodPressure, totalCholesterol, totalCholesterolUnit, hdlCholesterol, hdlCholesterolUnit);
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
        boolean male = false;
        double totalCholesterol = 0.0;
        String totalCholesterolUnit = "";
        int expResult = 0;
        int result = CVDRisk.getCholesterolCholPoints(male, totalCholesterol, totalCholesterolUnit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHDLCholPoints method, of class CVDRisk.
     */
    @Test
    public void testGetHDLCholPoints() {
        System.out.println("getHDLCholPoints");
        boolean male = false;
        double hdlCholesterol = 0.0;
        String hdlCholesterolUnit = "";
        int expResult = 0;
        int result = CVDRisk.getHDLCholPoints(male, hdlCholesterol, hdlCholesterolUnit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateLDLPoints method, of class CVDRisk.
     */
    @Test
    public void testCalculateLDLPoints() {
        System.out.println("calculateLDLPoints");
        int age = 0;
        boolean male = false;
        boolean smoker = false;
        boolean diabetes = false;
        double bloodPressure = 0.0;
        double ldlCholesterol = 0.0;
        String ldlCholesterolUnit = "";
        double hdlCholesterol = 0.0;
        String hdlCholesterolUnit = "";
        int expResult = 0;
        int result = CVDRisk.calculateLDLPoints(age, male, smoker, diabetes, bloodPressure, ldlCholesterol, ldlCholesterolUnit, hdlCholesterol, hdlCholesterolUnit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateCVDRiskWithLDL method, of class CVDRisk.
     */
    @Test
    public void testCalculateCVDRiskWithLDL() {
        System.out.println("calculateCVDRiskWithLDL");
        boolean male = false;
        int ldlPoints = 0;
        int expResult = 0;
        int result = CVDRisk.calculateCVDRiskWithLDL(male, ldlPoints);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLDLCholesterolPoints method, of class CVDRisk.
     */
    @Test
    public void testGetLDLCholesterolPoints() {
        System.out.println("getLDLCholesterolPoints");
        boolean male = false;
        double ldlCholesterol = 0.0;
        String ldlCholesterolUnit = "";
        int expResult = 0;
        int result = CVDRisk.getLDLCholesterolPoints(male, ldlCholesterol, ldlCholesterolUnit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHdlLdlPoints method, of class CVDRisk.
     */
    @Test
    public void testGetHdlLdlPoints() {
        System.out.println("getHdlLdlPoints");
        boolean male = false;
        double hdlCholesterol = 0.0;
        String hdlCholesterolUnit = "";
        int expResult = 0;
        int result = CVDRisk.getHdlLdlPoints(male, hdlCholesterol, hdlCholesterolUnit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSmokerPoints method, of class CVDRisk.
     */
    @Test
    public void testGetSmokerPoints() {
        System.out.println("getSmokerPoints");
        boolean smoker = false;
        int expResult = 0;
        int result = CVDRisk.getSmokerPoints(smoker);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiabetesPoints method, of class CVDRisk.
     */
    @Test
    public void testGetDiabetesPoints() {
        System.out.println("getDiabetesPoints");
        boolean diabetes = false;
        boolean male = false;
        int expResult = 0;
        int result = CVDRisk.getDiabetesPoints(diabetes, male);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAgePoints method, of class CVDRisk.
     */
    @Test
    public void testGetAgePoints() {
        System.out.println("getAgePoints");
        int age = 0;
        boolean male = false;
        int expResult = 0;
        int result = CVDRisk.getAgePoints(age, male);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBloodPressurePoints method, of class CVDRisk.
     */
    @Test
    public void testGetBloodPressurePoints() {
        System.out.println("getBloodPressurePoints");
        boolean male = false;
        double bloodPressure = 0.0;
        int expResult = 0;
        int result = CVDRisk.getBloodPressurePoints(male, bloodPressure);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comparativeRisk method, of class CVDRisk.
     */
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
    
}
