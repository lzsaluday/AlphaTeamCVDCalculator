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
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.utils.FileChooser;

/**
 *
 * @author k1317897
 */
public final class RiskCalculatorPanel extends JPanel 
{    
    public JPanel riskCalculatorPanel;
    
    //JLabels
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JLabel smokerLabel;
    private JLabel diabetesLabel;
    private JLabel bloodPressureLabel;
    private JLabel HDLCholesterolLabel;
    
    //JTextFields
    private static JTextField ageTextField;
    private static JTextField bloodPressureTextField;
    private static JTextField cholesterolTextField;
    private static JTextField HDLCholesterolTextField;
    
    //JComboBoxes
    private static JComboBox genderComboBox;
    private static JComboBox smokingComboBox;
    private static JComboBox diabetesComboBox;
    private static JComboBox cholesterolUnitComboBox;
    private static JComboBox HDLCholesterolUnitComboBox;
    private static JComboBox cholesterolTypeComboBox;
    
    //ComboBox options
    private final String[] genderStatusOptions = {"Male","Female"};
    private final String[] smokingStatusOptions = {"Yes", "No"};
    private final String[] diabetesStatusOptions = {"Yes", "No"};
    private final String[] cholesterolUnitOptions = {"mg/dL", "mmol/L"};
    private final String[] cholesterolTypeOptions = {"Total Cholesterol", "LDL Cholesterol"};
    
    private JButton calculateRiskButton; 
    private JButton clearButton;
    private JButton optionsButton;
    private JButton uploadButton;
    private final ApplicationViewer frame;
    private final FileChooser fileChooser;
    
    public RiskCalculatorPanel(ApplicationViewer frame, FileChooser fileChooser)
    {
        this.frame = frame;
        this.fileChooser = fileChooser;
        createRiskCalculatorPanel();
    }
    
    public void createRiskCalculatorPanel()
    {
        riskCalculatorPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
 
        constraints.fill = GridBagConstraints.HORIZONTAL;
 
        ImageIcon imageicon = new ImageIcon(this.getClass().getResource("icons/cardiology.png"));
        JLabel iconLabel = new JLabel("", imageicon, JLabel.CENTER);
        JLabel textLabel = new JLabel("Calculate Your Risk of Cardiovascular Disease", JLabel.CENTER);
        textLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        riskCalculatorPanel.add(iconLabel);
        riskCalculatorPanel.add(textLabel);
        
        ageLabel = new JLabel("Age(30-74): ");
        ageLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(ageLabel, constraints);
 
        ageTextField = new JTextField(20);
        ageTextField.setFont(new Font("Calibri", Font.BOLD, 18));
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(ageTextField, constraints);
        
        genderLabel = new JLabel("Gender: ");
        genderLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(genderLabel, constraints);
        
        genderComboBox = new JComboBox(genderStatusOptions);
        genderComboBox.setFont(new Font("Calibri", Font.BOLD, 15));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(genderComboBox, constraints);
 
        smokerLabel = new JLabel("Do you smoke? ");
        smokerLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(smokerLabel, constraints);
 
        smokingComboBox = new JComboBox(smokingStatusOptions);
        smokingComboBox.setFont(new Font("Calibri", Font.BOLD, 15));
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(smokingComboBox, constraints);
        
        diabetesLabel = new JLabel("Do you have Diabetes? ");
        diabetesLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(diabetesLabel, constraints);
 
        diabetesComboBox = new JComboBox(diabetesStatusOptions);
        diabetesComboBox.setFont(new Font("Calibri", Font.BOLD, 15));
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(diabetesComboBox, constraints);
        
        bloodPressureLabel = new JLabel("Systolic Blood Pressure(mm Hg): ");
        bloodPressureLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(bloodPressureLabel, constraints);
 
        bloodPressureTextField = new JTextField(20);
        bloodPressureTextField.setFont(new Font("Calibri", Font.BOLD, 18));
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(bloodPressureTextField, constraints);
 
        cholesterolTypeComboBox = new JComboBox(cholesterolTypeOptions);
        cholesterolTypeComboBox.setFont(new Font("Calibri", Font.BOLD, 15));
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(cholesterolTypeComboBox, constraints);
 
        cholesterolTextField = new JTextField(20);
        cholesterolTextField.setFont(new Font("Calibri", Font.BOLD, 18));
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(cholesterolTextField, constraints);
        
        cholesterolUnitComboBox = new JComboBox(cholesterolUnitOptions);
        cholesterolUnitComboBox.setFont(new Font("Calibri", Font.BOLD, 15));
        constraints.gridx = 2;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(cholesterolUnitComboBox, constraints);
        
        HDLCholesterolLabel = new JLabel("HDL Cholesterol: ");
        HDLCholesterolLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(HDLCholesterolLabel, constraints);
 
        HDLCholesterolTextField = new JTextField(20);
        HDLCholesterolTextField.setFont(new Font("Calibri", Font.BOLD, 18));
        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(HDLCholesterolTextField, constraints);
        
        HDLCholesterolUnitComboBox = new JComboBox(cholesterolUnitOptions);
        HDLCholesterolUnitComboBox.setFont(new Font("Calibri", Font.BOLD, 15));
        constraints.gridx = 2;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        riskCalculatorPanel.add(HDLCholesterolUnitComboBox, constraints);
        
        //Buttons
        calculateRiskButton = new JButton("Calculate");
        calculateRiskButton.setContentAreaFilled(false);
        calculateRiskButton.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 1;
        constraints.gridy = 8;
        constraints.gridwidth = 0;
        riskCalculatorPanel.add(calculateRiskButton, constraints);
        calculateRiskButton.addActionListener(new RiskCalculatorActionsListener(this.frame));
 
        clearButton = new JButton("Clear");
        clearButton.setContentAreaFilled(false);
        clearButton.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 1;
        constraints.gridy = 9;
        constraints.gridwidth = 0;
        riskCalculatorPanel.add(clearButton, constraints);
        clearButton.addActionListener(new RiskCalculatorActionsListener(this.frame)); 
        
        optionsButton = new JButton("Options");
        optionsButton.setContentAreaFilled(false);
        optionsButton.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 1;
        constraints.gridy = 10;
        constraints.gridwidth = 0;
        riskCalculatorPanel.add(optionsButton, constraints);
        optionsButton.addActionListener(new RiskCalculatorActionsListener(this.frame)); 
        
        uploadButton = new JButton("Upload csv file");
        uploadButton.setContentAreaFilled(false);
        uploadButton.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 1;
        constraints.gridy = 11;
        constraints.gridwidth = 0;
        riskCalculatorPanel.add(uploadButton, constraints);
        uploadButton.addActionListener(new RiskCalculatorActionsListener(this.frame,this.fileChooser));
        
        frame.add(riskCalculatorPanel);
    }

