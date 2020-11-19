import java.util.List;
import java.util.ArrayList;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import javafx.util.Pair;

/**
 * Está clase principal permite crear el árbol binario de decisión, entrenarlo y validarlo con nuevos datasets para calcular el porcentaje de exactitud,
 * precisión y sensibilidad del mismo. Adicionalmente, también se calculará el tiempo de ejecución y el consumo de memoria de este algoritmo.
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo 
 * @version 1
 */
public class Principal{
    /**
     * Este método permite crear el arbol recursivamente con un conjunto de datos dado, y una altura especifica.
     * @param file archivo de datos
     * @param root nodo raíz del árbol
     * @param height altura del árbol
     * @return árbol creado con los datos clasificados en sus respectivos nodos terminales.
     */
    public Tree buildTree(List<List<String>> file, Tree root, int height){
        Tree tempRootLeft = new Tree();
        Tree tempRootRight = new Tree();

        if(file.isEmpty()){
            return null;
        }

        root = root.createRoot(file, root, root.getleftOrRight());

        root.setTreeLeft(root.leftDivision(file,root.getCondition()));
        root.setTreeRight(root.rightDivision(file,root.getCondition()));

        tempRootLeft = root.getTreeLeft();
        tempRootRight = root.getTreeRight();

        if(root.getCondition().getGini() == 0 || height == 0){
            Tree tempTree = new Tree(root.getFile(), null, null, root.getCondition(), root.getleftOrRight());
            return tempTree;
        }

        Gini conditionLeft = new Gini(tempRootLeft.createNodeTree(tempRootLeft.getFile()));
        tempRootLeft.setCondition(conditionLeft);

        Gini conditionRight = new Gini(tempRootRight.createNodeTree(tempRootRight.getFile()));
        tempRootRight.setCondition(conditionRight);

        tempRootLeft.setTreeLeft(root.leftDivision(tempRootLeft.getFile(),conditionLeft));
        tempRootLeft.setTreeRight(root.rightDivision(tempRootLeft.getFile(),conditionLeft));

        tempRootRight.setTreeLeft(root.leftDivision(tempRootRight.getFile(),conditionRight));
        tempRootRight.setTreeRight(root.rightDivision(tempRootRight.getFile(),conditionRight));

        root.setTreeLeft(tempRootLeft);
        root.setTreeRight(tempRootRight);

        root.setTreeLeft(buildTree(root.getTreeLeft().getFile(),root.getTreeLeft(),height-1));
        root.setTreeRight(buildTree(root.getTreeRight().getFile(),root.getTreeRight(),height-1));

        return root;
        //Complejidad asintótica para el peor de los casos es O(2^n), donde n es el número de columnas, es decir, el número de variables posibles a evaluar
    }

    /**
     * Este método permite validar el árbol creado con unos nuevos datos testing
     * @param student fila del archivo de datos que contiene información de un estudiante
     * @param root árbol de decisión creado con el archivo de datos de entrenamiento
     * @return predicción de exito académico para cada estudiante
     */
    public int validateTree(List<String> student, Tree root){
        if(root.getTreeRight() == null && root.getTreeLeft() == null){
            return count(root);

        }else if(root != null){
            if(match(student, root.getCondition())){
                return validateTree(student, root.getTreeLeft());
            }else{
                return validateTree(student, root.getTreeRight());
            }
        }
        else{
            return 0;
        }
        //O(n), donde n es la complejidad del método counts(), es decir, el número de filas de la matriz en una hoja del árbol.
    }

    /**
     * Este método es un método auxiliar para validar si la condición del nodo en el que se encuentra es mayor al del valor que sacó el estudiante
     * y así determinar cuál será el próximo nodo a evaluar para obtener la predicción final.
     * @param student fila con los datos del estudiante a evaluar
     * @param condition condición que se va a tener en cuenta
     * @return boolean true si el estudiante aprueba con la condición dada
     */
    public boolean match(List<String> student, Gini condition){
        double value = Double.parseDouble(student.get(condition.getColumn()));
        if(value >= Double.parseDouble(condition.getCondition())){
            return true;
        }
        else{
            return false;
        }
        //O(1)
    }

