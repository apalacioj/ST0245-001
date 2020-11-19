/**
 * Esta clase sirve como base para cada número impureza de Gini. 
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo.
 * @version 1
 */
public class Gini {
    /**
     * Valor del número Gini
     */
    private double gini;
    /**
     * Variable de la cuál se deriva la condición del gini
     */
    private String variable;
    /**
     * Condición con la que se calculaŕa el gini
     */
    private String condition;
    /**
     * Columna donde se encuentra la variable correspondiente a la condición que calcula el índice de gini
     */
    private int column;

    /**
     * Contructor vacío de la clase Gini
     */
    public Gini(){

    }

    /**
     * Constructor de la clase Gini
     * @param g instancia de gini
     */
    public Gini(Gini g){
        this.gini = g.getGini();
        this.variable = g.getVariable();
        this.condition = g.getCondition();
        this.column = g.getColumn();
    }

    /**
     * Constructor de la clase Gini
     * @param g valor del gini
     * @param v variable del gini
     * @param c condición del gini
     * @param column columna de la variable del gini
     */
    public Gini(double g, String v, String c, int column){
        this.gini = g;
        this.variable = v;
        this.condition = c;
        this.column = column;
    }

    /**
     * Este setter reemplazará el valor actual del índice de gini
     * @param g nuevo valor del Gini
     */
    public void setGini(double g){
        this.gini = g;
    }

    /**
     * Este setter reemplazará el valor actual de la variable
     * @param v nuevo valor de la variable
     */
    public void setVariable(String v){
        this.variable = v;
    }

    /**
     * Este setter reemplazará el valor actual de la condición
     * @param c nuevo valor de la condición
     */    
    public void setCondition(String c){
        this.condition = c;
    }

    /**
     * Este setter reemplazará el valor actual de la columna de la variable
     * @param c nuevo valor de la columna
     */
    public void setColumn(int c){
        this.column = column;
    }

    /**
     * Este getter retornará el valor del gini de la instancia determinada
     * @return valor del índice de gini
     */
    public double getGini(){
        return this.gini;
    }

    /**
     * Este getter retornará el valor de la variable de la instancia determinada
     * @return variable del índice de gini 
     */
    public String getVariable(){
        return this.variable;
    }

    /**
     * Este getter retornará el valor de la condición de la instancia determinada
     * @return condición del índice de gini
     */
    public String getCondition(){
        return this.condition;
    }

    /**
     * Este getter retornará el valor de la columna donde está la condicion de la instancia determinada
     * @return número de la columa
     */
    public int getColumn(){
        return this.column;
    }
}