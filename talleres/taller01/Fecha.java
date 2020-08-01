
/**
 * Está clase permite representar una fecha.
 * 
 * @author Valentina Moreno y Alejandra Palacio 
 * @version 27/07/2020
 */
public class Fecha
{
    /**
     * Este atributo corresponde al día de la fecha
     */
    private final int dia;
    /**
     * Este atributo corresponde al mes de la fecha
     */
    private final int mes;
    /**
     * Este atributo corresponde al año de la fecha
     */
    private final int anyo;

    /**
     * El constructor inicializa una fecha
     */
    public Fecha(int dia, int mes, int anyo){
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }

    /**
     * Este método retorna el entero que hace referencia al día de la fecha
     * @return int dia
     */
    public int dia(){
        return this.dia;
    }

    /**
     * Este método retorna el entero que hace referencia al mes de la fecha
     * @return int mes
     */
    public int mes(){
        return this.mes;
    }

    /**
     * Este método retorna el entero que hace referencia al año de la fecha
     * @return int anyo
     */
    public int anyo(){
        return this.anyo;
    }

    /**
     * Este método recibe una fecha y la compara con otra, retornando 0 si son iguales,
     * 1 si la recibida es menor y -1 si esta es mayor.
     * @param Fecha otra
     * @return int
     */
    public int comparar(Fecha otra){
        if(this.anyo < otra.anyo()){
            return -1;
        }else if(this.anyo > otra.anyo()){
            return 1;
        }else{
            if(this.mes < otra.mes()){
                return -1;
            }else if(this.mes > otra.mes()){
                return 1;
            }else{
                if(this.dia < otra.dia()){
                    return -1;
                }else if(this.dia > otra.dia()){
                    return 1;
                }else{
                    return 0;
                }
            }
        }
    }

    /**
     * Este método retorna la representación en cadena de la fecha.
     * @return String fecha
     */
    public String toString(){
        String dia1 = Integer.toString(dia);
        String mes1 = Integer.toString(mes);
        String anyo1 = Integer.toString(anyo);
        return anyo1+mes1+dia1;
    }
}