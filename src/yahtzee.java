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
	
	static gameBackEnd backEnd =  new gameBackEnd();
	
	int[] currentDice = new int[5];
	int currentPlayerNumber;
	int reRollsLeft = 3;
	int numberOfPlayers = 4;
	
	public yahtzee(){
		super(new BorderLayout());
		
		//backEnd = new gameBackEnd();
		
		reRollAllDice();
		
		currentPlayerNumber = 0;
		
		die1 = new JCheckBox("Die 1");
		
		die2 = new JCheckBox("Die 2");
		
		die3 = new JCheckBox("Die 3");
		
		die4 = new JCheckBox("Die 4");
		
		die5 = new JCheckBox("Die 5");
		
		die1Text = new JTextArea("" + currentDice[0]);
		die2Text = new JTextArea("" + currentDice[1]);
		die3Text = new JTextArea("" + currentDice[2]);
		die4Text = new JTextArea("" + currentDice[3]);
		die5Text = new JTextArea("" + currentDice[4]);
		
		currentPlayer = new JTextArea("Player " + (currentPlayerNumber + 1));
		currentPlayerScore = new JTextArea(backEnd.getScore(currentPlayerNumber) + " Points");
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
		
		
		
		reRollButton = new JButton("Re-Roll");
		endTurnButton = new JButton("End Turn");
		
		reRollButton.setActionCommand("reRoll");
		reRollButton.setMnemonic(KeyEvent.VK_R);
		endTurnButton.setActionCommand("endTurn");
		endTurnButton.setMnemonic(KeyEvent.VK_E);
		
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
        newContentPane.setPreferredSize(new Dimension(170, 180));
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
	
    //Re-Rolls every dice
	public void reRollAllDice(){
		for(int i = 0; i < currentDice.length; i++){ //<-- is that correct?
			currentDice[i] = (int) (Math.random() * 6 + 1);
		}
	}
	
	protected void updateGame(){
		die1Text.setText("" + currentDice[0]);
		die2Text.setText("" + currentDice[1]);
		die3Text.setText("" + currentDice[2]);
		die4Text.setText("" + currentDice[3]);
		die5Text.setText("" + currentDice[4]);
		
		currentPlayer.setText("Player " + (currentPlayerNumber + 1));
		currentPlayerScore.setText(backEnd.getScore(currentPlayerNumber) + " Points");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		if (action.equals("reRoll")) {
			if(die1.isSelected()){
				currentDice[0] = (int) (Math.random() * 6 + 1);
			}
			if(die2.isSelected()){
				currentDice[1] = (int) (Math.random() * 6 + 1);
			}
			if(die3.isSelected()){
				currentDice[2] = (int) (Math.random() * 6 + 1);
			}
			if(die4.isSelected()){
				currentDice[3] = (int) (Math.random() * 6 + 1);
			}
			if(die5.isSelected()){
				currentDice[4] = (int) (Math.random() * 6 + 1);
			}
			
			reRollsLeft--;
			if(reRollsLeft == 0){
				reRollButton.setEnabled(false);
			}
			
			updateGame();
		}
		if (action.equals("endTurn")) {
			backEnd.endTurn(currentPlayerNumber, currentDice);
			
			reRollAllDice();
			if(currentPlayerNumber + 1 >= numberOfPlayers){
				currentPlayerNumber = 0;
				backEnd.finishedRound();
			}else{
				currentPlayerNumber++;
			}
			reRollsLeft = 3;
			
			updateGame();
		}
	}
}
