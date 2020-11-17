import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
/**
 * Esta cláse será la base para crear el árbol en la clase principal y además de ser cada nodo del árbol.
 * @author Valentina Moreno y Alejandra Palacio 
 * @version 1
 */
public class Tree{

    /**
     * Nodo izquierdo del nodo actual
     */
    private Tree treeleft;
    /**
     * Nodo derecho del nodo actual
     */
    private Tree treeright;
    /**
     * Condición del nodo actual 
     */
    private Gini condition;
    /**
     * Archivo de datos a los que se les ejecutará la condición para realizar la división
     */
    private List<List<String>> file;
    
    private String leftOrRight;

    /**
     * Constructor vacío de la clase árbol
     */
    public Tree(){

    }

    /**
     * Constructor de la clase árbol 
     * @param file archivo de datos que tendrá el nodo
     * @param root ancestro del nodo a crear
     */
    public Tree(List<List<String>> file, String leftOrRight){
        this.file = file;
        this.treeleft = null;
        this.treeright = null;
        this.condition = null;
        this.leftOrRight = leftOrRight;
    }
    
    /**
     * Constructor de la clase árbol 
     * @param file archivo de datos que tendrá el nodo
     * @param root ancestro del nodo a crear
     */
    public Tree(List<List<String>> file){
        this.file = file;
        this.treeleft = null;
        this.treeright = null;
        this.condition = null;
        this.leftOrRight = null;
    }

    /**
     * Constructor de la clase árbol
     * @para file archivo de datos del nodo
     * @treeleft nodo izquierdo del nodo actual 
     * @treeright nodo derecho del nodo actual
     * @condition condición del nodo actual
     */
    public Tree(List<List<String>> file, Tree treeleft, Tree treeright, Gini condition, String leftOrRight){
        this.file = file;
        this.condition = condition;
        this.treeleft = treeleft;
        this.treeright = treeright;
        this.leftOrRight = leftOrRight;
    }

    /**
     * Este será un getter que retornara el archivo de datos de la instancia invocada
     * @return archivo de datos
     */
    public List<List<String>> getFile(){
        return this.file;
    }

    /**
     * Este será un setter que reemplazará el valor actual de la condición
     * @param condition nuevo valor de la condición
     */
    public void setCondition(Gini condition){
        this.condition = condition;
    }

    /**
     * Este será un getter que retornara el valor de la condición de la instancia invocada
     * @return valor del gini 
     */
    public Gini getCondition(){
        return this.condition;
    }

    /**
     * Este será un setter que reemplazará el valor actual de el árbol derecho
     * @param treeRight nuevo valor del árbol derecho
     */
    public void setTreeRight(Tree treeright){
        this.treeright = treeright;
    }

    /**
     * Este será un setter que reemplazará el valor actual de el árbol izquierdo
     * @param treeleft nuevo valor del árbol izquierdo 
     */
    public void setTreeLeft(Tree treeleft){
        this.treeleft = treeleft;
    }

    /**
     * Este será un getter que retornara el valor del árbol derecho de la instancia invocada
     * @return árbol derecho 
     */
    public Tree getTreeRight(){
        return this.treeright;
    }

    /**
     * Este será un getter que retornara el valor del árbo izquierdo de la instancia invocada
     * @return árbol izquierdo
     */
    public Tree getTreeLeft(){
        return this.treeleft;
    }

    /**
     * Este será un getter que retornara el lado en el que se encuentra un nodo respecto a su primer ancestro.
     * @return lado en el que se encuentra un nodo respecto a su primer ancestro.
     */
    public String getleftOrRight(){
        return this.leftOrRight;
    }

    /**
     * Este será un setter que reemplazará el lado del nodo respecto a su primer ancestro.
     * @param leftOrRight lado del nodo respecto a su primer ancestro.
     */
    public void setleftOrRight(String leftOrRight){
        this.leftOrRight = leftOrRight;
    }

