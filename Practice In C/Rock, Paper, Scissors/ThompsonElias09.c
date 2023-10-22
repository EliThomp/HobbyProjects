/**
 *  Creates a playable game of rock, paper, scissors.
 *
 * @author Thompson, Elias
 * @assignment ICS 212 Assignment 09
 * @date September 29, 2022
 */

#include <stdlib.h>
#include <stdio.h>
#include <time.h>

/**
 * Main function.
 * @param not used.
 */
int main(void){
  
  //creates random number generator
  srand(time(NULL));

  //Variables used in main function
  int computerInput = 0;
  int userInput = 0;
  int userWins = 0;
  int computerWins = 0;
  int ties = 0;
  int play = 0;
  char winner = 'T';

  //starts the game
  printf("Welcome to Rock-Paper-Scissors! \n");
  printf ("To quit the game, press Q or q and Enter. \n");
  printf ("\n");
  
  //creates the for loop for continuous gameplay. *Infinite Loop*
  while(play == 0) {
    printf ("\n");
    //gets users move
    userInput = getUser();
    computerInput = rand() % 3;
    
    //Skips this round and plays again
    if (userInput == 5) {
      
    } else {
      //Ends the game when receiving q or Q
      if (userInput == 3) {
	break;
      } else {

	//Checks who wins and adds a win to their stats
	winner = checkWinner(userInput, computerInput);
	
	switch(winner) {
	  
	case 1:
	  computerWins++;
	  break;
	case 0:
	  userWins++;
	  break;
	case 2:
	  ties++;
	  break;
	}
      }
    }
  }
  //prints out record and ends the game
  printRecord(computerWins, userWins, ties);
  return 0;
  
}

/**
 * Prints out final scores.
 * @param the amount of times the computer wins
 * @param the amount of times the user wins
 * @param the amount of ties
 * @return is void
 */
void printRecord (int computerWins, int userWins, int ties){
  printf ("\n");
  printf ("User Wins - %d | Computer Wins - %d | Ties - %d \n", 
	  userWins, computerWins, ties); 
}


/**
 * Gets the users move and transforms it into an integer.
 * @return a number corresponding to the users move
 */
int getUser() {
  //gets users input
  printf("Enter 'r', 'p', or 's' for rock, paper, or scissors: ");
  char userInput = getchar();
  getchar();

  //returns a # based on input (rock = 0 | paper = 1 | scissors = 2)
  switch(userInput) {
  case 'r' : 
    return 0;

  case 'p' :
    return 1;

  case 's':
    return 2;
  
    //ends the game if these characters are put in
  case 'q':
    return 3;
    
  case 'Q':
  return 3;
  
  //returns an error for incorrect characters
  default : 
    printf("That was not a valid input. Please Try Again! \n");
    return 5;
  }

  return 5;
  
}

/**
 * Checks to see who wins the round.
 * @param user's move
 * @param computer's move
 * @return a number based on who won ( 0 = user | 1 = computer | 2 = tie)
 */
int checkWinner(int userInput, int computerInput) {
  //Sends a number based on who wins
  switch(userInput) {

    //Checks the cases for if the user chooses rock
  case 0:
    //rock vs paper
    if(computerInput == 1){
      printf("Computer Wins! \n");
      return 1;
    } else {
      //rock vs scissors
      if(computerInput == 2){
	printf("User Wins! \n");
	return 0;
      } else {
	//rock vs rock
	printf("It is a Tie! \n");
	return 2;	
      }
    }

    //Checks the cases for if the user chooese paper
  case 1:

    //paper vs paper
    if(computerInput == 1){
      printf("It is a Tie! \n");
      return 2;
    } else {
      //paper vs scissors
      if(computerInput == 2){
	printf("Computer Wins! \n");
        return 1;
      } else {
	//paper vs rock
	printf("User Wins! \n");
        return 0;
      }
    }

    //Checks the cases for if the user chooese scissors
  case 2:
    //scissors vs paper
    if(computerInput == 1){
      printf("User Wins! \n");
      return 0;
    } else {
      //scissors vs scissors
      if(computerInput == 2){
	printf("It is a Tie! \n");
        return 2;
      } else {
	//scissors vs rock
	printf("Computer Wins! \n");
        return 1;
      }
    }


  } //switch(userInput)

  return 2;
}
