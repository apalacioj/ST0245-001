import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.HashMap;

/**
 *Está clase leera el archivo de datos y tendrá todos los métodos relacionados con el valor del gini
 * @author Valentina Moreno y Alejandra Palacio
 * @version 1
 * 
 */
public class ImpurezaGini{
    /**
     * Este atributo es el delimitador que le indicará al programa cuando este cambie de palabra
     */
    public final String COMMA_DELIMITER = ";";

    /**
     * Esté atributo nos permitirá guardar todos los ginis posibles de una instancia
     */
    public final ArrayList<Gini> ginis = new ArrayList<>();

    /**
     * Constructor vacío de la clase impureza de Gini
     */
    public ImpurezaGini(){   
    }

    /**
     * Este método le preguntará al usuario el nombre del archivo cvs que desee leer y procederá a guardarlos en un arraylist doble que después retornará 
     * @param filename nombre del archivo a leer
     * @return conjunto de datos leídos
     */
    public List<List<String>> readCSV(String filename) {
        List<List<String>> register = new ArrayList<>();
        int cont = 0;
        try (BufferedReader buffer = new BufferedReader(new FileReader(filename))) {
            String file;
            while ((file = buffer.readLine()) != null) {
                String[] columns = file.split(COMMA_DELIMITER);
                register.add(Arrays.asList(columns));
                cont++;
                if(cont == 300){
                    break;
                }
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
     * Este método calculará el número gini, dado una columna y una condición especifica
     * @param column columna donde se encuentra la condición requerida
     * @param r archivo de datos
     * @param condition condición a tener en cuenta para el cálculo del número gini
     * @return objeto gini 
     */
    public Gini calculateGiniImpurity(int column, List<List<String>> r, String condition){
        int contLeft = 0; 
        int contRight = 0;
        int contPositiveLeft = 0;
        int contNegativeLeft = 0;
        int contPositiveRight = 0;
        int contNegativeRight = 0;              //O(n)
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

        double leftIndex = Math.round((1 - (Math.pow(contPositiveLeft/(double)contLeft, 2)+ Math.pow(contNegativeLeft/(double)contLeft, 2)))*100d)/100d;
        double rightIndex = Math.round((1 - (Math.pow(contPositiveRight/(double)contRight, 2)+ Math.pow(contNegativeRight/(double)contRight, 2)))*100d)/100d;

        return new Gini(balancedGini(leftIndex, rightIndex, contLeft, contRight), String.valueOf(column), String.valueOf(condition), column);

    }

    /**
     * Este será un método auxiliar que nos ayudará a calcular el número gini total 
     * @param leftIndex número de veces que ocurrió la condición en el lado izquierdo y fue exitoso
     * @param rightIndex número de veces que ocurrió la condición en el lado derecho y fue exitoso
     * @param totalLeft número de datos en total a la izquierda tanto exitosos como no exitosos
     * @param totalRight número de datos en total a la derecha tanto exitosos como no exitosos
     * @return número gini
     */
    public double balancedGini(double leftIndex, double rightIndex, int totalLeft, int totalRight){
        return Math.round((((totalLeft*leftIndex) + (totalRight*rightIndex)) / (totalLeft + totalRight))*100d)/100d;
    }

    /**
     * Este método nos permitirá calcular todas las condiciones posibles en una columna dada sin repeticiones
     * @param r archivo de datos
     * @param column columna a la que se le sacarán los datos 
     * @return un hashset con todas la condiciones posibles
     */
    public HashSet conditions(List<List<String>> r, int column){
        HashSet conditions = new HashSet();
        int j = 0;
        for(int i = 1; i<r.size(); i++){
            if(r.get(i).get(column) == ""){
                continue;
            }else{
                conditions.add(r.get(i).get(column));
            }
        }
        return conditions;
    }

    /**
     * Este método nos permitirá calcular el mejor Gini, con todas la condiciones posibles en una columna dada y se agreña al arrayList de ginis 
     * que se tiene como atributo
     * @param r archivo de datos
     * @param conditions hashset con todas las condiciones posibles
     * @param column columna en la cual se calcularon las condiciones y a la cuál se le calculará el Gini
     */
    public void getMinGini(List<List<String>> r, HashSet conditions, int column){
        double min = 100;
        String tempColumn = "";
        String tempCondition = "";
        double y = 0;
        String temp = "";
        double tempMin = 0;
        for(Object m: conditions){
            y = calculateGiniImpurity(column, r, (String)m).getGini();
            temp = String.valueOf(y);
            tempMin = Double.parseDouble(temp);
            if(tempMin < min){
                min = tempMin;
                tempColumn = r.get(0).get(column);
                tempCondition = (String)m;
            }
        }
        ginis.add(new Gini((double)Math.round(min*10000d)/10000d, tempColumn, tempCondition, column));
    }

    /**
     * Este método nos cálculará el mejor Gini encontrado en el atributo de ginis retornando el valor más bajo
     * @param ginis arreglo de todos los mejores ginis con todas las condiciones posbles 
     * @return el mejor gini
     */
    public Gini bestGini(ArrayList<Gini> ginis){
        Gini ginimin = new Gini();
        double min = 1000;
        for(int i = 0; i<ginis.size(); i++){
            if(ginis.get(i).getGini() < min){
                min = ginis.get(i).getGini();
                ginimin = ginis.get(i);
            }
        }
        return ginimin;    
    }

    /**
     * Este será un getter que retornara el arreglo de los ginis de la instancia invocada
     * @return arreglo de ginis
     */
    public ArrayList<Gini> getGinis(){
        return this.ginis;
    }
}