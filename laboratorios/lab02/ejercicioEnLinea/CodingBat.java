/**
* La clase CodingBat contiene los ejercicios de Array2 y Array3 que se realizaron para el laboratorio 2.
*@author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo
*@version 29/08/2020
*/
public class CodingBat{

    // EJERCICIOS ARRAY2
    public int countEvens(int[] nums) {
        int cont = 0;                               // T(n) = c1 
        for(int i = 0; i < nums.length; i++){       // T(n) = c2*n
          if(nums[i] % 2 == 0){                     // T(n) = c3*n
            cont++;                                                            
          }                 
        }
        return cont;                                // T(n) = c4 
    }                                               // T(n) = c1 + c2n + c3n + c4

    public int sum13(int[] nums) {
        int sum = 0;                               // T(n) = c1
        for (int i = 0; i < nums.length; i++) {    // T(n) = c2*n  
            if (nums[i] == 13) {                   // T(n) = c3*n
                i++;                    
                continue;
            }
        sum += nums[i];                            // T(n) = c4*n
        }
        return sum;                                // T(n) = c5
    }                                              // T(n) = c1 + c2n + c3n + c4n + c5

   public int[] fizzArray(int n) {
        int[] result = new int[n];                 // T(n) = c1
        for(int i = 0; i < n; i++){                // T(n) = c2*n
            result[i] = i;                         // T(n) = c3*n
        }
        return result;                             // T(n) = c4
    }                                              // T(n) = c1 + c2n + c3n + c4
    
  public boolean more14(int[] nums) {
        int count1 = 0;                            // T(n) = c1
        int count4 = 0;                            // T(n) = c2
        for(int i = 0; i < nums.length; i++){      // T(n) = c3*n
          if(nums[i] == 1) count1++;               // T(n) = c4*n
          if(nums[i] == 4) count4++;               // T(n) = c5*n
        }
        return count1 > count4;                    // T(n) = c6
    }                                              // T(n) = c1 + c2 + c3n + c4n + c5n + c6

  public boolean sum28(int[] nums) {
        int sum = 0;                               // T(n) = c1
        for(int i = 0; i < nums.length; i++){      // T(n) = c2*n
          if(nums[i] == 2) sum+= 2;                // T(n) = c3*n
        }
        return sum == 8;                           // T(n) = c4
    }                                              // T(n) = c1 + c2n + c3n + c4
        
     
   //EJERCICIOS ARRAY3
   public int maxSpan(int[] nums) {
        int maxSpan = 0;
          int span;
          int j;
          for(int i = 0; i < nums.length; i++)
          {
              for(j = nums.length - 1; nums[i] != nums[j]; j--);
              span = 1 + j - i;
              if(span > maxSpan)
                  maxSpan = span;
          }
          return maxSpan;
    }

    public int[] fix34(int[] nums) {
        int t=0;
       
        for(int i=0; i< nums.length ; i++){
           for(int j=0;j<nums.length ; j++){
               if(nums[i]==4 && nums[j]==3){
                  t=nums[j+1];
                  nums[j+1]=nums[i];
                  nums[i]=t;
               }
           }
        }
      return nums;
    }

    public int[] fix45(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i] == 4 && nums[i+1] != 5)
            {
                for(; !(nums[j] == 5 && (j == 0 || j > 0 && nums[j-1] != 4)); j++);
                nums[j] = nums[i+1];
                nums[i+1] = 5;
            }
        }
        return nums;
    }

    public boolean canBalance(int[] nums) {
        int left = 0;
        int right = 0;
      
        for (int i = 0, j = nums.length - 1; i <= j;) {
             if (left < right) {
                 left += nums[i++];
             }
             else {
             right += nums[j--];
             }
        }
      return (left == right);
    }

    public boolean linearIn(int[] outer, int[] inner) {
        int count = 0;                                      //c1
        for (int i = 0; i < inner.length; i++) {            //c2*n
            for (int j = 0; j < outer.length; j++) {        //c3 * m * n, como m <= n, entonces c3 * n * n
                if (inner[i] == outer[j]) {                 //c4 * m * n, entonces c4 * n * n
                     count++;                               //c5 * m * n, entonces c5 * n * n
                     break;                                 //c6 * m * n, entonces c6 * n * n
                }
            }
        }
        if (count == (inner.length)){
             return true;                                   //c7
        }
        return false;                                       //c8
    }
