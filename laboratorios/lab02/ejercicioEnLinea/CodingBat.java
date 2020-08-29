public class CodingBat{

    public int countEvens(int[] nums) {
        int cont = 0;
        for(int i = 0; i < nums.length; i++){
          if(nums[i] % 2 == 0){
            cont++;
          }
        }
        return cont;
    }

    public int sum13(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 13) {
                i++;
                continue;
            }
        sum += nums[i];
        }
        return sum;
    }

    public int[] fizzArray(int n) {
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            result[i] = i;
        }
        return result;
    }

    public boolean only14(int[] nums) {
        int cont = 0;
        for(int i = 0; i< nums.length; i++){
              if(nums[i] == 1 || nums[i] ==4){
                cont++;
                continue;
              }
              else break;
            }
        if(cont == nums.length){
            return true;
            }
        return false;
          
    }

    public boolean haveThree(int[] nums) {
        int three = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == 3 & nums[i+1] == 3){
                return false;
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 3){
                three++;
            }
        }
        
        return three == 3;
    }  

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
        int count = 0;
        for (int i = 0; i < inner.length; i++) {
            for (int j = 0; j < outer.length; j++) {
                if (inner[i] == outer[j]) {
                     count++;
                     break;
                }
            }
        }
        if (count == (inner.length)){
             return true;
        }
        return false;
    }

      
}