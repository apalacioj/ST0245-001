import java.util.Scanner;
import java.util.ArrayList;
/**
 * Esta clase presenta al usuario un menú tipo texto con el cual puede interactuar, según sea el caso.
 * 
 * @author Valentina Moreno y Alejandra Palacio.
 * @version 27/07/2020
 */
public class Principal
{
    /**
     * Este método permite representar un punto en 2D y, si el usuario quiere, aplicar las operaciones de este dato.
     */
    public static void representarPunto(){
        int cont = 1;
        System.out.println("¿Quiere crear un punto?");
        Scanner scan = new Scanner(System.in);
        String respuesta = scan.next();
        ArrayList <Punto> puntos = new ArrayList<>();
        while(respuesta.equalsIgnoreCase("si")){
            System.out.println("Ingrese las coordenadas x,y respectivamente: ");
            double x = scan.nextDouble();
            double y = scan.nextDouble();
            Punto p = new Punto(x,y);
            puntos.add(p);
            System.out.println("El punto de coordenadas ("+p.x()+","+p.y()+") ha sido creado. Es su punto número "+cont);
            cont++;
            System.out.println("¿Quiere crear otro punto?");
            respuesta = scan.next();
        }
        System.out.println("¿Quiere calcular el radio y ángulo polar de un punto?");
        respuesta = scan.next();
        while(respuesta.equalsIgnoreCase("si")){
            System.out.println("Indique el número del punto del cual quiere calcular su radio y ángulo polar");
            int num = scan.nextInt();
            double radio = puntos.get(num-1).radioPolar();
            double angulo = puntos.get(num-1).anguloPolar();
            System.out.println("El radio polar es igual a "+radio+" y el ángulo polar es igual a "+angulo);
            System.out.println("¿Quiere calcular esto nuevamente con otro punto?");
            respuesta = scan.next();
        }
        System.out.println("¿Quiere calcular la distancia euclidiana entre dos puntos?");
        respuesta = scan.next();
        while(respuesta.equalsIgnoreCase("si")){
            System.out.println("Indique los números de los puntos para calcular la distancia");
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            double distancia = puntos.get(num1-1).distanciaEuclidiana(puntos.get(num2-1));
            System.out.println("La distancia euclidiana entre estos dos puntos es "+distancia);
            System.out.println("¿Quiere calcular esto nuevamente con otros puntos?");
            respuesta = scan.next();
        }
        System.out.println("Fin del programa");
    }

    /**
     * Este método permite representar una fecha y, si el usuario quiere, aplicar las operaciones de este dato.
     */
    public static void representarFecha(){
        int cont = 1;
        System.out.println("¿Quiere crear una fecha?");
        Scanner scan = new Scanner(System.in);
        String respuesta = scan.next();
        ArrayList <Fecha> fechas = new ArrayList<>();
        while(respuesta.equalsIgnoreCase("si")){
            System.out.println("Ingrese el día, mes y año de la fecha, respectivamente: ");
            int dia = scan.nextInt();
            int mes = scan.nextInt();
            int anyo = scan.nextInt();
            Fecha f = new Fecha(dia,mes,anyo);
            fechas.add(f);
            System.out.println("La fecha "+f.toString()+" ha sido creada. Es su fecha número "+cont);
            cont++;
            System.out.println("¿Quiere crear otra fecha?");
            respuesta = scan.next();
        }
        System.out.println("¿Quiere comparar una fecha con otra?");
        respuesta = scan.next();
        while(respuesta.equalsIgnoreCase("si")){
            System.out.println("Indique los números de las fechas para compararlas");
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            int c = fechas.get(num1-1).comparar(fechas.get(num2-1));
            if(c == -1){
                System.out.println("La fecha "+fechas.get(num1-1).toString()+" es menor que la fecha "+fechas.get(num2-1).toString());
            }else if(c == 1){
                System.out.println("La fecha "+fechas.get(num2-1).toString()+" es mayor que la fecha "+fechas.get(num1-1).toString());
            } else{
                System.out.println("Las fechas son iguales");
            }
            System.out.println("¿Quiere comparar otras fechas?");
            respuesta = scan.next();
        }
        System.out.println("Fin del programa");
    }
    
    /**
     * Este método permite representar una línea en 2D y, si el usuario quiere, aplicar las operaciones de este dato.
     */
    public static void representarLine2D(){
        int cont = 1;
        System.out.println("¿Quiere crear una línea 2D?");
        Scanner scan = new Scanner(System.in);
        String respuesta = scan.next();
        ArrayList <Line2D> lineas = new ArrayList<>();
        while(respuesta.equalsIgnoreCase("si")){
            System.out.println("Ingrese las coordenadas x,y del primer punto, respectivamente: ");
            double x1 = scan.nextDouble();
            double y1 = scan.nextDouble();
            System.out.println("Ingrese las coordenadas x,y del segundo punto, respectivamente: ");
            double x2 = scan.nextDouble();
            double y2 = scan.nextDouble();
            Punto p1 = new Punto(x1,y1);
            Punto p2 = new Punto(x2,y2);
            Line2D l = new Line2D(p1,p2);
            lineas.add(l);
            System.out.println("La línea 2D con coordenadas en ("+p1.x()+","+p1.y()+") ("+p2.x()+","+p2.y()+
            ") ha sido creada. Es su línea número "+cont);
            cont++;
            System.out.println("¿Quiere crear otra línea?");
            respuesta = scan.next();
        }
        System.out.println("¿Quiere calcular los puntos intermedios que son coordenadas enteras en una línea?");
        respuesta = scan.next();
        while(respuesta.equalsIgnoreCase("si")){
            System.out.println("Indique el número de la línea");
            int num = scan.nextInt();
            System.out.println("Las coordenadas enteras que pertenecen a la línea son: ");
            lineas.get(num-1).imprimirCoordenadas(lineas.get(num-1).puntosIntermedios());
            System.out.println("¿Quiere calcular los puntos de otra línea?");
            respuesta = scan.next();
        }
        System.out.println("Fin del programa");
    }
}

