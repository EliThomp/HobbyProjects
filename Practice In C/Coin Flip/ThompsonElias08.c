/**
 *  Flips a coin as many times as the user wants.
 *
 * @author Thompson, Elias
 * @assignment ICS 212 Assignment 08
 * @date September 22, 2022
 */

#include <stdlib.h>
#include "getdouble.h"
#include <stdio.h>

int main (void){

  srand(time(NULL));

  //amount of times the coin will be flipped
  int numFlips = 0;

  //The side that is shown.
  int coin = 0;

  //amount of times each side is shown
  int heads = 0;
  int tails = 0;

  //for loop int initialized
  int i = 0;

  //percentage of each side shown
  double percentHeads = 0.0;
  double percentTails = 0.0;
  

  printf("Coin Flip Simulator \n");
  printf("How many times do you want to flip the coin?");

  //gets the amount of flips
  numFlips = (int) getdouble();

  //Error checks for invalid inputs
  if (numFlips < 1) {

    printf("Error: Make sure to enter a number greater than or equal to 1. \n");
    return 0;

  }
  
  //For loop to keep flipping the amount of times inputted
  for (i = 0; i < numFlips; i++){

    coin = 1 + rand() % 2;

    //if it shows head
    if (coin == 1){

      heads++;
   
    } else { //if it shows tails

      tails++;

    }
    
  }

  printf("Number of heads: %d \n", heads);
  printf("Number of tails: %d \n", tails);


  //Calculates percentages  
  percentHeads = 100.0 * heads / (heads + tails);
  percentTails = 100.0 * tails / (heads + tails);

  //prints percentages
  printf("Percentage of heads: %f \n", percentHeads);
  printf("Percentage of tails: %f \n", percentTails);
  return 0;
}
