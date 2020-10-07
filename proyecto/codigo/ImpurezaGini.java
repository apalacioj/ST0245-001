import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Esta clase tendrá un método que será capaz de leer cualquier archivo cvs que el usuario le pase
 * @author Alejandra Palacio y Valentina Moreno 
 * @date 16/08/20
 */
public class ImpurezaGini{
    /**
     * Este atributo es el delimitador que le indicará al programa cuando este cambie de palabra
     */
    public static final String COMMA_DELIMITER = ";";

    /**
     * Este método main nos permitirá leer el archivo preestablecido e imprimirá los elementos de este
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<List<String>> register = readCSV("lite.csv");

        System.out.println("Type the column where you want to get the gini number, then the condition that you will consider for the aplication of this method" );
        int column = scan.nextInt();
        double condition = scan.nextDouble();

        switch(condition)
            case 0:
            double gini = calculateGiniImpurity(column, register, condition);
            System.out.println(gini);
            break;

            case 1:
            double gini = calculateGiniImpurity(column, register, condition);
            System.out.println(gini);
            break;

            case 2:
            double gini = calculateGiniImpurity(column, register, condition);
            System.out.println(gini);
            break;

            case 3:
            double gini = calculateGiniImpurity(column, register, condition);
            System.out.println(gini);
            break;

            case 4:
            double gini = calculateGiniImpurity(column, register, condition);
            System.out.println(gini);
            break;


        }

    /**
     * Este método le preguntará al usuario el nombre del archivo cvs que desee leer y procederá a guardarlos en un arraylist doble que después retornará 
     * @param filename
     * @return List<List<String>> 
     */
    public static List<List<String>> readCSV(String filename) {
        List<List<String>> register = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(filename))) {
            String file;
            while ((file = buffer.readLine()) != null) {
                String[] columns = file.split(COMMA_DELIMITER);
                register.add(Arrays.asList(columns));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch(Exception e) {
            System.out.println("Program not running");
        }
        return register;
    }

    public static double calculateGiniImpurity(int column, List<List<String>> r, double condition){

        int contLeft = 0; 
        int contRight = 0;
        int contPositiveLeft = 0;
        int contNegativeLeft = 0;
        int contPositiveRight = 0;
        int contNegativeRight = 0;


        for(int i = 0; i < r.get(i).size(); i++){
            if(r.get(i).get(column).equals("")){
                continue;
            }
            else if(Double.parseDouble(r.get(i).get(column)) >= condition){
                contLeft++;
                if(r.get(i).get(r.get(i).size()-1).equals("0")){
                    contNegativeLeft++;
                }
                else if(r.get(i).get(r.get(i).size()-1).equals("1")){
                    contPositiveLeft++;
                }
            }
            else{
                contRight++;
                if(r.get(i).get(r.get(i).size()-1).equals("0")){
                    contNegativeRight++;
                }
                else if(r.get(i).get(r.get(i).size()-1).equals("1")){
                    contPositiveRight++;
                }
            }
        }

        double leftIndex = 1 - (Math.pow(contPositiveLeft/contLeft, 2)+ Math.pow(contNegativeLeft/contLeft, 2));
        double rightIndex = 1 - (Math.pow(contPositiveRight/contRight, 2)+ Math.pow(contNegativeRight/contRight, 2));

        return balancedGini(leftIndex, rightIndex, contLeft, contRight);


    }

    public static double balancedGini(double leftIndex, double rightIndex, int totalLeft, int totalRight){
        return ((totalLeft*leftIndex) + (totalRight*rightIndex)) / (totalLeft + totalRight);
        
    }


}