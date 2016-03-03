/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author k1317897
 */
public final class ApplicationViewer extends JFrame {
    
    private ApplicationMainPanel appMainMenu; 
    private RiskCalculatorPanel rcp; 
    private LoginPanel loginPanel;
    
    public ApplicationViewer()
    {
        this.loginPanel = new LoginPanel(this);
        this.appMainMenu = new ApplicationMainPanel(this);
        this.rcp = new RiskCalculatorPanel(this);
        setHeader();
        setFooter();
        setTitle("NHS Cardiovascular Disease Calculator");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons/heart-icon.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setResizable(true);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    public void setHeader()
    {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.BLUE);
        Border loweredBorder = new EtchedBorder(EtchedBorder.LOWERED);
        headerPanel.setBorder(loweredBorder);
        ImageIcon headerImage = new ImageIcon(this.getClass().getResource("icons/choices-NHS-logo.png"));
        JLabel logoLabel = new JLabel("", headerImage, JLabel.CENTER);
        JLabel titleLabel = new JLabel("Cardiovascular Disease Risk Calculator");
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE);
        ImageIcon imageHeader = new ImageIcon(this.getClass().getResource("icons/hd.png"));
        JLabel imageLabel = new JLabel("", imageHeader, JLabel.CENTER);
        headerPanel.add(logoLabel,BorderLayout.WEST);
        headerPanel.add(titleLabel);
        headerPanel.add(imageLabel, BorderLayout.EAST);
        add(headerPanel, BorderLayout.PAGE_START);
    }
    
     public void setFooter()
    {
        JPanel footerPanel = new JPanel();
        footerPanel.add(new JSeparator(JSeparator.TOP)); 
        footerPanel.setBackground(Color.BLUE);
        String copyRightText = "Copyright \u00a9 2016. Kingston University London. NHS CardioVascular Disease Calculator. Developed by Dependable Systems PLC, Alpha Team.";
        JLabel footerLabel = new JLabel(copyRightText, JLabel.CENTER);
        footerLabel.setFont(new Font("", Font.BOLD, 17));
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);
        add(footerPanel, BorderLayout.SOUTH);
    }
    
     
     public void switchToRiskCalculatorPanel() 
     {
         remove(appMainMenu.mainMenuButtons);
         add(rcp.riskCalculatorPanel);
         revalidate();
         repaint();
     }
     
     public void exitRiskCaculator() 
     {
         remove(rcp.riskCalculatorPanel);
         add(appMainMenu.mainMenuButtons);
         revalidate();
         repaint();
     }
     
     public void switchToLoginPanel() 
     {
         remove(appMainMenu.mainMenuButtons);
         add(loginPanel.loginPanel);
         revalidate();
         repaint();
     }
     
     public void exitLoginPanel()
     {
         remove(loginPanel.loginPanel);
         add(appMainMenu.mainMenuButtons);
         revalidate();
         repaint();
     }
    
}