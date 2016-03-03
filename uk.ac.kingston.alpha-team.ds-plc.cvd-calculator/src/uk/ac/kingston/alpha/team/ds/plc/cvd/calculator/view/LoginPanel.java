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
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.controller.LoginActionsListener;

/**
 *
 * @author k1317897
 */
public class LoginPanel extends JPanel {
    
    public JPanel loginPanel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton clearButton;
    private JButton backButton;
    private final ApplicationViewer applicationViewer;
    
    public LoginPanel(ApplicationViewer applicationViewer)
    {
        this.applicationViewer = applicationViewer;
        setLoginPanel();
    }
    
    public void setLoginPanel() 
    {
        loginPanel = new JPanel(new GridBagLayout());
        
        GridBagConstraints constraints = new GridBagConstraints();
 
        constraints.fill = GridBagConstraints.HORIZONTAL;
 
        ImageIcon imageicon = new ImageIcon(this.getClass().getResource("icons/preferences_system_login.png"));
        JLabel iconLabel = new JLabel("", imageicon, JLabel.CENTER);
        JLabel textLabel = new JLabel("System Authentication", JLabel.CENTER);
        textLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        loginPanel.add(iconLabel);
        loginPanel.add(textLabel);
        
        usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        loginPanel.add(usernameLabel, constraints);
 
        usernameTextField = new JTextField(30);
        usernameTextField.setFont(new Font("Calibri", Font.BOLD, 18));
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        loginPanel.add(usernameTextField, constraints);
 
        passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        loginPanel.add(passwordLabel, constraints);
 
        passwordField = new JPasswordField(30);
        passwordField.setFont(new Font("Calibri", Font.BOLD, 18));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        loginPanel.add(passwordField, constraints);
        
        loginButton = new JButton("Login");
        loginButton.setContentAreaFilled(false);
        loginButton.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 0;
        loginPanel.add(loginButton, constraints);
 
        clearButton = new JButton("Clear");
        clearButton.setContentAreaFilled(false);
        clearButton.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 0;
        loginPanel.add(clearButton, constraints);
        
        backButton = new JButton("Back to Main Menu");
        backButton.setContentAreaFilled(false);
        backButton.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 0;
        loginPanel.add(backButton, constraints);   
        
        backButton.addActionListener(new LoginActionsListener(applicationViewer));
        
        applicationViewer.add(loginPanel);
    }
    
    public String getUsername() {
        return usernameTextField.getText().trim();
    }
    
    public String getPassword() {
        return new String(passwordField.getPassword());
    }
    
    
    
}
