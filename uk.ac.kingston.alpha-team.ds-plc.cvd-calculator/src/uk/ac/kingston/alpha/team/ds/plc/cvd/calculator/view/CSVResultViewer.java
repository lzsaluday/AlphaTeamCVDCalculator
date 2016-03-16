/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.controller.CSVResultActionListener;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.controller.RiskResultActionListener;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.model.CSVPatientTableModel;

/**
 *
 * @author k1357811
 */
public class CSVResultViewer extends JPanel
{
    public JPanel CSVResultViewer;
    
    private TableModel tableModel;
    private JTable table;
    private JScrollPane tableContainer;
    
    private JButton backButton;
    
    private final ApplicationViewer frame;
    
    public CSVResultViewer(ApplicationViewer frame, String[] patientNames, int[] results)
    {
        this.frame = frame;
        
        createCSVResultViewer(patientNames, results);
    }

    private void createCSVResultViewer(String[] patientNames, int[] results) 
    {
        CSVResultViewer = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        tableModel = new CSVPatientTableModel(patientNames, results);
        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);
        table.setCellSelectionEnabled(true);
        tableContainer = new JScrollPane(table);
        CSVResultViewer.add(tableContainer);
        
        backButton = new JButton("Back");
        backButton.setContentAreaFilled(false);
        backButton.setFont(new Font("Calibri", Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        CSVResultViewer.add(backButton, constraints);
        backButton.addActionListener(new CSVResultActionListener(this.frame));
        
        frame.add(CSVResultViewer);
    }
}
