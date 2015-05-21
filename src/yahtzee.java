import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class yahtzee extends JPanel implements ActionListener{
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
	JTextArea currentPlayer;
	JTextArea currentPlayerScore;
	JTextArea spacer; //halp
	
	public yahtzee(){
		super(new BorderLayout());
		die1 = new JCheckBox("Die 1");
		die1.setMnemonic(KeyEvent.VK_1);
		
		die2 = new JCheckBox("Die 2");
		die1.setMnemonic(KeyEvent.VK_2);
		
		die3 = new JCheckBox("Die 3");
		die3.setMnemonic(KeyEvent.VK_3);
		
		die4 = new JCheckBox("Die 4");
		die4.setMnemonic(KeyEvent.VK_4);
		
		die5 = new JCheckBox("Die 5");
		die5.setMnemonic(KeyEvent.VK_5);
		
		die1Text = new JTextArea("1");
		die2Text = new JTextArea("1");
		die3Text = new JTextArea("1");
		die4Text = new JTextArea("1");
		die5Text = new JTextArea("1");
		
		currentPlayer = new JTextArea("Player 1");
		currentPlayerScore = new JTextArea("Score: 0");
		spacer = new JTextArea("    ");
		
		die1Text.setEditable(false);
		die2Text.setEditable(false);
		die3Text.setEditable(false);
		die4Text.setEditable(false);
		die5Text.setEditable(false);
		
		currentPlayer.setEditable(false);
		currentPlayerScore.setEditable(false);
		spacer.setEditable(false);
		
		Box playerAndScoreBox = Box.createHorizontalBox();
		
		Box die1Box = Box.createHorizontalBox();
		Box die2Box = Box.createHorizontalBox();
		Box die3Box = Box.createHorizontalBox();
		Box die4Box = Box.createHorizontalBox();
		Box die5Box = Box.createHorizontalBox();
		
		playerAndScoreBox.add(currentPlayerScore);
		playerAndScoreBox.add(spacer);
		playerAndScoreBox.add(currentPlayer);

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
		
		
		
		JButton reRollButton = new JButton("Re-Roll");
		JButton endTurnButton = new JButton("End Turn");
		
		reRollButton.setActionCommand("reRoll");
		endTurnButton.setActionCommand("endTurn");
		
		reRollButton.addActionListener(this);
		endTurnButton.addActionListener(this);
		
		JPanel checkPanel = new JPanel(new GridLayout(0, 1));
        checkPanel.add(playerAndScoreBox);
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

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
		
		
    }
	
	public void nextTurn(int player){
		int[] dice = new int[5];
		for(int element : dice){ //<-- is that correct?
			element = (int) (Math.random() * 5 + 1);
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		if (action.equals("reRoll")) {
			System.out.println("ReRoll pressed!"); // TODO Add action
		} else if (action.equals("endTurn")) {
			System.out.println("EndTurn pressed!"); // TODO Add action
		}
	}
}