    public static String getAge()
    {
        return ageTextField.getText().trim();
    }
    
    public static int getAgeAsInt()
    {
        return Integer.parseInt(getAge());
    }
    
    public static String getGenderStatus()
    {
        return (String) genderComboBox.getSelectedItem();
    }
    
    public static boolean getMaleBoolean()
    {
        String gender;
        boolean male = false;
        gender = getGenderStatus();
        if(!gender.equals(""))
        {
            switch(gender)
            {
                case "Male":
                    male = true;
                    break;
                case "Female":
                    male = false;
                    break;
            }
        }
        else
        {
            
        }
        return male;
    }
    
    public static String getSmokingStatus() 
    {
        return (String) smokingComboBox.getSelectedItem();
    }
    
    public static boolean getSmokerBoolean()
    {
        String smokingStatus = getSmokingStatus();;
        boolean smoker = false;
        if(!smokingStatus.equals(""))
        {
            switch(smokingStatus)
            {
                case "Yes":
                    smoker = true;
                    break;
                case "No":
                    smoker = false;
                    break;
            }
        }
        else
        {
            
        }
        return smoker;
    }
       
    public static String getDiabetesStatus() 
    {
        return (String) diabetesComboBox.getSelectedItem();
    }
    
    public static boolean getDiabetesBoolean()
    {
        String diabetesStatus = getDiabetesStatus();;
        boolean diabetes = false;
        if(!diabetesStatus.equals(""))
        {
            switch(diabetesStatus)
            {
                case "Yes":
                    diabetes = true;
                    break;
                case "No":
                    diabetes = false;
                    break;
            }
        }
        else
        {
            
        }
        return diabetes;
    }
    
    public static String getBloodPressureString() 
    {
        return bloodPressureTextField.getText().trim();
    }
    
    public static double getBloodPressureAsDouble()
    {
        return Double.parseDouble(getBloodPressureString());
    }
    
    public static String getCholesterolType()
    {
        return (String) cholesterolTypeComboBox.getSelectedItem();
    }
    
    public static String getCholesterolString() 
    {
        return cholesterolTextField.getText().trim();
    }
    
    public static double getcholesterolAsDouble()
    {
        return Double.parseDouble(getCholesterolString());
    }
    
    public static String getCholesterolUnit()
    {
        return (String) cholesterolUnitComboBox.getSelectedItem();
    }
    
    public static String getHDLCholesterolString() 
    {
        return HDLCholesterolTextField.getText().trim();
    }
    
    public static double getHDLCholesterolAsDouble()
    {
        return Double.parseDouble(getHDLCholesterolString());
    }
    
    public static String getHDLCholesterolUnit()
    {
        return (String) HDLCholesterolUnitComboBox.getSelectedItem();
    }
    
    public static void clear()
    {
        ageTextField.setText("");
        bloodPressureTextField.setText("");
        cholesterolTextField.setText("");
        HDLCholesterolTextField.setText("");
        genderComboBox.setSelectedIndex(0);
        smokingComboBox.setSelectedIndex(0);
        diabetesComboBox.setSelectedIndex(0);
        cholesterolTypeComboBox.setSelectedIndex(0);
        cholesterolUnitComboBox.setSelectedIndex(0);
        HDLCholesterolUnitComboBox.setSelectedIndex(0);
    }
}
