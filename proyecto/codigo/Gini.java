public class Gini {
    private int Ncolumna;
    private String condition;
    private float GiniImpurity;

    public Gini(){
        
    }
    public Gini(int Ncolumna ,String condition, float GiniImpurity){
        this.Ncolumna = Ncolumna;
        this.condition = condition;
        this.GiniImpurity = GiniImpurity;
    }

    public int getNcolumna(){
        return this.Ncolumna;
    }

    public String getCondicion(){
        return this.condition;
    }

    public float getGiniImpurity(){
        return this.GiniImpurity;
    }


}
