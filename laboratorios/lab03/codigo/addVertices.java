import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;
/**
 * Está clase nos permitirá leer un documento con vértices y agregarlos a un vector dinámico.
 * @author Alejandra Palacio y Valentina Moreno 
 * @version 27/09/2020
 */
public class addVertices extends ArrayList<Vertices>{

    /**
     * Este es un arraylist que nos servirá para un caso específico que será cuando la línea leída tiene un dato extra, este se almacenará en este arraylist 
     */
    ArrayList <String> Barrio = new ArrayList<String>();


    /**
     * Este método nos permite leer un archivo txt preestablecido que contiene la información de cada vertice dado y lo guarda en un ArrayList
     * @throws FileNotFoundException 
     * @throws IOException
     * @throws NoSuchElementException
     */
    public void addData() throws FileNotFoundException, IOException,NoSuchElementException{
        String data;
        String nombre;
        FileReader f = new FileReader("Vertices.txt");
        BufferedReader b = new BufferedReader(f);
        while((data = b.readLine())!=null) {
            try {
                Scanner scan1 = new Scanner(data);
                String temp1 = scan1.next();
                String temp2 = scan1.next();
                String temp3 = scan1.next();

                if(scan1.hasNext()){
                    nombre = scan1.next();
                    Barrio.add(nombre);
                }
                else{
                    Barrio.add(null);
                }

                long vertice = Long.parseLong(temp1);
                double x = Double.parseDouble(temp2);
                double y = Double.parseDouble(temp3);
                                                                

                this.add(new Vertices(vertice,x,y));

            }
            catch (NoSuchElementException err){
                continue;
            }
        }
        b.close();
    }
}
