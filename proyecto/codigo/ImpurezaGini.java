import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.ArrayList;
/**
 * Esta clase tendrá un método que será capaz de leer cualquier archivo cvs que el usuario le pase
 * @author Alejandra Palacio y Valentina Moreno 
 * @date 16/08/20
 * @version 1
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
        List<List<String>> register = readCSV("lite.csv");
        String [] cond1 = conditions(register, 68);
        String [] cond2 = conditions(register, 69);
        String [] cond3 = conditions(register, 70);
        String [] cond4 = conditions(register, 71);
        String [] cond5 = conditions(register, 72);
        String [] cond6 = conditions(register, 13);
        String [] cond7 = conditions(register, 35);
        String [] cond8 = conditions(register, 65);
        String [] cond9 = conditions(register, 66);
        String [] cond10 = conditions(register, 67);
        String [] cond11 = conditions(register, 75);
        Gini gini1 = getMinGini(register, 68, cond1);
        Gini gini2 = getMinGini(register, 69, cond2);
        Gini gini3 = getMinGini(register, 70, cond3);
        Gini gini4 = getMinGini(register, 71, cond4);
        Gini gini5 = getMinGini(register, 72, cond5);
        Gini gini6 = getMinGini(register, 13, cond6);
        Gini gini7 = getMinGini(register, 35, cond7);
        Gini gini8 = getMinGini(register, 65, cond8);
        Gini gini9 = getMinGini(register, 66, cond9);
        Gini gini10 = getMinGini(register, 67, cond10);
        Gini gini11 = getMinGini(register, 75, cond11);
        System.out.println("La condición que reduce la impureza de gini de la variable "+gini1.getVariable()+" es "+gini1.getCondition()+". Esta impureza es "+gini1.getGini());
        System.out.println("La condición que reduce la impureza de gini de la variable "+gini2.getVariable()+" es "+gini2.getCondition()+". Esta impureza es "+gini2.getGini());
        System.out.println("La condición que reduce la impureza de gini de la variable "+gini3.getVariable()+" es "+gini3.getCondition()+". Esta impureza es "+gini3.getGini());
        System.out.println("La condición que reduce la impureza de gini de la variable "+gini4.getVariable()+" es "+gini4.getCondition()+". Esta impureza es "+gini4.getGini());
        System.out.println("La condición que reduce la impureza de gini de la variable "+gini5.getVariable()+" es "+gini5.getCondition()+". Esta impureza es "+gini5.getGini());
        System.out.println("La condición que reduce la impureza de gini de la variable "+gini6.getVariable()+" es "+gini6.getCondition()+". Esta impureza es "+gini6.getGini());
        System.out.println("La condición que reduce la impureza de gini de la variable "+gini8.getVariable()+" es "+gini8.getCondition()+". Esta impureza es "+gini8.getGini());
        System.out.println("La condición que reduce la impureza de gini de la variable "+gini9.getVariable()+" es "+gini9.getCondition()+". Esta impureza es "+gini9.getGini());
        System.out.println("La condición que reduce la impureza de gini de la variable "+gini10.getVariable()+" es "+gini10.getCondition()+". Esta impureza es "+gini10.getGini());
        System.out.println("La condición que reduce la impureza de gini de la variable "+gini11.getVariable()+" es "+gini11.getCondition()+". Esta impureza es "+gini11.getGini());
        System.out.println("La condición que reduce la impureza de gini de la variable "+gini7.getVariable()+" es "+gini7.getCondition()+". Esta impureza es "+gini7.getGini());
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
    public static Gini calculateGiniImpurity(int column, List<List<String>> r, String condition){
        int contLeft = 0; 
        int contRight = 0;
        int contPositiveLeft = 0;
        int contNegativeLeft = 0;
        int contPositiveRight = 0;
        int contNegativeRight = 0;
        boolean a = true;

        for(int i = 1; i < r.size(); i++){
            try{
                double n = Double.parseDouble(r.get(i).get(column));
                a = false;
            }catch(NumberFormatException e){
                a = true;
            }

            if(a == true){
                if(r.get(i).get(column).equals("")){
                    continue;
                }else if(r.get(i).get(column).equals(condition)){
                    contLeft++;
                    if(r.get(i).get(r.get(i).size()-1).equals("0")){
                        contNegativeLeft++;
                    }
                    else if(r.get(i).get(r.get(i).size()-1).equals("1")){
                        contPositiveLeft++;
                    }
                }else{
                    contRight++;
                    if(r.get(i).get(r.get(i).size()-1).equals("0")){
                        contNegativeRight++;
                    }
                    else if(r.get(i).get(r.get(i).size()-1).equals("1")){
                        contPositiveRight++;
                    }
                }
            }else{
                if(r.get(i).get(column).equals("")){
                    continue;
                }else if(Double.parseDouble(r.get(i).get(column)) >= Double.parseDouble(condition)){
                    contLeft++;
                    if(r.get(i).get(r.get(i).size()-1).equals("0")){
                        contNegativeLeft++;
                    }
                    else if(r.get(i).get(r.get(i).size()-1).equals("1")){
                        contPositiveLeft++;
                    }
                }else{
                    contRight++;
                    if(r.get(i).get(r.get(i).size()-1).equals("0")){
                        contNegativeRight++;
                    }
                    else if(r.get(i).get(r.get(i).size()-1).equals("1")){
                        contPositiveRight++;
                    }
                }
            }
        }

        double leftIndex = 1 - (Math.pow(contPositiveLeft/(double)contLeft, 2)+ Math.pow(contNegativeLeft/(double)contLeft, 2));
        double rightIndex = 1 - (Math.pow(contPositiveRight/(double)contRight, 2)+ Math.pow(contNegativeRight/(double)contRight, 2));

        return new Gini(balancedGini(leftIndex, rightIndex, contLeft, contRight), String.valueOf(column), String.valueOf(condition));

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

    /**
     * Este método nos permitirá sacar las condiciones en la que se evaluará el Gini para así obtener el mejor valor
     * @param r archivo con los datos que serán analizados
     * @param column columna a la que se le sacarán las condiciones
     * @return array de condiciones
     */
    public static String[] conditions(List<List<String>> r, int column){
        ArrayList<String> conditionsTemp = new ArrayList<>();
        int j = 0;
        for(int i = 1; i<r.size(); i++){
            if(r.get(i).get(column) == ""){
                continue;
            }else{
                conditionsTemp.add(r.get(i).get(column));
            }
        }
        String [] conditions = new String[conditionsTemp.size()];
        return conditionsTemp.toArray(conditions);
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
            y = calculateGiniImpurity(column, r, conditions[j]).getGini();
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