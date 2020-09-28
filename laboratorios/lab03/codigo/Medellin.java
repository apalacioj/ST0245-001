import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.lang.NumberFormatException;

public class Medellin extends ArrayList<Coordenadas>{

    ArrayList <String> Barrio = new ArrayList<String>();

    public void addData() throws FileNotFoundException, IOException,NoSuchElementException{
        String data;
        String nombre;
        FileReader f = new FileReader("Medellin.txt");
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
                                                                    //O(n+m) donde n es el número de líneas del archivo y m el número de palabras.

                this.add(new Coordenadas(vertice,x,y));

            }
            catch (NoSuchElementException err){
                continue;
            }
            catch(NumberFormatException err2){
                continue;
            }
        }
        b.close();
    }
}
