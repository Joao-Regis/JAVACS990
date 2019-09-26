/**
 * CopyingArrays
 */
public class CopyingArrays {

    public static void main(String[] args) {
        
        int[] firstArray = {5, 10, 15, 20, 25};
        int[] secondArray = new int[5];

        for (int index = 0; index < firstArray.length; index++)
        {
            secondArray[index] = firstArray[index];
        }
        System.out.println();

        for(int index = 0; index < firstArray.length; index++)
            {
                System.out.print(firstArray[index] + " ");
            }
        System.out.println();
        
        for(int index = 0; index < secondArray.length; index++)
        {
            System.out.print(secondArray[index] + " ");
        }
    }
}
