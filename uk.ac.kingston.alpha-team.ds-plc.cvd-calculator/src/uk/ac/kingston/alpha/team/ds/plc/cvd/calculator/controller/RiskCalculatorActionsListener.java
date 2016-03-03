/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.model.CVDRisk;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.view.ApplicationViewer;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.view.RiskCalculatorPanel;

/**
 *
 * @author k1317897
 */
public class RiskCalculatorActionsListener implements ActionListener{

    private ApplicationViewer frame; 
    
    public RiskCalculatorActionsListener(ApplicationViewer frame)
    {
     this.frame = frame;    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        
        if(command != null)
        {
            switch(command) 
            {
                case "Risk Calculator":
                    frame.switchToRiskCalculatorPanel();
                    break;
                case "Back to Main Menu":
                    frame.exitRiskCaculator();
                    break;
                case "Calculate":
                    int age = RiskCalculatorPanel.getAgeAsInt();
                    boolean male = RiskCalculatorPanel.getMaleBoolean();
                    int cholPoints = CVDRisk.calculateCholPoints(age, male, true, true, bloodPressure, command, totalCholesterol, command, hdlCholesterol, command);
                    CVDRisk.calculateCVDRiskWithChol(cholPoints);
                    break;
                case "Clear":
                    break;
            }
        }
    }
    
}
