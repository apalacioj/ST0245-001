import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.HashMap;

/**
 *Está clase lee el archivo de datos y contiene todos los métodos relacionados con el valor del gini, es decir, contiene los métodos que calculan la impureza
 *de gini respecto a un conjunto de datos, que selecciona las condiciones posibles para una variable y que selecciona la mejor condición para el conjunto
 *de datos mencionado (índice de gini menor con el conjunto de datos).
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo.
 * @version 1
 */
public class ImpurezaGini{
    /**
     * Este atributo es el delimitador que le indicará al programa cuandose cambia de palabra
     */
    public final String COMMA_DELIMITER = ";";

    /**
     * Esté atributo permite guardar todos los ginis posibles de una instancia
     */
    public final ArrayList<Gini> ginis = new ArrayList<>();

    /**
     * Constructor vacío de la clase ImpurezaGini
     */
    public ImpurezaGini(){   
    }

    /**
     * Este método lee el archivo de datos csv indicado por el usuario, los cuales se guardarán en una matriz que después retornará 
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
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch(Exception e) {
            System.out.println("Program not running");
        }
        return register;
        //O(n*m), donde n es el número de filas y m el número de columnas.
    }

    /**
     * Este método calcula la impureza de gini, según una columna y una condición específica
     * @param column columna donde se encuentra la condición dada
     * @param r archivo de datos
     * @param condition condición a tener en cuenta para el cálculo de la impureza de gini
     * @return objeto Gini
     * @see Clase Gini
     */
    public Gini calculateGiniImpurity(int column, List<List<String>> r, String condition){
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

        double leftIndex = Math.round((1 - (Math.pow(contPositiveLeft/(double)contLeft, 2)+ Math.pow(contNegativeLeft/(double)contLeft, 2)))*100d)/100d;
        double rightIndex = Math.round((1 - (Math.pow(contPositiveRight/(double)contRight, 2)+ Math.pow(contNegativeRight/(double)contRight, 2)))*100d)/100d;

        return new Gini(balancedGini(leftIndex, rightIndex, contLeft, contRight), String.valueOf(column), String.valueOf(condition), column);
        //O(n), donde n es el número de filas de la matriz que contiene los datos.
    }

    /**
     * Este método auxiliar permitirá calcular el índice de Gini ponderado. 
     * @param leftIndex impureza de gini de la izquierda
     * @param rightIndex impureza de gini de la derecha
     * @param totalLeft número de datos en total de la izquierda
     * @param totalRight número de datos en total a la derecha
     * @return impureza de gini ponderada
     */
    public double balancedGini(double leftIndex, double rightIndex, int totalLeft, int totalRight){
        return Math.round((((totalLeft*leftIndex) + (totalRight*rightIndex)) / (totalLeft + totalRight))*100d)/100d;
        //O(1)
    }

    /**
     * Este método permite calcular todas las condiciones posibles en una columna dada sin repeticiones
     * @param r archivo de datos
     * @param column columna de la que se obtendrán las posibles condiciones
     * @return hashset con todas la condiciones posibles
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
        //O(n*m), donde n es el número de filas de la matriz que contiene los datos y m es el número de condiciones que se agregan al hashset
    }

    /**
     * Este método permite calcular el mejor Gini, con todas la condiciones posibles en una columna dada, el cual se agrega al Arraylist de ginis 
     * que se tiene como atributo
     * @param r archivo de datos
     * @param conditions hashset con todas las condiciones posibles para la columna determinada
     * @param column columna en la cual se calcularon las condiciones y a la cuál se le calculará la condición que más reduce la impureza de gini.
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
        //O(n^2), donde n es el número de filas de la matriz de datos
    }

    /**
     * Este método cálculará el mejor Gini entre todos los mejores indices de Gini de las variables dadas
     * @param ginis vector dinámico con los mejores ginis entre todas las condiciones posbles para cada columna
     * @return la mejor impureza de gini
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
        //O(n), donde n es el número de instancias de Gini en el arreglo.
    }

    /**
     * Este getter retornará el arreglo con los ginis calculados.
     * @return arreglo de ginis
     */
    public ArrayList<Gini> getGinis(){
        return this.ginis;
    }
}