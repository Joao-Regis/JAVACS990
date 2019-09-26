/**
 * CopyingArrays
 */

 //import java.util.Scanner;

public class CopyingArrays {

    public static void main(String[] args) {
        
        
        int[] firstArray = {5, 10, 15, 20, 25};
        int[] secondArray = new int[5];

        //System.out.println(firstArray[0]);
        //System.out.println(firstArray[1]);

        System.out.println("firstArray:");
        for(int index = 0; index < firstArray.length; index++)
        {
            System.out.print(firstArray[index] + " ");
        }
        System.out.println();

        System.out.println("secondArray:");
        for(int index = 0; index < secondArray.length; index++)
        {
            System.out.print(secondArray[index] + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("Copying firstArray to secondArray");
        for (int index = 0; index < firstArray.length; index++)
        {
            secondArray[index] = firstArray[index];
        }
        System.out.println();
        
        System.out.println("firstArray:");
        for(int index = 0; index < firstArray.length; index++)
            {
                System.out.print(firstArray[index] + " ");
            }
        System.out.println();
        

        System.out.println("secondArray:");
        for(int index = 0; index < secondArray.length; index++)
        {
            System.out.print(secondArray[index] + " ");
        }
        
    }
}