    /**
     * Este método nos permitirá crear la raíz del árbol
     * @param file archivo de datos 
     * @param root nodo que será la raíz
     * @return árbol
     */
    public Tree createRoot(List<List<String>> file, Tree root, String leftOrRight){
        root = new Tree(file);
        HashSet conditions = new HashSet();
        ImpurezaGini giniImpurity = new ImpurezaGini();

        conditions = giniImpurity.conditions(file, root.createNodeTree(file).getColumn());
        giniImpurity.getMinGini(file,conditions,root.createNodeTree(file).getColumn());
        Gini condition = giniImpurity.bestGini(giniImpurity.getGinis());

        root.setCondition(condition);
        root.setleftOrRight(leftOrRight);

        return root;

    }

    /**
     * Esté método nos permitirá conseguir la mejor condición para cada nodo
     * @param file archivo de datos
     * @return el mejor gini 
     */
    public Gini createNodeTree(List<List<String>> file){
        int[] column = {65,66,67,68,69,70,71,72};
        HashSet conditions = new HashSet();
        ImpurezaGini giniImpurity = new ImpurezaGini();
        Gini condition = new Gini();

        for(int i = 0; i < 8; i++){
            conditions = giniImpurity.conditions(file, column[i]);
            giniImpurity.getMinGini(file,conditions,column[i]);
            condition = giniImpurity.bestGini(giniImpurity.getGinis());
        }
        return condition;
    }

    /**
     * Este método nos permitirá realizar la división izquierda del árbol binario de 
     * decisión
     * @param file archivo de datos 
     * @param condition condición del nodo 
     * @return nodo izquierdo
     */
    public Tree leftDivision(List<List<String>> file, Gini condition){
        List<List<String>> leftDivision = new ArrayList<>(); 
        leftDivision.add(file.get(0));
        boolean a = true;
        boolean firstTime = true;

        for(int i = 1; i < file.size(); i++){
            try{
                double n = Double.parseDouble(file.get(i).get(condition.getColumn()));
                a = false;
            }catch(NumberFormatException e){
                a = true;
            }

            if(a == true){
                if(file.get(i).get(condition.getColumn()).equals("")){
                    continue;
                }else if(file.get(i).get(condition.getColumn()).equals(condition.getCondition())){
                    leftDivision.add(file.get(i));
                }
            }else{
                if(file.get(i).get(condition.getColumn()).equals("")){
                    continue;
                }else if(Double.parseDouble(file.get(i).get(condition.getColumn())) >= Double.parseDouble(condition.getCondition())){
                    leftDivision.add(file.get(i));
                }
            }
        }
        return new Tree(leftDivision, "left");
    }

    /**
     * Este método nos permitirá realizar la división derecha del árbol binario de 
     * decisión
     * @param file archivo de datos 
     * @param condition condición del nodo 
     * @return nodo derecho
     */    
    public Tree rightDivision(List<List<String>> file, Gini condition){
        List<List<String>> rightDivision = new ArrayList<>();
        rightDivision.add(file.get(0));
        boolean a = true;
        boolean firstTime = true;

        for(int i = 1; i < file.size(); i++){           
            try{
                double n = Double.parseDouble(file.get(i).get(condition.getColumn()));
                a = false;
            }catch(NumberFormatException e){
                a = true;
            }

            if(a == true){
                if(file.get(i).get(condition.getColumn()).equals("")){
                    continue;
                }else if(file.get(i).get(condition.getColumn()).equals(condition.getCondition())){
                    continue;
                }
                else{
                    rightDivision.add(file.get(i));
                }
            }else{
                if(file.get(i).get(condition.getColumn()).equals("")){
                    continue;
                }else if(Double.parseDouble(file.get(i).get(condition.getColumn())) < Double.parseDouble(condition.getCondition())){
                    rightDivision.add(file.get(i));
                }
            }
        }
        return new Tree(rightDivision, "right");
    }
}