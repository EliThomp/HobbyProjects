/**
 *  Initialized an array and prints its contents using a pointer.
 *
 * @author Thompson, Elias
 * @assignment ICS 212 Assignment 13
 * @date October 18, 2022
 */

#include <stdio.h>

void increaseIntViaPointer(int *number);

int main (void) {
  //Initializing all the variables used
  //Array holding the values that will be used
  int intArray[5] = {1, 2, 3, 4, 5};
  //A pointer that will print out the values in the array
  int *arrayPointer = NULL;
  int x = 7;
  arrayPointer = intArray;

  printf("\n \n");

  /**
   * Prints last Element in the array using 4 different methods
   * 1. Array Subscript Notation using array name
   * 2. Pointer/Offset Notation using array name
   * 3. Array Subscript Notation using a pointer
   * 4. Pointer/Offset Notation using a pointer
   */
  printf("Printing the last element in the array. \n");
  printf("intArray[4] = %i \n", intArray[4]);
  printf("*(intArray + 4) = %i \n", *(intArray + 4));
  printf("intArrayPointer[4] = %i \n", arrayPointer[4]);
  printf("*(arrayPointer + 4) = %i \n", *(arrayPointer + 4));
  printf("\n");

  //Prints the contents in the array using the 4 different methods stated above
  printf("Printing the contents of the array: \n");
  printf("  Using array subscript notation with array name... \n");
  printf("    %i, %i, %i, %i, %i \n", intArray[0], intArray[1], intArray[2], intArray[3], intArray[4]);
  printf("  Using pointer/offset notation with array name... \n");
  printf("    %i, %i, %i, %i, %i \n", *(intArray+0),*(intArray+1), *(intArray+2), *(intArray+3), *(intArray+4));
  printf("  Using array subscript notation with pointer... \n");
  printf("    %i, %i, %i, %i, %i \n", arrayPointer[0],arrayPointer[1], arrayPointer[2], arrayPointer[3], arrayPointer[4]);
  printf("  Using pointer/offset notation with pointer... \n");
  printf("    %i, %i, %i, %i, %i \n", *(arrayPointer+0),*(arrayPointer+1), *(arrayPointer+2), *(arrayPointer+3), *(arrayPointer+4));

  //Prints the address of the elements using a pointer
  printf("Printing the addresses of each element in the array: \n");
    arrayPointer = &intArray[0];
  printf("  &intArray[0] = %p \n", arrayPointer); 
  arrayPointer = &intArray[1];
  printf("  &intArray[1] = %p \n", arrayPointer);
  arrayPointer = &intArray[2];
  printf("  &intArray[2] = %p \n", arrayPointer);
  arrayPointer = &intArray[3];
  printf("  &intArray[3] = %p \n", arrayPointer);
  arrayPointer = &intArray[4];
  printf("  &intArray[4] = %p \n", arrayPointer);
  
  //Calls increaseIntViaPointer() to increase an int by 100
  printf("Integer Variable BEFORE function call..: \n");
  printf("intVariable = %i \n", x);
  increaseIntViaPointer(&x);
  printf("Integer variable AFTER function call...: \n");
  printf("intVariable = %i \n", x);
  
  printf("\n \n");
  return 0;
}



/**
 *Takes an int and increases it by 100 without returning the value.
 *
 *@param an int that will be increased
 *@return void
 */
void increaseIntViaPointer(int *intParam) {
  printf("Inside increaseIntViaPointer() function, increasing parameter by 100 \n");
  //Adds 100 to the address that the pointer is pointing to.
  *intParam = *intParam + 100;
  printf("*intParam = %i \n", *intParam);
}

