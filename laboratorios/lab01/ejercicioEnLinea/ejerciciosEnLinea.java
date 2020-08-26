
/**
 * Esta clase contiene los algoritmos correspondientes a la segunda parte del laboratorio n°1 de estructuras de datos 
 * y algoritmos 1.
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo.
 * @version 25/08/2020
 */

public class ejerciciosEnLinea {
    //Ejercicios Recursión1 de CodingBat
    public static int factorial(int n) {
        if(n == 0){
            return 1; // T(n) = c1, donde c1 = 3
        }else{
            return factorial(n-1) * n; // T(n) = c2 + T(n-1), donde c2 = 4
        }
    }

    public static int bunnyEars(int bunnies) {
        if(bunnies == 0){
            return 0; // T(n) = c1, donde c1 = 3
        }else{
            return 2 + bunnyEars(bunnies-1); // T(n) = c2 + T(n-1), donde c2 = 4
        }
    }

    public int fibonacci(int n) {
        if(n == 0 ){
            return 0; // T(n) = c1, donde c1 = 3
        }
        if(n == 1){
            return 1; // T(n) = c2, donde c2 = 3
        }else{
            return fibonacci(n-2) + fibonacci(n-1); // c3 + T(n-2)+ T(n-1), donde c3 = 3
        }
    }

    public int bunnyEars2(int b) {
        if(b==0){
            return 0; //T(n) = c1, donde c1 = 3
        }
        if(b%2==0){
            return 3+bunnyEars2(b-1); // T(n) = c2 + T(n-1), donde c2 = 6
        }else{
            return 2+bunnyEars2(b-1); // T(n) = c3 + T(n-1), donde c3 = 4
        }
    }

    public int countX(String str) {
        if(str.length() == 0 ){
            return 0; //T(n) = c1, donde c1 = 4.
        }
        if(str.charAt(0) == 'x'){
            return 1 + countX(str.substring(1)); //T(n) = c2 + T(n-1), donde c2 = 6
        } else{
            return countX(str.substring(1)); //T(n) = c3 + T(n-1), donde c3 = 3
        }
    }

    //Ejercicios Recursión2 de CodingBat
    public boolean groupSum6(int start, int[] nums, int target) {
        if(start >= nums.length){
            return target == 0; //T(n) = c1, donde c1 = 5
        }
        if(nums[start] == 6){
            if( groupSum6(start + 1, nums, target - nums[start])){   
                return true; //T(n) = c2 + T(n-1), donde c2 = 8
            } 
        }else{
            if(groupSum6(start + 1, nums, target - nums[start]) || (groupSum6(start + 1, nums, target))){
                return true; //T(n) = c3 + T(n-1) + T(n-1), donde c3 = 8
            }
        } 
        return false; //T(n) = c4, donde c4 = 1
    }

    public boolean groupNoAdj(int start, int[]nums , int target) {
        if(start >= nums.length){
            return target==0; //T(n) = c1, donde c1 = 5
        }else if(groupNoAdj(start+2,nums,target-nums[start]) || groupNoAdj(start+1,nums,target)){
            return true; //T(n) = c2 + T(n-2) + T(n-1), donde c2 = 8
        }
        return false; //T(n) = c3, donde c3 = 1
    }     

    public boolean groupSum5(int start, int[] nums, int target) {
        if(start==nums.length){
            return target==0; //T(n) = c1, donde c1 = 5
        }
        if(nums[start]%5==0 && start < nums.length-1 && nums[start+1]==1){
            nums[start+1]=0; //T(n) = c2, donde c2 = 5
        }else if(groupSum5(start+1,nums,target-nums[start]) || nums[start]%5!=0 && groupSum5(start+1,nums,target)){ 
            return true; //T(n) = c3 + T(n-1) + T(n-1), donde c3 = 12
        }
        return false; //T(n) = c4, donde c4 = 1
    }    

    public boolean splitArray(int[] nums) {
        return splitArrayAux(0,nums,0,0);
    }

    private boolean splitArrayAux(int inicio, int [] nums, int suma1, int suma2){
        if(inicio == nums.length){
            if(suma1 == suma2){
                return true; //T(n) = c1, donde c1 = 6
            }
        }else if(splitArrayAux(inicio+1, nums, suma1+nums[inicio], suma2) || splitArrayAux(inicio+1, nums, suma1, suma2+nums[inicio])){
            return true; //T(n) = c2 + T(n-1) + T(n-1), donde c2 = 10
        }
        return false; //T(n) = c3, donde c3 = 1
    }

    public boolean split53(int[] nums) {
        return split53Aux(0,nums,0,0);
    }

    private boolean split53Aux(int inicio, int [] nums, int suma1, int suma2){
        if(inicio == nums.length){
            if(suma1 == suma2){
                return true; //T(n) = c1, donde c1 = 5
            }
        }else if(nums[inicio]%5==0){
            return split53Aux(inicio+1, nums, suma1+nums[inicio], suma2); //T(n) = c2 + T(n-1), donde c2 = 9
        }else if(nums[inicio]%5!=0 && nums[inicio]%3==0){
            return split53Aux(inicio+1, nums, suma1, suma2+nums[inicio]); //T(n) = c3 + T(n-1), donde c3 = 13
        }else{
            return split53Aux(inicio+1, nums, suma1+nums[inicio], suma2) || split53Aux(inicio+1, nums, suma1, suma2+nums[inicio]); 
            //T(n) = c4 + T(n-1) + T(n-1), donde c4 = 9
        }
        return false; //T(n) = c5, donde c5 = 1
    }
}
