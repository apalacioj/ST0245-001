public class CodingBat{

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


    public int[] seriesUp(int n) {
        int [] ans = new int [n*(n+1)/2]; //C1
        int pos = 0; //C2
        for(int i = 1; i <= n; i++){ //C3*n
          for(int j = 1;j <= i; j++){ //C4*n*m Como m <= n, entonces m = n C4*l*l 
            ans[pos] = j; //C5*n*m //C5*n*n
            pos++; //C6*n*m, entonces C6*n*n
          }
        }
        return ans; //C7
      }

     public int maxSpan(int[] nums) {
         if(nums.length == 0){ //c1
           return 0; //c2
           } 
         int maxSpan = 1; //c3
         int span = 0 ; //c4
         for(int i = 0; i < nums.length; i++){ //c5*n
               for(int j = nums.length - 1; j >= 0; j--){ //c6*n*n
                    if(nums[j] == nums[i]){ //c7*n*n
                    span = j - i + 1; //c8*n*n
                    if(span > maxSpan){ //c9*n*n
                    maxSpan = span; //c10*n*n
                  }
                }
           }
      }
  return maxSpan; //C11
}

    public int[] fix34(int[] nums) {
        int t=0;                                  //c1
       
        for(int i=0; i< nums.length ; i++){       //c2 * n
           for(int j=0;j<nums.length ; j++){      //c3 * n * n
               if(nums[i]==4 && nums[j]==3){      //c4 * n * n
                  t=nums[j+1];                    //c5 * n * n
                  nums[j+1]=nums[i];              //c6 * n * n
                  nums[i]=t;                      //c7 * n * n
               }
           }
        }
      return nums;                               //c8
    }

    public boolean canBalance(int[] nums) {
        int acum1 = 0;                                  //C1
        int acum2 = 0;                                  //C2
        for(int i = 0; i < nums.length; i++){           //C3*n
          acum1 += nums[i];                             //C4*n
            for(int j = i+1; j < nums.length; j++){       //C5*n*(n-1)
                acum2 += nums[j];                           //C6*n*(n-1)
            }
            if(acum1 == acum2){                           //C7*n
             return true;                                //C8*n
            }   
         acum2 = 0;                                    //C9*n
        }
        return false;                                   //C10
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

      
}
