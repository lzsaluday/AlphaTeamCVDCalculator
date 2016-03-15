/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.model.CSVPatient;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.model.CVDRisk;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.utils.FileChooser;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.view.ApplicationViewer;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.view.RiskCalculatorPanel;

/**
 *
 * @author k1317897
 */
public class RiskCalculatorActionsListener implements ActionListener
{

    private ApplicationViewer frame; 
    private FileChooser fileChooser;
    
    public RiskCalculatorActionsListener(ApplicationViewer frame)
    {
        this.frame = frame;    
    }
    
    public RiskCalculatorActionsListener(ApplicationViewer frame, FileChooser fileChooser)
    {
        this.frame = frame;  
        this.fileChooser = fileChooser;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String command = ae.getActionCommand();
        
        if(command != null)
        {
            switch(command) 
            {
                case "Risk Calculator":
                    frame.switchToRiskCalculatorPanel();
                    break;
                case "Options":
                    frame.exitRiskCaculatorPanel();
                    break;
                case "Upload csv file":
                    int result = fileChooser.showOpenDialog(frame);
                    if (result == FileChooser.APPROVE_OPTION) 
                    {
                        File[] selectedFiles = fileChooser.getSelectedFiles();
                        CSVPatient[] patients = CVDRisk.getPatientsFromFile(selectedFiles);
                        String[] patientNames;
                        int[] patientResults;
                        for(CSVPatient p : patients)
                        {
                            //get age
                            int age = p.getAge();
                            //get male
                            boolean male = p.isMale();
                            //get smoker
                            boolean smoker = p.isSmoker();
                            //get diabetes
                            boolean diabetes = p.isDiabetes();
                            //get blood pressure (Systolic)
                            double bloodPressure = p.getBloodPressure();
                            //get hdl cholesterol value
                            double hdlCholesterol = p.getHdlCholesterolValue();
                            //get hdl cholesterol unit (mg/dL or mmol/L)
                            String hdlCholesterolUnit = p.getHdlCholesterolUnit();
                            //get total cholesterol value
                            double cholesterol = p.getCholesterolValue();
                            //get total cholesterol unit (mg/dL or mmol/L)
                            String cholesterolUnit = p.getCholesterolUnit();
                            //get cholesterol type: Total/LDL
                            String cholesterolType = p.getCholesterolType();
                            
                            switch(cholesterolType)
                            {
                                case "Total Cholesterol":
                                    int cholPoints = CVDRisk.calculateCholPoints(age, male,
                                        smoker, diabetes,
                                        bloodPressure,
                                        cholesterol, cholesterolUnit,
                                        hdlCholesterol, hdlCholesterolUnit);
                                    p.setCvdRisk(CVDRisk.calculateCVDRiskWithChol(male, cholPoints));
                                    break;
                                case "LDL Cholesterol":
                                    
                                    break;                               
                            }
                        }
                    }
                    break;
                case "Calculate":
                    //get age
                    int age = RiskCalculatorPanel.getAgeAsInt();
                    //get male
                    boolean male = RiskCalculatorPanel.getMaleBoolean();
                    //get smoker
                    boolean smoker = RiskCalculatorPanel.getSmokerBoolean();
                    //get diabetes
                    boolean diabetes = RiskCalculatorPanel.getDiabetesBoolean();
                    //get blood pressure (Systolic)
                    double bloodPressure = RiskCalculatorPanel.getBloodPressureAsDouble();
                    //get hdl cholesterol value
                    double hdlCholesterol = RiskCalculatorPanel.getHDLCholesterolAsDouble();
                    //get hdl cholesterol unit (mg/dL or mmol/L)
                    String hdlCholesterolUnit = RiskCalculatorPanel.getHDLCholesterolUnit();
                    //get total cholesterol value
                    double cholesterol = RiskCalculatorPanel.getcholesterolAsDouble();
                    //get total cholesterol unit (mg/dL or mmol/L)
                    String cholesterolUnit = RiskCalculatorPanel.getCholesterolUnit();
                    //get cholesterol type: Total/LDL
                    String cholesterolType = RiskCalculatorPanel.getCholesterolType();
                    int cvdRisk = 0;
                    
                    switch (cholesterolType) 
                    {
                        case "Total Cholesterol":
                            int cholPoints = CVDRisk.calculateCholPoints(age, male,
                                smoker, diabetes,
                                bloodPressure,
                                cholesterol, cholesterolUnit,
                                hdlCholesterol, hdlCholesterolUnit);
                            cvdRisk = CVDRisk.calculateCVDRiskWithChol(male, cholPoints);
                            break;
                        case "LDL Cholesterol":
                            int ldlPoints = CVDRisk.calculateLDLPoints(age, male,
                                smoker, diabetes, bloodPressure,
                                cholesterol, cholesterolUnit,
                                hdlCholesterol, hdlCholesterolUnit);
                            cvdRisk = CVDRisk.calculateCVDRiskWithLDL(male, ldlPoints);
                            break;
                    }
                    int comparativeRisk = CVDRisk.comparativeRisk(male, age);
                    frame.switchToRiskResultPanel(cvdRisk, comparativeRisk);
                    break;
                case "Clear":
                    RiskCalculatorPanel.clear();
                    break;
            }
        }
    }
    
}
