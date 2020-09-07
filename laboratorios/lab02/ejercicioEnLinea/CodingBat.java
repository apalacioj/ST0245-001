public class CodingBat{

    public int countEvens(int[] nums) {
        int cont = 0;           //c1 
        for(int i = 0; i < nums.length; i++){       //c2 * n
          if(nums[i] % 2 == 0){                     //c3 * n
            cont++;             
          }                 
        }
        return cont;   //c4
    }

    public int sum13(int[] nums) {
        int sum = 0;        //c1
        for (int i = 0; i < nums.length; i++) {    //c2 * n  
            if (nums[i] == 13) {                   // c3 * n
                i++;                    
                continue;
            }
        sum += nums[i];                     //c4 * n
        }
        return sum;   // c5
    }

    public int[] fizzArray(int n) {
        int[] result = new int[n];          //c1
        for(int i = 0; i < n; i++){         //c2 * n
            result[i] = i;                  //c3 * n
        }
        return result;                  //c4
    }

    public boolean more14(int[] nums) {
        int count1 = 0;                         //c1
        int count4 = 0;                         //c2
        for(int i = 0; i < nums.length; i++){           //c3*n
          if(nums[i] == 1) count1++;                    //c4*n
          if(nums[i] == 4) count4++;                    //c5*n
        }
        return count1 > count4;                //c6
 
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
        int maxSpan = 0;                //c1
        int span;                       //c2
        int j;                          //c3
          for(int i = 0; i < nums.length; i++){                  //c4 * n
              for(j = nums.length - 1; nums[i] != nums[j]; j--); //c5 * n * n
              span = 1 + j - i;                 //c6 * n * n 
              if(span > maxSpan)                //c7 * n * n           
                  maxSpan = span;               //c8 * n * n 
          }
          return maxSpan;                       //c9
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

    public int[] fix45(int[] nums) {
        int index=0;
            for(int i=0;i<=nums.length-2;i++){
                if(nums[i]==4 &&nums[i+1]!=5){
                    for(int j=index;j<=nums.length-1;j++){
                        if(nums[j]==5 && j==0){
                            nums[0]=nums[i+1];
                            nums[i+1]=5;
                            index++;
                        }
                        if(nums[j]==5 && nums[j-1]!=4){
                            nums[j]=nums[i+1];
                            nums[i+1]=5;
                            index=j;
                            break;
                        }
                    }
                }
            }
        return nums;
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