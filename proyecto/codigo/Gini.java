/**
 * Esta clase servirá de base para cada número Gini que se cree durante la ejecución de algoritmo.
 * @author Alejandra Palacio Jaramillo y Valentina Moreno Ramírez
 * @version 1
 * @date 11/10/2020
 * 
 */
public class Gini {
    /**
     * Valor gini que tendrá el objeto
     */
    private double gini;
    /**
     * Categoría de la cual se sacó el Gini
     */
    private String variable;
    /**
     * Condición aplicada para calcular el Gini
     */
    private String condition;

    public Gini(){

    }
    /**
     * Este constructor nos permitirá crear instancias del objeto 
     * @param g valor que tendrá el gini
     * @param v categoría 
     * @param c condición aplicada
     */
    public Gini(double g, String v, String c){
        this.gini = g;
        this.variable = v;
        this.condition = c;
    }

    /**
     * Este es un setter que nos permitirá cambiar el valor del Gini
     * @param g valor gini que reemplazará al actual
     */
    public void setGini(double g){
        this.gini = g;
    }

    /**
     * Este es un setter que nos permitirá cambiar el valor de la condición
     * @param v valor nuevo  que reemplazará al actual
     */
    public void setVariable(String v){
        this.variable = v;
    }

    /**
     * Este es un setter que nos permitirá cambiar el valor de la condición
     * @param c valor nuevo  que reemplazará al actual
     */
    public void setCondition(String c){
        this.condition = c;
    }

    /**
     * Este es un getter que retornará el valor del gini de la instancia 
     * @return valor del gini
     */
    public double getGini(){
        return this.gini;
    }

    /**
     * Este es un getter que retornará el valor de la variable de la instancia 
     * @return valor de la variable o la condición
     */
    public String getVariable(){
        return this.variable;
    }

    /**
     * Este es un getter que retornará el valor de la condición de la instancia 
     * @return valor de la condición
     */
    public String getCondition(){
        return this.condition;
    }

    
}
