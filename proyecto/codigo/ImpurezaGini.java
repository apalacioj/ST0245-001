import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
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
     * Este método main nos permitirá obtener el mejor Gini posible con unas condiciones ya preestablecidas en cada categoría escogida
     * @param args
     */
    public static void main(String[] args) {
        List<List<String>> register = readCSV("Datos.csv");


        Gini gini1 = new Gini(calculateGiniImpurity(13, register, 2),"Número de libros", "Más de 100 libros");
        Gini gini2 = new Gini(calculateGiniImpurity(35, register, 1),"El estudiante tiene internet en el hogar?", "Sí");
        Gini gini3 = new Gini(calculateGiniImpurity(36, register, 1),"El estudiante tiene computador en el hogar?", "Sí");
        Gini gini4 = new Gini(calculateGiniImpurity(42, register, 1),"El estudiante tiene celular?", "Sí");
        Gini gini5 = new Gini(calculateGiniImpurity(54, register, 1),"Colegio Bilingüe", "Más de 100 libros");
        Gini gini6 = new Gini(calculateGiniImpurity(65, register, 66.5),"Puntuación lenguaje", "Puntuación mayor a 50");
        Gini gini7 = new Gini(calculateGiniImpurity(66, register, 89),"Puntuación matemática", "Puntuación mayor a 50");
        Gini gini8 = new Gini(calculateGiniImpurity(67, register, 50),"Puntuación biología", "Puntuación mayor a 50");

        System.out.println(gini1.getGini() + "    " + gini1.getVariable());
        System.out.println(gini2.getGini() + "    " + gini2.getVariable());
        System.out.println(gini3.getGini() + "    " + gini3.getVariable());
        System.out.println(gini4.getGini() + "    " + gini4.getVariable());
        System.out.println(gini5.getGini() + "    " + gini5.getVariable());
        System.out.println(gini6.getGini() + "    " + gini7.getVariable());
        System.out.println(gini8.getGini() + "    " + gini8.getVariable());
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

    /**
     * Este método nos permitirá calcular la impureza del gini por medio de ciclos y contadores, retornando el valor redondeado de este
     * @param column, columna a la que se le calculará el gini
     * @param r, archivo con los datos
     * @param condition, condición para clasificar los valores
     * @return Valor del gini en la columna dada teniendo en cuenta la condición
     */
    public static double calculateGiniImpurity(int column, List<List<String>> r, double condition){

        int contLeft = 0; 
        int contRight = 0;
        int contPositiveLeft = 0;
        int contNegativeLeft = 0;
        int contPositiveRight = 0;
        int contNegativeRight = 0;

        for(int i = 1; i < r.get(i).size(); i++){

            if(r.get(i).get(column).equalsIgnoreCase("Si")){
                r.get(i).set(r.indexOf(r.get(column)), "1");
            }
            if(r.get(i).get(column).equalsIgnoreCase("No")){
                r.get(i).set(r.indexOf(r.get(column)), "0");
            }

            if(r.get(i).get(column).equalsIgnoreCase("S")){
                r.get(i).set(r.indexOf(r.get(column)), "1");
            }

            if(r.get(i).get(column).equalsIgnoreCase("N")){
                r.get(i).set(r.indexOf(r.get(column)), "0");
            }

            if(r.get(i).get(column).equalsIgnoreCase("0 A 10 LIBROS")){
                r.get(i).set(r.indexOf(r.get(column)), "1");
            }

            if(r.get(i).get(column).equalsIgnoreCase("11 A 25 LIBROS")){
                r.get(i).set(r.indexOf(r.get(column)), "2");
            }

            if(r.get(i).get(column).equalsIgnoreCase("26 A 100 LIBROS")){
                r.get(i).set(r.indexOf(r.get(column)), "3");
            }

            if(r.get(i).get(column).equalsIgnoreCase("MÁS DE 100 LIBROS")){
                r.get(i).set(r.indexOf(r.get(column)), "4");
            }
            
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

    /**
     * Este es un método auxiliar que nos permitirá calcular el gini balanceado de dos ramas
     * @param leftIndex número de ocrrencias a la izquierda
     * @param rightIndex número de ocurrencias a la derecha
     * @param totalLeft total de valores a la izquierda
     * @param totalRight total de valores a la derecha
     * @return el gini balanceado
     */
    public static double balancedGini(double leftIndex, double rightIndex, int totalLeft, int totalRight){
        return ((totalLeft*leftIndex) + (totalRight*rightIndex)) / (totalLeft + totalRight);

    }

    /**Este método nos permitirá obtener el mejor gini posible 
     * @param r, lista de datos a los que se les sacará el Gini
     * @param column, columna en dónde se evaluará el método
     * @param conditions, condiciones para evaluar el gini
     * @return el Gini con mejor valor 
     */
    public static Gini getMinGini(List<List<String>> r, int column, String[] conditions){
        double min = 10000;
        String tempColumn = "";
        String tempCondition = "";
        double y = 0;
        String temp = "";
        double tempMin = 0;
        for(int j = 0; j<conditions.length; j++){
            y = calculateGiniImpurity((column, r, conditions[j]).getGini());
            temp = String.valueOf(y);
            tempMin = Double.parseDouble(temp);
            if(tempMin < min){
                min = tempMin;
                tempColumn = r.get(0).get(column);
                tempCondition = conditions[j];
            }
        }
        return new Gini((double)Math.round(min*10000d)/10000d, tempColumn, tempCondition);
    }
}