/**
 * SmallestArrayItem
 */

import java.util.Scanner;

public class SmallestArrayItem {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        int arrSize = 5;
        boolean matchFound = false;

        int [] arrOne = new int[arrSize];
        int [] arrTwo = new int[arrSize];

        System.out.println("Please enter " +
            arrSize + " values for array 1");
        for(int i = 0; i <arrOne.length; i++)
        {
            arrOne[i] = keyboard.nextInt();
        }
        
        System.out.println("Please enter " +
            arrSize + " values for array 2");
        for(int i = 0; i <arrTwo.length; i++)
        {
            arrTwo[i] = keyboard.nextInt();
        }
        


        int commonInt = 0;
        for(int i = 0; i < arrOne.length; i++)
            {
                for(int num = 0; num < arrTwo.length; num++)
                {
                    if(arrOne[i] == arrTwo[num])
                    {
                        matchFound = true;
                        commonInt = arrOne[i];
                    }
                }
            }
            
        
        if(matchFound)
        {
            System.out.println("The Smallest match " +
                        "in the array is : " + 
                        commonInt);
        }
        else
        {
            System.out.println("There is no smallest matching integer!");
        }

        keyboard.close();
    }
}
