/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.*;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.controller.ClinicianActionsListener;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.controller.PatientActionsListener;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.controller.RiskCalculatorActionsListener;

/**
 *
 * @author k1317897
 */
public class ApplicationMainPanel extends JPanel{
    
    public JPanel mainMenuButtons;
    private JButton riskCalculatorButton; 
    private JButton patientButton;
    private JButton clinicianButton;
    private ImageIcon riskCalculatorButtonIcon;
    private ImageIcon patientButtonIcon;
    private ImageIcon clinicianButtonIcon;
    private final ApplicationViewer frame;
    
    public ApplicationMainPanel(ApplicationViewer frame)
    {
        this.frame = frame;
        setApplicationMainMenu();
    }
    
    public void setApplicationMainMenu() {
        
        mainMenuButtons = new JPanel(new GridBagLayout());
        mainMenuButtons.setBackground(Color.LIGHT_GRAY);
        
        riskCalculatorButtonIcon = new ImageIcon(this.getClass().getResource("icons/hdrc.png"));
        riskCalculatorButton = new JButton("Risk Calculator", riskCalculatorButtonIcon);
        riskCalculatorButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        riskCalculatorButton.setHorizontalTextPosition(SwingConstants.CENTER);
        riskCalculatorButton.setFont(new Font("Calibri", Font.BOLD, 30));
        riskCalculatorButton.setContentAreaFilled(false);
        
        patientButtonIcon = new ImageIcon(this.getClass().getResource("icons/patient_icon.jpg"));
        patientButton = new JButton("Patient", patientButtonIcon);
        patientButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        patientButton.setHorizontalTextPosition(SwingConstants.CENTER);
        patientButton.setFont(new Font("Calibri", Font.BOLD, 30));
        patientButton.setContentAreaFilled(false);
        
        
        clinicianButtonIcon = new ImageIcon(this.getClass().getResource("icons/doctor-icon.png"));
        clinicianButton = new JButton("Clinician", clinicianButtonIcon);
        clinicianButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        clinicianButton.setHorizontalTextPosition(SwingConstants.CENTER);
        clinicianButton.setFont(new Font("Calibri", Font.BOLD, 30));
        clinicianButton.setContentAreaFilled(false);
        
        riskCalculatorButton.addActionListener(new RiskCalculatorActionsListener(frame));
        patientButton.addActionListener(new PatientActionsListener(frame));
        clinicianButton.addActionListener(new ClinicianActionsListener(frame));
        
        mainMenuButtons.add(riskCalculatorButton);
        mainMenuButtons.add(Box.createHorizontalStrut(15));
        mainMenuButtons.add(patientButton);
        mainMenuButtons.add(Box.createHorizontalStrut(15));
        mainMenuButtons.add(clinicianButton);
        
        
        frame.add(mainMenuButtons);
        
    }
    
    
}
