/**
 *
 * @author Valentina Moreno Ramírez y Alejandra Palacio 
 */
public class Gini {
    private double gini;
    private String variable;
    private String condition;
    private int column;

    public Gini(){

    }
    
    public Gini(Gini g){
        this.gini = g.getGini();
        this.variable = g.getVariable();
        this.condition = g.getCondition();
        this.column = g.getColumn();
    }

    public Gini(double g, String v, String c, int column){
        this.gini = g;
        this.variable = v;
        this.condition = c;
        this.column = column;
    }

    public void setGini(double g){
        this.gini = g;
    }

    public void setVariable(String v){
        this.variable = v;
    }

    public void setCondition(String c){
        this.condition = c;
    }
    
    public void setColumn(int c){
        this.column = column;
    }

    public double getGini(){
        return this.gini;
    }

    public String getVariable(){
        return this.variable;
    }

    public String getCondition(){
        return this.condition;
    }
    
    public int getColumn(){
        return this.column;
    }
}