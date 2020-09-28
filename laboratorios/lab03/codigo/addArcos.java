import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * Está clase nos permitirá leer un documento con arcos y agregarlos a un vector dinámico.
 * @author Alejandra Palacio y Valentina Moreno 
 * @version 27/09/2020
 */
public class addArcos extends ArrayList<Arcos> {

    /**
     * Este método nos permite leer un archivo txt preestablecido que contiene la información de cada vertice dado y lo guarda en un ArrayList
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NoSuchElementException
     */
    public void addData() throws FileNotFoundException, IOException,NoSuchElementException{
        String data;
        FileReader f = new FileReader("Arcos.txt");
        BufferedReader b = new BufferedReader(f);
        while((data = b.readLine())!=null) {
            try {
                Scanner scan1 = new Scanner(data);
                String temp1 = scan1.next();
                String temp2 = scan1.next();
                String temp3 = scan1.next();
                String temp4 = scan1.next();

                int ID1 = Integer.parseInt(temp1);
                int ID2 = Integer.parseInt(temp2);
                double distance = Double.parseDouble(temp3);
                                                                

                this.add(new Arcos(ID1,ID2,distance,temp4));

            }
            catch (NoSuchElementException err){
                continue;
            }
        }
        b.close();
    }
}
