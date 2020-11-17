import java.util.List;
import java.util.ArrayList;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 * Write a description of class Principal here.
 * 
 * @author Valentina Moreno y Alejandra Palacio 
 * @version 13/11/2020
 */
public class Principal
{
    public int cont = 0;
    public ArrayList<Tree> leftLeafs = new ArrayList<>();
    public ArrayList<Tree> rightLeafs = new ArrayList<>();
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
            if(root.getleftOrRight().equals("left")){
                leftLeafs.add(tempTree);
            }else{
                rightLeafs.add(tempTree);
            }
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
    }

    public void results(ArrayList<Tree> leftLeafs, ArrayList<Tree> rightLeafs){
        double truepositive = 0;
        double truenegative = 0;
        double falsepositive = 0;
        double falsenegative = 0;
        double contLeft = 0;
        double contRight = 0;
        for(int i = 0; i<leftLeafs.size(); i++){
            List<List<String>> aux = new ArrayList<>();
            aux = leftLeafs.get(i).getFile();
            for(int j = 1; j<aux.size(); j++){
                contLeft++;
                if(aux.get(j).get(77).equals(("1"))){
                    falsepositive++;
                }else{
                    falsenegative++;
                }
            }
        }

        for(int i = 0; i<rightLeafs.size(); i++){
            List<List<String>> aux = new ArrayList<>();
            aux = rightLeafs.get(i).getFile();
            for(int j = 1; j<aux.size(); j++){
                contRight++;
                if(aux.get(j).get(77).equals(("0"))){
                    truepositive++;
                }else{
                    truenegative++;
                }
            }
        }

        double total = contLeft+contRight;
        double acurrencyAux = truepositive+falsepositive;
        double acurrency = (acurrencyAux/total)*100;
        double precision = (truepositive/acurrencyAux)*100;
        double recallAux = truepositive+truenegative;
        double recall = (truepositive/recallAux)*100;
        System.out.println("Total de datos: "+ total);
        System.out.println("Acurrency:" + acurrency);
        System.out.println("Precision:" + precision);
        System.out.println("Recall:" + recall);
    }

    public static void main(String[]args){
        MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
        MemoryUsage memoryStart , memoryEnd;
        memoryStart = mbean.getHeapMemoryUsage();
        ImpurezaGini ig = new ImpurezaGini();
        long ti = System.currentTimeMillis();
        List<List<String>> file = ig.readCSV("5000.csv");
        Tree root = new Tree();
        Principal main = new Principal();
        root = main.buildTree(file, root, 2);
        main.results(main.leftLeafs, main.rightLeafs);
        long tf = System.currentTimeMillis();
        memoryEnd = mbean.getHeapMemoryUsage();
        System.out.println("Code implementation time: "+((tf-ti)/1000)+"s");
        System.out.println("Memory comsuption: "+((memoryEnd.getUsed()-memoryStart.getUsed())/1000000)+"mb");
    }
}