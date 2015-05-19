import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class yahtzee extends JPanel implements ItemListener{
	JCheckBox die1;
	JCheckBox die2;
	JCheckBox die3;
	JCheckBox die4;
	JCheckBox die5;
	JTextArea die1Text;
	JTextArea die2Text;
	JTextArea die3Text;
	JTextArea die4Text;
	JTextArea die5Text;
	JTextArea die6Text;
	JButton reRollButton;
	JButton endTurnButton;
	
	public yahtzee(){
		super(new BorderLayout());
		die1 = new JCheckBox("Die 1");
		die2 = new JCheckBox("Die 2");
		die3 = new JCheckBox("Die 3");
		die4 = new JCheckBox("Die 4");
		die5 = new JCheckBox("Die 5");
		
		die1Text = new JTextArea("1");
		die2Text = new JTextArea("1");
		die3Text = new JTextArea("1");
		die4Text = new JTextArea("1");
		die5Text = new JTextArea("1");
		
		die1Text.setEditable(false);
		die2Text.setEditable(false);
		die3Text.setEditable(false);
		die4Text.setEditable(false);
		die5Text.setEditable(false);
		
		
		Box die1Box = Box.createHorizontalBox();
		Box die2Box = Box.createHorizontalBox();
		Box die3Box = Box.createHorizontalBox();
		Box die4Box = Box.createHorizontalBox();
		Box die5Box = Box.createHorizontalBox();
		
		
		die1Box.add(die1Text);
		die1Box.add(die1);
		die2Box.add(die2Text);
		die2Box.add(die2);
		die3Box.add(die3Text);
		die3Box.add(die3);
		die4Box.add(die4Text);
		die4Box.add(die4);
		die5Box.add(die5Text);
		die5Box.add(die5);
		
		
		
		JButton reRollButton = new JButton("ReRoll");
		JButton endTurnButton = new JButton("End Turn");
		
		JPanel checkPanel = new JPanel(new GridLayout(0, 1));
        checkPanel.add(die1Box);
        checkPanel.add(die2Box);
        checkPanel.add(die3Box);
        checkPanel.add(die4Box);
        checkPanel.add(die5Box);
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
