import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * Esta clase lee el archivo de puntos 2D dado por el docente y permite aplicar las operaciones de Punto a cada uno de ellos.
 * 
 * @author Valentina Moreno y Alejandra Palacio 
 * @version 27/07/2020
 */
public class MainPuntos extends ArrayList<Punto> {
    /**
     * Este método lee el archivo de puntos 2D.
     * @throws FileNotFoundException
     */
    public void AddData()throws FileNotFoundException{
        try{
            File file = new File("medellin_colombia-grande.txt");
            Scanner scan = new Scanner(file);
            while(true){
                while (scan.hasNextLine()) {
                    String data = scan.nextLine();
                    Scanner scan1 = new Scanner(data);
                    double temp = Double.parseDouble(scan1.next());
                    double x = Double.parseDouble(scan1.next());
                    double y = Double.parseDouble(scan1.next());
                    this.add(new Punto(x, y));

                    break;

                }
                if(scan.hasNextLine() == false){
                    break;
                }else{
                    continue;
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Este método imprime por consola los datos leídos.
     */
    public void imprimirData(){
        for(Punto punto: this){
            System.out.println(punto.x()+"  "+punto.y());
        }
    }

    /**
     * Este método calcula el radio polar de un punto en 2D (coordenada).
     * @param int posición del punto en el ArrayList con referencia a Punto.
     * @return double radio polar.
     */
    public double calcularRadioPolar(int pos){
        return this.get(pos).radioPolar();
    }

    /**
     * Este método calcula el ángulo polar de un punto en 2D (coordenada).
     * @param int posición del punto en el ArrayList con referencia a Punto.
     * @return double ángulo polar.
     */
    public double calcularAnguloPolar(int pos){
        return this.get(pos).anguloPolar();
    }

    /**
     * Este método calcula la distancia euclidiana entre dos puntos 2D (coordenadas).
     * @param int posición del punto 1 en el ArrayList con referencia a Punto.
     * @param int posición del punto 2 en el ArrayList con referencia a Punto.
     * @return double distancia euclidiana.
     */
    public double calcularDistanciaEuclidiana(int pos1, int pos2){
        return this.get(pos1).distanciaEuclidiana(this.get(pos2));
    }
}
