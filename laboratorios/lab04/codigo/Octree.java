import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.IOException;
import java.util.Collections; 

/**
 *This is our data structure, Octree. This will be responsible for positioning each bee in a specific quadrant, 
 *so you can determine if it collides or not. Its main function will be divided into eight quadrants, in 3D. 
 *If more than one bee is found in a quadrant, this quadrant will be divided into multiple subOctrees, found 
 *in the limits of this, until the bee is alone, or within a diagonal quadrant of less than 100 meters in length. 
 *This is done to ensure that all the bees within this quadrant are in danger of colliding.
 *Nota-->para realizar esta implementación del Octree, se utilizó parte del código_estudiante dado por el docente.
 * @author: Daniel Otero Gomez, Rafael Mateus Carrion, Valentina Moreno Ramírez, Alejandra Palacio Jaramillo. 
 * @version: 2
 * @see Octree
 * @see abeja
 */

public class Octree
{
    /**
     *This will be the method that represents the Octree, on this method all the recursion will be done, here each bee will be assigned 
     *to its respective sector of the Octree, represented by an ArrayList of 8 spaces (each one representing each sector), where it will 
     *be stored in a LinkedList. The process of deciding which sector each bee goes to will be done by the hashing method. After each bee
     *is located in a sector it will happen to create the sub-views of the Octree with the new method Octree. Before going on to create 
     *the new subdivisions of the Octree, it is asked if the octual diagonal is less than 100 meters, if so it will start printing the 
     *bees located in the sectors where there is more than one bee.
     * @param LinkedList<abeja> abejas: ArrayList with all the bees.
     * @param double[] mins: they are the minimum values of latitude, length and height of bees´s coordinates.
     * @param double[] mids: they are the middle values of latitude, length and height of bees´s coordinates.
     * @see hashing
     * @see nuevoOct
     */
    public void octree(LinkedList<abeja> abejas, double [] mins, double[] mids, double [] maxs)throws Exception{
        LinkedList<abeja>[] octree = new LinkedList[8];
        for (int i=0; i<octree.length; i++) {
            LinkedList<abeja> abejasAux = new LinkedList();
            octree[i] = abejasAux;
        }       
        for (abeja a: abejas) {
            LinkedList<abeja> abejasAux = octree[hashing(a, mins, mids)];
            abejasAux.addFirst(a);
        }
        double diagonal=Math.sqrt(Math.pow(mids[0]*111111,2)+Math.pow(mids[1]*111111,2)+Math.pow(mids[2],2)); 
        if (diagonal<=100) {
            for (int i=0; i<octree.length; i++){
                LinkedList<abeja> abejasAux = octree[i];
                if(abejasAux.size()>0){
                    choque(abejasAux);
                }
            } 
            System.out.println("------------------------------------------");
        }else if(diagonal>100){
            for(LinkedList<abeja> list :octree){
                if(list.size()>=2){
                    nuevoOctree(list,mins,mids,maxs);
                }
            }
        }
    }

