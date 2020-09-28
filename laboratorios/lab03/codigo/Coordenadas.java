public class Coordenadas{
    private long vertice;
    private double x;
    private double y;
    

    public Coordenadas(long vertice, double x, double y){
        this.vertice = vertice;
        this.x = x;
        this.y = y;
    }

    public void setVertice(long vertice){
        this.vertice = vertice;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = x;
    }

    public long getVertice(){
        return this.vertice;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }
    

    
}