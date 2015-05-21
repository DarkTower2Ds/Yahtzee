
public class gameBackEnd {
	private int[] finalScores;
	private int[] playerScoresUpper;
	private int roundsLeft;
	
	//initializes the arrays of scores and the number of rounds left in the game
	public gameBackEnd(int numPlayers){
		finalScores = new int[numPlayers];
		playerScoresUpper = new int[numPlayers];
		roundsLeft = 13;
	}
	
	
	/*
	 * When a player ends their turn, this method will score their
	 * dice, starting with Yahtzee and working it's way down to Aces.
	 * If no matches are made, then it goes to "Chance"
	 */
	public void endTurn(int player, int[] diceInput){
		int[] finalDice = sortDice(diceInput);
		
		if(isYahtzee(finalDice)){
			finalScores[player] += 50;
		}else if(isLargeStraight(finalDice)){
			finalScores[player] += 40;
		}else if(isSmallStraight(finalDice)){
			finalScores[player] += 30;
		}else if(isFullHouse(finalDice)){
			finalScores[player] += 25;
		}else if(isFourOfAKind(finalDice)){
			finalScores[player] += sumOfDice(finalDice);
		}else if(isThreeOfAKind(finalDice)){
			finalScores[player] += sumOfDice(finalDice);
		}else{
			playerScoresUpper[player] += upperHalf(finalDice);
			finalScores[player] += upperHalf(finalDice);
		}
		
		if(player == finalScores - 1){
			roundsLeft--;
		}
	}
	
	
	
	
	//sorts the inputed array
	//Noran, halp
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
	
	
	//returns the sum of the inputed array
	public int sumOfDice(int[] dice){
		int sum = 0;
		
		for(int i = 0; i < dice.length; i++){
			sum += dice[i];
		}
		
		return sum;
	}
	
	
	//returns the sum of all of the target numbers in the array
	public int sumOfDice(int[] dice, int target){
		int sum = 0;
		
		for(int i = 0; i < dice.length; i++){
			if(dice[i] == target){
				sum += dice[i];
			}
		}
		
		return sum;
	}
	
	
	//returns the overall score of a player
	public int getScore(int index){
		return finalScores[index];
	}
	
	
	/*
	 * Compares all of the elements in the array to the
	 * first one. If all are the same, it returns true.
	 */
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
	
	/*
	 * Returns true if all of the numbers in the
	 * inputed array are ordered from least to greates
	 * e.i. 1-2-3-4-5 or 2-3-4-5-6
	 */
	public boolean isLargeStraight(int[] dice){
		boolean largeStraight = true;
		
		for(int i = 0; i < dice.length - 1; i++){
			if(dice[i+1] != dice[i] + 1){
				largeStraight = false;
			}
		}
		
		return largeStraight;
	}
	
	/*
	 * Returns true if four of the numbers in the
	 * inputed array are ordered from least to greatest
	 * e.i. 1-2-3-4- or 2-3-4-5 or 3-4-5-6
	 */
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
	
	/*
	 * Returns true if three of the numbers are the same
	 * and the other two numbers are the same.
	 * It compares every element in the array to the first and
	 * last, adding one to a counter if they are. The counters
	 * are used to determine if there is three of one and two of another
	 */
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
	
	/*
	 * Returns true if four of the elements in the
	 * array are equal. Uses a method similar to
	 * isFullHouse, but instead of three and two, it
	 * looks for four and one
	 */
	public boolean isFourOfAKind(int[] dice){
		boolean fourOfAKind = false;
		int firstNumberCounter = 0;
		int secondNumberCounter = 0;
		
		for(int i = 0; i < dice.length; i++){
			if(dice[0] == dice[i]){
				firstNumberCounter++;
			}else if(dice[dice.length-1] == dice[i]){
				secondNumberCounter++;
			}
		}
		
		if(firstNumberCounter == 4 || secondNumberCounter == 4){
			fourOfAKind = true;
		}
		
		return fourOfAKind;
	}
	
	/*
	 * Returns true if three of the numbers are the same.
	 * Uses a method similar to isFullHouse and isFourOfAKind,
	 * but has three counters to accommodate for the
	 * possibilities.
	 */
	public boolean isThreeOfAKind(int[] dice){
		boolean threeOfAKind = false;
		int firstNumberCounter = 0;
		int secondNumberCounter = 0;
		int thirdNumberCounter = 0;
		
		for(int i = 0; i < dice.length; i++){
			if(dice[0] == dice[i]){
				firstNumberCounter++;
			}else if(dice[dice.length-1] == dice[i]){
				secondNumberCounter++;
			}else{
				thirdNumberCounter++;
			}
		}
		
		if(firstNumberCounter == 3 || secondNumberCounter == 3 || thirdNumberCounter == 3){
			threeOfAKind = true;
		}
		
		return threeOfAKind;
	}
	
	/*
	*Returns an integer representing the points scored
	*by a player. This method is called when none of the
	*lower level (higher tier) scoring options are available
	*/
	public int upperHalf(int[] dice){
		int greatest = 0;
		
		if(sumOfDice(dice, 6) > sumOfDice(dice, 5) && sumOfDice(dice, 6) > sumOfDice(dice, 4) && sumOfDice(dice, 6) > sumOfDice(dice, 3) && sumOfDice(dice, 6) > sumOfDice(dice, 2) && sumOfDice(dice, 6) > sumOfDice(dice, 1)){
			greatest = sumOfDice(dice, 6);
		}else if(sumOfDice(dice, 5) > sumOfDice(dice, 6) && sumOfDice(dice, 5) > sumOfDice(dice, 4) && sumOfDice(dice, 5) > sumOfDice(dice, 3) && sumOfDice(dice, 5) > sumOfDice(dice, 2) && sumOfDice(dice, 5) > sumOfDice(dice, 1)){
			greatest = sumOfDice(dice, 5);
		}else if(sumOfDice(dice, 4) > sumOfDice(dice, 6) && sumOfDice(dice, 4) > sumOfDice(dice, 5) && sumOfDice(dice, 4) > sumOfDice(dice, 3) && sumOfDice(dice, 4) > sumOfDice(dice, 2) && sumOfDice(dice, 4) > sumOfDice(dice, 1)){
			greatest = sumOfDice(dice, 4);
		}else if(sumOfDice(dice, 3) > sumOfDice(dice, 6) && sumOfDice(dice, 3) > sumOfDice(dice, 5) && sumOfDice(dice, 3) > sumOfDice(dice, 4) && sumOfDice(dice, 3) > sumOfDice(dice, 2) && sumOfDice(dice, 3) > sumOfDice(dice, 1)){
			greatest = sumOfDice(dice, 3);
		}else if(sumOfDice(dice, 2) > sumOfDice(dice, 6) && sumOfDice(dice, 2) > sumOfDice(dice, 5) && sumOfDice(dice, 2) > sumOfDice(dice, 4) && sumOfDice(dice, 2) > sumOfDice(dice, 3) && sumOfDice(dice, 2) > sumOfDice(dice, 1)){
			greatest = sumOfDice(dice, 2);
		}else if(sumOfDice(dice, 1) > sumOfDice(dice, 6) && sumOfDice(dice, 1) > sumOfDice(dice, 5) && sumOfDice(dice, 1) > sumOfDice(dice, 4) && sumOfDice(dice, 1) > sumOfDice(dice, 3) && sumOfDice(dice, 1) > sumOfDice(dice, 2)){
			greatest = sumOfDice(dice, 1);
		}
		
		return greatest;
	}
}
