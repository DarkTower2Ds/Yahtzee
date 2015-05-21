
public class gameBackEnd {
	private int[] playerScores;
	private int roundsLeft;
	
	public gameBackEnd(int numPlayers){
		playerScores = new int[numPlayers];
		roundsLeft = 13;
	}
	
	public void endTurn(int player, int[] diceInput){
		int[] finalDice = sortDice(diceInput);
		
		if(isYahtzee(finalDice)){
			playerScores[player] += 50;
		}else if(isLargeStraight(finalDice)){
			playerScores[player] += 40;
		}else if(isSmallStraight(finalDice)){
			playerScores[player] += 30;
		}else if(isFullHouse(finalDice)){
			playerScores[player] += 25;
		}else if(isFourOfAKind(finalDice)){
			playerScores[player] += sumOfDice(finalDice);
		}
	}
	
	public int[] sortDice(int[] input){
		int[] output = new int[input.length];

		for(int i = 0; i < input.length; i++){
			int min = Integer.MAX_VALUE;
			for(int k = i; k < input.length - i; k++){
				if(input[k] <= min){
					min = input[k];
				}
			}
			
			output[i] = min;
		}
		
		return output;
	}
	
	public int sumOfDice(int[] dice){
		int sum = 0;
		
		for(int i = 0; i < dice.length; i++){
			sum += dice[i];
		}
		
		return sum;
	}
	
	public int getScore(int index){
		return playerScores[index];
	}
	
	public boolean isYahtzee(int[] dice){
		boolean yahtzee = true;
		int firstValue = dice[0];
		
		for(int i = 0; i < dice.length; i++){
			if(dice[i] != firstValue){
				yahtzee = false;
			}
		}
		
		return yahtzee;
	}
	
	public boolean isLargeStraight(int[] dice){
		boolean largeStraight = true;
		
		for(int i = 0; i < dice.length - 1; i++){
			if(dice[i+1] != dice[i] + 1){
				largeStraight = false;
			}
		}
		
		return largeStraight;
	}
	
	public boolean isSmallStraight(int[] dice){
		boolean smallStraight = false;
		int[] firstFour = new int[dice.length-1];
		int[] lastFour = new int[dice.length-1];
		
		for(int i = 0; i < dice.length - 1; i++){
			firstFour[i] = dice[i];
		}
		for(int i = 1; i < dice.length; i++){
			lastFour[i-1] = dice[i];
		}
		
		if(isLargeStraight(firstFour) || isLargeStraight(lastFour)){
			smallStraight = true;
		}
		
		return smallStraight;
	}
	
	public boolean isFullHouse(int[] dice){
		boolean fullHouse = false;
		int firstNumberCounter = 0;
		int secondNumberCounter = 0;
		
		for(int i = 0; i < dice.length; i++){
			if(dice[0] == dice[i]){
				firstNumberCounter++;
			}else if(dice[dice.length-1] == dice[i]){
				secondNumberCounter++;
			}
		}
		
		if((firstNumberCounter == 3 && secondNumberCounter == 2) || (firstNumberCounter == 2 && secondNumberCounter == 3)){
			fullHouse = true;
		}
		
		return fullHouse;
	}
	
	public boolean isFourOfAKind(int[] dice){
		boolean fourOfAKind = false;
		int firstNumberCounter = 0;
		int secondNumberCounter = 0;
		int thridNumberCounter = 0;
		
		for(int i = 0; i < dice.length; i++){
			if(dice[0] == dice[i]){
				firstNumberCounter++;
			}else if(dice[dice.length-1] == dice[i]){
				secondNumberCounter++;
			}else if()
		}
		
		if(firstNumberCounter == 4 || secondNumberCounter == 4){
			fourOfAKind = true;
		}
		
		return fourOfAKind;
	}
	
	public boolean isThreeOfAKind(int[] dice){
		boolean threeOfAKind = false;
		
		
		return threeOfAKind;
	}
}
