import java.util.*;

public class Submission {
    public static void main(String[]args)
    {
        //Get the size of the matrix and then start adding the numbers all into the matrix 
        int size = Integer.parseInt(args[0]);
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[0][0];
        try
        {
            matrix = new int[size][size];
            for(int i=0; i<size; i++)
            {
                for(int j=0; j<size; j++)
                {
                    matrix[i][j] = sc.nextInt();
                }
            }
        }
        catch (Exception e)
        {

        }
        finally
        {
            sc.close();
        }

        int total =0; 
        ArrayList<Integer> arr = new ArrayList<>();

        //Find the total by travesing the matrix
        for(int x=0;x<size;x++)
        {
            int index = x;
            total = matrix[0][x];

            for(int y=1; y<=size-1; y++)
            {
                int left = index-1;
                int right = index +1;
                if (left<0)
                {
                    total = total + matrix[y][right];
                    index = right;
                }

                else if(right>size-1)
                {
                    total = total+matrix[y][left];
                    index = left;
                }
                else
                {
                    if(matrix[y][left]>matrix[y][right])
                    {
                        total = total +matrix[y][left];
                        index = left;
                    }
                    else if(matrix[y][left]==matrix[y][right])
                    {
                        total = total+matrix[y][right];
                        index = right;
                    }
                    else
                    {
                        total = total +matrix[y][right];
                        index = right;
                    }
                }
                
            }
            arr.add(total);
        } 
        System.out.println(Collections.max(arr));      
    }
    
}
