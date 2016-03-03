/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.controller.RiskCalculatorActionsListener;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.controller.RiskResultActionListener;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.model.CVDRisk;

/**
 *
 * @author k1357811
 */
public final class RiskResultPanel extends JPanel 
{
    public JPanel riskResultPanel;
    
     //JLabels
    private JLabel riskLabel;
    private JLabel comparativeLabel;
    
    private JButton saveButton;
    private JButton backButton;
    
    private final ApplicationViewer frame;
    
     public RiskResultPanel(ApplicationViewer frame, int cvdRisk, int comparativeRisk)
    {
        this.frame = frame;
        createRiskResultPanel(cvdRisk, comparativeRisk);
    }

    private void createRiskResultPanel(int cvdRisk, int comparativeRisk) 
    {
        riskResultPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        
        riskLabel = new JLabel("Your CVD risk in the next 10 years is: " + cvdRisk + " %");
        riskLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        riskResultPanel.add(riskLabel, constraints);
        
        comparativeLabel = new JLabel("The average CHD risk for persons your age is: " + comparativeRisk + " %");
        comparativeLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        riskResultPanel.add(comparativeLabel, constraints);
        
        //Buttons
        saveButton = new JButton("Save");
        saveButton.setContentAreaFilled(false);
        saveButton.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        riskResultPanel.add(saveButton, constraints);
        saveButton.addActionListener(new RiskResultActionListener(this.frame));
 
        backButton = new JButton("Back");
        backButton.setContentAreaFilled(false);
        backButton.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        riskResultPanel.add(backButton, constraints);
        backButton.addActionListener(new RiskResultActionListener(this.frame));
        
        frame.add(riskResultPanel);
    }
}