    /**
     *This method will be responsible for receiving each bee that is in the octree, and place it in a certain sector of the data structure, 
     *so that it will be located in the space of the ArrayList table corresponding to the sector in which the bee is positioned. Determine the 
     *sector by comparing the minimum, that is, the vertices of the Octree, plus the average values of the Octree with which it is being worked.
     * @param abeja abeja: abeja que sera ubicada.
     * @param ArrayList<Double> mins: this ArrayList will contain the minimum, that is, the vertex composed by each coordinate. This parameter 
     *is necessary to be able to make an appropriate location for each bee, because the use of this parameter will simplify the code so that only 
     *one value will have to be added to determine if a bee is in a sector or in other.
     * @return number of the sector the Bee is located in.
     */
    private int hashing(abeja abeja, double[] mins, double[] mids) {
        int hashNum = 0;
        if(abeja.getX()<=(mins[0] + mids[0]/2) && abeja.getY()<=(mins[1] + mids[1]/2) && abeja.getZ()<=(mins[2]+mids[2]/2)){
            hashNum = 0;
        }
        if(abeja.getX()<=(mins[0] + mids[0]/2) && abeja.getY()<=(mins[1] + mids[1]/2) && abeja.getZ()>(mins[2]+mids[2]/2)){
            hashNum = 1;
        }
        if(abeja.getX()<=(mins[0] + mids[0]/2) && abeja.getY()>(mins[1] + mids[1]/2) && abeja.getZ()<=(mins[2]+mids[2]/2)){
            hashNum = 2;
        }
        if(abeja.getX()<=(mins[0] + mids[0]/2) && abeja.getY()>(mins[1] + mids[1]/2) && abeja.getZ()>(mins[2]+mids[2]/2)){
            hashNum = 3;
        }
        if(abeja.getX()>(mins[0] + mids[0]/2) && abeja.getY()<=(mins[1] + mids[1]/2) && abeja.getZ()<=(mins[2]+mids[2]/2)){
            hashNum = 4;
        }
        if(abeja.getX()>(mins[0] + mids[0]/2) && abeja.getY()<=(mins[1] + mids[1]/2) && abeja.getZ()>(mins[2]+mids[2]/2)){
            hashNum = 5;
        }
        if(abeja.getX()>(mins[0] + mids[0]/2) && abeja.getY()>(mins[1] + mids[1]/2) && abeja.getZ()<=(mins[2]+mids[2]/2)){
            hashNum = 6;
        }
        if(abeja.getX()>(mins[0] + mids[0]/2) && abeja.getY()>(mins[1] + mids[1]) && abeja.getZ()>(mins[2]+mids[2]/2)){
            hashNum = 7;
        }
        return hashNum;
    }

    /**
     * This method is responsible for making the recursion, with respect to the main octree method. Receive the parameters corresponding to 
     *the bees located in the sector, and the vertices of this, which are in the ArrayLis mins. With the paramtero sector they identify how 
     *the vertices of the next sub-octree should be redefined, since these vary by sector.
     * @param LinkedList<Bee> abejas: bees of the corresponding sector
     * @param ArrayList<Double> mins: they are the minimum values of coordinates, to which other parameters will be added to redefine the 
     *vertex of the next Octree. Take it as if it were one of the vertex of the octree.
     * @param int sector: sector in which it is located.
     */
    public void nuevoOctree(LinkedList<abeja> abejas, double[] mins, double[] mids, double[]maxs) throws Exception{
        double min0 = 1000000;
        double min1 = 1000000;
        double min2 = 1000000;
        double max0 = -1000000;
        double max1 = 0;
        double max2 = 0;
        for(int i = 0; i<abejas.size(); i++){
            min0 = Math.min(min0,abejas.get(i).getX());
            min1 = Math.min(min1,abejas.get(i).getY());
            min2 = Math.min(min2,abejas.get(i).getZ());
            max0 = Math.max(max0,abejas.get(i).getX());
            max1 = Math.max(max1,abejas.get(i).getY());
            max2 = Math.max(max2,abejas.get(i).getZ());
        }
        double mid0 = max0-min0;
        double mid1 = max1-min1;
        double mid2 = max2-min2;
        mins[0] = min0;
        mins[1] = min1;
        mins[2] = min2;
        maxs[0] = max0;
        maxs[1] = max1;
        maxs[2] = max2;
        mids[0] = mid0/2;
        mids[1] = mid1/2;
        mids[2] = mid2/2;
        octree(abejas,mins,mids,maxs);
    }

    /**
     * This sector is in charge of printing all the coordinates of the bees of the sector, if it prints them is because
     * all these Bees are in risk of colliding.
     * @param LinkedList<Bee> abejas: bees of the sector
     */
    public void choque(LinkedList<abeja> abejas) {
        for (abeja abeja:abejas) {
            System.out.println(abeja.mostrarCoordenada());
        }
    }

    public static void main(String[]args) throws IOException, Exception{
        Reader rm = new Reader();
        System.out.println("Conjuntos de abejas que colisionarán");
        rm.leer("100abejas.txt");
    }

}