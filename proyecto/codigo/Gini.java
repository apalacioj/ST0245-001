public class Gini {
    private double gini;
    private String variable;
    private String condition;

    public Gini(){

    }

    public Gini(double g, String v, String c){
        this.gini = g;
        this.variable = v;
        this.condition = c;
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

    public double getGini(){
        return this.gini;
    }

    public String getVariable(){
        return this.variable;
    }

    public String getCondition(){
        return this.condition;
    }

    
}
