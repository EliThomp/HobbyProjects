/**
 *  Runs Various Recursive Functions
 *
 * @author Thompson, Elias
 * @assignment ICS 212 Assignment 10
 * @date October 6, 2022
 */

#include <stdlib.h>
#include "getdouble.h"
#include <stdio.h>

int main (void){
  printf("Enter two positive integers, seperated by a space, the first smaller than the second.");
    //Variables used during Main Function
  int first = getdouble();
  int second = getdouble();
  int recursivePrint = 0;
  //Checks the variables the user puts
  if ( first > second || first <= 0) {

    printf("ERROR: Make sure your first number is greater than 0 but less than your second number.");
      return 0;

  } else {
    //runs RecursiveCount
    printf("\n Counting from %d to %d: ", first, second);
    recursiveCount(first, second);             

    //runs RecursiveSum                                                   
    recursivePrint = recursiveSum(first, second);
    printf("\n The sum of %d to %d: %d ", first, second, recursivePrint);

    //runs RecursiveProduct
    recursivePrint = recursiveProduct(first, second);
    printf("\n The product of %d to %d: %d", first, second, recursivePrint);

    //runs RecursivePower
    recursivePrint = recursivePower(first, second);
    printf("\n %d to the power of %d: %d", first, second, recursivePrint);

    //runs RecursiveGcd
    recursivePrint = recursiveGcd(first, second);
    printf("\n The GCD of %d and %d: %d \n", first, second, recursivePrint);

    return 0;
  }
}

/**
 * Recursively counts from start to end
 * @param the starting value for counting
 * @param the ending value for counting
 * @return returns void.
 */
void recursiveCount(int start, int end) {
  if (start == end) { // base case
    printf("%d ", start);
    return ;
  } else {
    printf("%d ", start);
    recursiveCount(start + 1, end);
  }
}

/**
 * Recursively adds the sums of the start to end.
 * @param the start of the sums
 * @param the target  
 * @return recursively returns the sum of the numbers between start to end.
 */
int recursiveSum(int start, int end){ 
  if (start == end) { // base case
    return start;
  } else {
    return start + recursiveSum(start + 1, end);
  }
}

/**                                                                                                                  
 * Recursively multiplies the product from start to end                  
 * @param the start of the products                                                   
 * @param the target                                                                                        
 * @return recursively returns the product of the numbers between start to end.          
 */
int recursiveProduct( int start, int end) {
  if (start == end) { // base case
    return start;
  } else {
    return start * recursiveProduct(start + 1, end);
  }
}

/**
 * Recursively calculates start to the power of end
 * @param the number being raised to a power.
 * @param the degree of the power
 * @return recursively returns start to the power of end.
 */
int recursivePower(int start, int end){
  if(end == 1) { // base case
    return start;
  } else {
    return start * recursivePower(start, end - 1);
  }
}

/**
 * Recursively calculates the GCD of start and end
 * @param first number
 * @param second number
 * @return Recursivley returns the GCD of both numbers
 */
int recursiveGcd(int start, int end){ 
  if( end == 0){ // base case
    return start;
  }else{
    return recursiveGcd(end, start % end);
  }
}
