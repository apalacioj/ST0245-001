import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections; 
/**
 * This class is responsible for reading a text file containing an indeterminate number of 
 *bees, identifying their coordinates and storing them in a LinkedList of Bee objects. 
 *Likewise, it is responsible for saving the coordinates of each bee in other LinkedList 
 *corresponding to each coordinate, so that it can be passed to the Octree class, which needs 
 *them to function.
 * @author: Daniel Otero Gomez, Rafael Mateus Carrion, Alejandra Palacio, Valentina Moreno.
 * @version: 2
 * @see Octree
 * @see Bee
 */
public class Reader
{
    //Arrays that save the Bees and the coordinates
    LinkedList<Double> lat = new LinkedList();
    LinkedList<Double> lon = new LinkedList();
    LinkedList<Double> alt = new LinkedList();
    LinkedList<abeja> bees=new LinkedList();
    /**
     * This method is in charge of recieving an adress of where the file is, 
     * and it reads each line in order to pass them to a method that can save 
     * this information in its corresponding LinkedList.
     * @param String dir: adress of where the file is
     * @see splitString
     */
    public void leer (String dir) throws IOException{
        try (BufferedReader br=new BufferedReader(new FileReader(dir))){
            String line;
            while ((line=br.readLine())!=null){
                splitString(line);
            } 
            System.out.println("Si encontró el archivo");
        } catch (IOException e){
            e.printStackTrace();
        }
        getMaxMin();
    }    

    /**
     * This method is in charge of recieving each line of coordinates that is being
     * given by the method leer, here it will save the coordinates in its respective
     * LinkedList, and it will create a Bee with its coordiantes and adds it to the LinkedList.
     * @param String s: line of coordinates
     */
    public void splitString(String s){
        String [] str=s.split(",");  
        try{
            this.lat.addFirst(Double.parseDouble(str[0]));
            this.lon.addFirst(Double.parseDouble(str[1]));
            this.alt.addFirst(Double.parseDouble(str[2]));
            abeja bee=new abeja(Double.parseDouble(str[0]),Double.parseDouble(str[1]),Double.parseDouble(str[2]));
            bees.addFirst(bee);
        } catch (Exception e){
        }
    }

    /**
     *This method is responsible for obtaining the minimum and maximum of each coordinate, so we can estimate 
     *the length of the diagonals that will be created in the first division of the Octree, and determine if 
     *it is worth creating an Octree with this data set. Likewise, this is the last step of this class before we
     *start working with our Octree data structure. If it is not worth creating the Octree (because the length of 
     *its diagonals will be less than 100m) it will be printed all the coordinates of the bees of the data set.
     * @see choque
     */
    public void getMaxMin(){
        double minlat=(double)Collections.min(lat);
        System.out.println("La latitud minima es: "+minlat);
        double maxlat=(double)Collections.max(lat);

        double minlon=(double)Collections.min(lon);
        System.out.println("La longitud minima es: "+minlon);
        double maxlon=(double)Collections.max(lon);

        double minalt=(double)Collections.min(alt);
        System.out.println("La altura minima es: "+minalt);
        double maxalt=(double)Collections.max(alt);

        double [] mins = new double[3];
        mins[0] = minlat;
        mins[1] = minlon;
        mins[2] = minalt;
        double midlat=(maxlat-minlat)/2;
        double midlon=(maxlon-minlon)/2;
        double midalt=(maxalt-minalt)/2;
        double [] mids = new double[3];
        mids[0] = midalt;
        mids[1] = midlon;
        mids[2] = midalt;
        double ph=Math.sqrt(Math.pow((mids[0])*111325,2)+Math.pow((mids[1])*111325,2));
        double diagonal=Math.sqrt(Math.pow(ph,2)+Math.pow((mids[2]),2));
        if (diagonal>100) {
            Octree arbol=new Octree();
            arbol.octree(bees,mins,mids);
        } else {
            choque();
        }
    }

    /**
     * This method is in charge of printing all the Bees of this data set,
     * if it prints them is because all these Bees are in danger of colliding.
     */
    public void choque() {
        System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse");
        for (abeja a: bees) {
            abeja bee=bees.poll();
            System.out.println(bee.getX()+","+bee.getY()+","+bee.getZ());
        }
    }
}
