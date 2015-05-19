import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class yahtzee extends JPanel implements ItemListener{
	JCheckBox die1;
	JCheckBox die2;
	JCheckBox die3;
	JCheckBox die4;
	JCheckBox die5;
	JButton reRollButton;
	JButton endTurnButton;
	
	public yahtzee(){
		super(new BorderLayout());
		die1 = new JCheckBox("Die 1");
		die2 = new JCheckBox("Die 2");
		die3 = new JCheckBox("Die 3");
		die4 = new JCheckBox("Die 4");
		die5 = new JCheckBox("Die 5");
		
		JButton reRollButton = new JButton("ReRoll");
		JButton endTurnButton = new JButton("End Turn");
		
		JPanel checkPanel = new JPanel(new GridLayout(0, 1));
        checkPanel.add(die1);
        checkPanel.add(die2);
        checkPanel.add(die3);
        checkPanel.add(die4);
        checkPanel.add(die5);
        checkPanel.add(reRollButton);
        checkPanel.add(endTurnButton);
 
        add(checkPanel, BorderLayout.LINE_START);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	}
	
	private static void createAndShowGUI() {
        JFrame frame = new JFrame("Yahtzee");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JComponent newContentPane = new yahtzee();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        
        frame.pack();
        frame.setVisible(true);
    }

	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