    /**
     * Este método permite predecir si la hoja tuvo mayor cantidad de exito o de fracaso y así, decidir si el estudiante tendrá éxito o fracaso.
     * @param leaf hoja que se evaluará
     * @return 1, en caso de tener éxito; 0, en caso de tener fracaso
     */
    public int count(Tree leaf){
        int predictions = 0;
        int exit = 0;
        int nonexit = 0;

        for(int i = 1; i < leaf.getFile().size(); i++){
            if(Integer.parseInt(leaf.getFile().get(i).get(leaf.getFile().get(0).size()-1)) == 1){
                exit++;
            }
            else nonexit++;
        }

        if(exit>=nonexit){
            predictions = 1;
        }else{
            predictions = 0;
        }
        return predictions;
        //O(n), donde n es la longitud de la matriz que contiene la hoja
    }

    /**
     * Este método calcula e imprime el éxito, la precisión y la sensibilidad del árbol luego de validar los datos.
     * @param testFile archivo de datos testing
     * @param trainTree árbol de decisión con el que se validarán los datos.
     */
    public void results(List<List<String>> testFile, Tree trainTree){
        String[][] results = new String[testFile.size()][2];
        double truepositive = 0;
        double truenegative = 0;
        double falsepositive = 0;
        double falsenegative = 0;
        double exit = 0;
        double nonexit = 0;
        double total = 0;

        for(int i = 1; i<testFile.size(); i++){
            results[i][0] = testFile.get(i).get(77);
            int validate = validateTree(testFile.get(i), trainTree);
            if(validate == 1){
                exit+=1;
                results[i][1] = "1";
            }else{
                nonexit+=1;
                results[i][1] = "0";
            }

            if(results[i][0].equals(results[i][1])){
                if(results[i][0].equals("1")){
                    truepositive+=1;
                }else{
                    falsenegative+=1;
                }
            }else{
                if(results[i][0].equals("0")){
                    falsepositive+=1;
                }else{
                    truenegative+=1;
                }
            }
        }

        total = truepositive+truenegative+falsepositive+falsenegative;
        double exitRecall = truepositive/(truepositive+falsenegative);
        double failureRecall = falsenegative/(truepositive+falsenegative);
        double acurrency = (truepositive+falsenegative)/total;
        double precision = truepositive/(truepositive+falsepositive);

        System.out.println("Total students: "+ total);
        System.out.println("Acurrency:" + ((Math.round(acurrency*100d)/100d)*100) + "%");
        System.out.println("Precision:" + ((Math.round(precision*100d)/100d)*100) + "%");
        System.out.println("Recall:" + ((Math.round(exitRecall*100d)/100d)*100) + "%");
        System.out.println("Recall:" + ((Math.round(failureRecall*100d)/100d)*100) + "%");
        //O(n*m), donde n es el número de filas y m el número de columnas.
    }

    /**
     * Este método main, predice con base en los resultados de las pruebas Saber 11, el resultado 
     * de un estudiante en las pruebas Saber Pro, usando árboles binarios de decisión.
     * @param String [] args
     */
    public static void main(String[]args){
        MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
        MemoryUsage memoryStart , memoryEnd;
        memoryStart = mbean.getHeapMemoryUsage();
        ImpurezaGini ig = new ImpurezaGini();
        long ti = System.currentTimeMillis();
        List<List<String>> file = ig.readCSV("train15000.csv");
        System.out.println("Leyó");
        Tree root = new Tree();
        Principal main = new Principal();
        root = main.buildTree(file, root, 4);
        System.out.println("Construyó el árbol");
        ImpurezaGini ig1 = new ImpurezaGini();
        List<List<String>> testFile = ig1.readCSV("test5000.csv");
        main.results(testFile, root);
        long tf = System.currentTimeMillis();
        memoryEnd = mbean.getHeapMemoryUsage();
        System.out.println("Code implementation time: "+((tf-ti)/1000)+"s");
        System.out.println("Memory comsuption: "+((memoryEnd.getUsed()-memoryStart.getUsed())/1000000)+"mb");
    }
}
