import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
/**
 * Esta clase tendrá un método que será capaz de leer cualquier archivo cvs que el usuario le pase
 * @author Alejandra Palacio y Valentina Moreno 
 * @date 16/08/20
 */
public class ReadCSV {
    /**
     * Este atributo es el delimitador que le indicará al programa cuando este cambie de palabra
     */
    public static final String COMMA_DELIMITER = ";";

    /**
     * Este método le preguntará al usuario el nombre del archivo cvs que desee leer y procederá a guardarlos en un arraylist doble que después retornará 
     * @param filename
     * @return List<List<String>> 
     */
    public static List<List<String>> readCSV(String filename) {
        List<List<String>> register = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(filename))) {
            String file;
            while ((file = buffer.readLine()) != null) {
                String[] columns = file.split(COMMA_DELIMITER);
                register.add(Arrays.asList(columns));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch(Exception e) {
            System.out.println("Program not running");
        }
        return register;
    }
}

