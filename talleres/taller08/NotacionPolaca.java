import java.util.ArrayList;
import java.util.Stack;

public class NotacionPolaca{

    private ArrayList<String> Notacion;
    private Stack<String> pila;

    public NotacionPolaca(ArrayList<String> Notacion){
        this.Notacion = Notacion;
        this.pila = new Stack<>();
    }

    public double notacion(){
        String derecha = "";
        String izquierda = "";
        
        for(String s: Notacion){
            if(operador(s)){
                derecha = pila.pop();
                izquierda = pila.pop();
                
                double resultado = operar(s, derecha, izquierda);
                pila.push("" + resultado);
                }
            else{
                pila.push(s);

            }
        }
        return Double.parseDouble(pila.pop());



        
    }

    private boolean operador(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%") || s.equals("^");
    }

    private double operar(String operand, String derecha, String izquierda){
        double izq = Double.parseDouble(izquierda);
        double der = Double.parseDouble(derecha);
        
        if(operand.equals("+")){
            return izq + der;
        }
        else if(operand.equals("-")){
            return izq - der;
        }
        else if(operand.equals("/")){
            return izq / der;
        }
        else if(operand.equals("*")){
            return izq * der;
        }
        else if(operand.equals("%")){
            return izq % der;
        }
        else if(operand.equals("^")){
            return Math.pow(izq, der);
        }
        else return -1.0;
    }
}

