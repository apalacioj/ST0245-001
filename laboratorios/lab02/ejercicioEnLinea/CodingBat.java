/**
*Esta clase contiene los ejercicios en línea para el laboratorio 2
*@author Alejandra Palacio y Valentina Moreno
*@version 06/09/2020
*/
public class CodingBat{
     //EJERCICIOS ARRAY2
     public int countEvens(int[] nums) {
        int cont = 0;                               // T(n) = c1 
        for(int i = 0; i < nums.length; i++){       // T(n) = c2*n
          if(nums[i] % 2 == 0){                     // T(n) = c3*n
            cont++;                                                            
          }                 
        }
        return cont;                                // T(n) = c4 
    }

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
    }

    public int[] fizzArray(int n) {
        int[] result = new int[n];                 // T(n) = c1
        for(int i = 0; i < n; i++){                // T(n) = c2*n
            result[i] = i;                         // T(n) = c3*n
        }
        return result;                             // T(n) = c4
    }

    public boolean more14(int[] nums) {
        int count1 = 0;                            // T(n) = c1
        int count4 = 0;                            // T(n) = c2
        for(int i = 0; i < nums.length; i++){      // T(n) = c3*n
          if(nums[i] == 1) count1++;               // T(n) = c4*n
          if(nums[i] == 4) count4++;               // T(n) = c5*n
        }
        return count1 > count4;                    // T(n) = c6
 
    }

    public boolean sum28(int[] nums) {
        int sum = 0;                               // T(n) = c1
        for(int i = 0; i < nums.length; i++){      // T(n) = c2*n
          if(nums[i] == 2) sum+= 2;                // T(n) = c3*n
        }
        return sum == 8;                           // T(n) = c4
      }

    //EJERCICIOS ARRAY3
    public int[] seriesUp(int n) {
        int [] ans = new int [n*(n+1)/2];          // T(n) = c1
        int pos = 0;                               // T(n) = c2
        for(int i = 1; i <= n; i++){               // T(n) = c3*n
          for(int j = 1;j <= i; j++){              // T(n) = c4*n*m, en el peor de los casos n = m, por tanto T(n) = c4*n*n 
            ans[pos] = j;                          // T(n) = c5*n*m, en el peor de los casos n = m, por tanto T(n) = c5*n*n
            pos++;                                 // T(n) = c6*n*m, en el peor de los casos n = m, por tanto T(n) = c6*n*n
          }
        }
        return ans;                                // T(n) = c7
      }                                            // T(n) = c1 + c2 + c3n + c4n*n + c5n*n + c6n*n + c7

     public int maxSpan(int[] nums) {
         if(nums.length == 0){                                   // T(n) = c1
           return 0;                                             // T(n) = c2
           } 
         int maxSpan = 1;                                        // T(n) = c3
         int span = 0 ;                                          // T(n) = c4
         for(int i = 0; i < nums.length; i++){                   // T(n) = c5*n
               for(int j = nums.length - 1; j >= 0; j--){        // T(n) = c6*n*n
                    if(nums[j] == nums[i]){                      // T(n) = c7*n*n
                    span = j - i + 1;                            
                    if(span > maxSpan){                          // T(n) = c8*n*n
                    maxSpan = span;                              
                  }
                }
           }
      }
  return maxSpan;                                                // T(n) = c9
}                                                                // T(n) = c1 + c2 + c3 + c4 + c5n + c6n*n + c7n*n + c8n*n + c9

    public int[] fix34(int[] nums) {
        int t=0;                                                 // T(n) = c1
       
        for(int i=0; i< nums.length ; i++){                      // T(n) = c2 * n
           for(int j=0;j<nums.length ; j++){                     // T(n) = c3 * n * n
               if(nums[i]==4 && nums[j]==3){                     // T(n) = c4 * n * n
                  t=nums[j+1];                                   
                  nums[j+1]=nums[i];                            
                  nums[i]=t;                                    
               }
           }
        }
      return nums;                                               // T(n) = c5
    }                                                            // T(n) = c1 + c2n + c3n*n + c4n*n + c5

    public boolean canBalance(int[] nums) {
        int acum1 = 0;                                           // T(n) = c1
        int acum2 = 0;                                           // T(n) = c2
        for(int i = 0; i < nums.length; i++){                    // T(n) = c3*n
          acum1 += nums[i];                                      // T(n) = c4*n
            for(int j = i+1; j < nums.length; j++){              // T(n) = c5*n*(n-1)
                acum2 += nums[j];                                // T(n) = c6*n*(n-1)
            }
            if(acum1 == acum2){                                  // T(n) = c7*n
             return true;                                        
            }   
         acum2 = 0;                                              // T(n) = c8*n
        }
        return false;                                            // T(n) = c9
      }                                                          // T(n) = c1 + c2 + c3n + c4n + c5n(n-1) + c6n(n-1) + c7n + c8n + c9

    public boolean linearIn(int[] outer, int[] inner) {
        int count = 0;                                           // T(n) = c1
        for (int i = 0; i < inner.length; i++) {                 // T(n) = c2*n
            for (int j = 0; j < outer.length; j++) {             // T(n) = c3 * m * n, en el peor de los casos los arreglos son iguales, es decir m=n, por tanto, T(n) =  c3 * n * n
                if (inner[i] == outer[j]) {                      // T(n) = c4 * m * n, en el peor de los casos los arreglos son iguales, es decir m=n, por tanto, T(n) =  c4 * n * n
                     count++;                                   
                     break;                                 
                }
            }
        }
        if (count == (inner.length)){                            // T(n) = c5
             return true;                                   
        }
        return false;                                            // T(n) = c6
    }                                                            // T(n) = c1 + c2n + c3n*n + c4n*n + c5+ c6
}
