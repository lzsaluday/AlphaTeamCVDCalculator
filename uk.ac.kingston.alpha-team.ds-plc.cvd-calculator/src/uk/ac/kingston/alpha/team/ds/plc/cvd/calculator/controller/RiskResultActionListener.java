/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.model.CVDRisk;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.utils.FileChooser;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.view.ApplicationViewer;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.view.RiskResultPanel;

/**
 *
 * @author k1357811
 */
public class RiskResultActionListener implements ActionListener
{
    private ApplicationViewer frame; 
    
    private FileChooser fileChooser;
    
    public RiskResultActionListener(ApplicationViewer frame)
    {
        this.frame = frame;
    }
    
    public RiskResultActionListener(ApplicationViewer frame, FileChooser fileChooser)
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
                case("Save"):
                    int result = fileChooser.showSaveDialog(frame);
                    break;
                case("Back"):
                    frame.exitRiskResultPanel();
                    break;
            }
        }
    }
    
}
